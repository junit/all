package com.mokylin.game.core.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.ProvidedBy;
import com.google.inject.Provider;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Named;

class ServiceProvider implements Provider<Service> {
	@Override
	public Service get() {
		return new Service();
	}
}

@ProvidedBy(ServiceProvider.class)
class Service {
	@Named("log")
	public void sayHello() {
		System.out.println(String.format("[%s#%d] execute %s at %d", this.getClass().getSimpleName(), hashCode(), "sayHello", System.nanoTime()));
	}
}

class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.err.println("invoke " + invocation.getMethod().getName());
		Object ret = null;
		try {
			before(invocation);
			ret = invocation.proceed();
		} finally {
			after(invocation);
		}
		return ret;
	}

	private void after(MethodInvocation invocation) {
		// System.err.println("after " + invocation.getMethod().getName());
	}

	private void before(MethodInvocation invocation) {
		// System.err.println("before " + invocation.getMethod().getName());
	}
}

public class Main {
	public static void main(String[] args) {
		Injector inj = Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bindInterceptor(Matchers.subclassesOf(Service.class), Matchers.any(), new MyMethodInterceptor());
			}
		});
		Service demo = inj.getInstance(Service.class);
		demo.sayHello();
	}
}

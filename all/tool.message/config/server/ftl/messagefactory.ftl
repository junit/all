package message;

import com.google.inject.Singleton;

@Singleton
public class MessageFactoryImpl implements MessageFactory {

	@Override
	public Message newInstance(int id) {
		switch (id) {<#list details as detail>
		case ${detail.id?c}: return new logic.${detail.pkg}.message.${detail.name}Message();</#list>
		}
		return null;
	}

}

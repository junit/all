package com.moloong.bleach.robot;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.game.command.Handler;
import com.game.message.Message;
import com.moloong.bleach.manager.ManagerPool;
import com.moloong.bleach.player.structs.Player;
import com.moloong.bleach.server.GameServer;
import com.moloong.bleach.utils.RandomUtils;

class Data {
	private Class<?> message;
	private Class<?> handler;
	private IHandlerIniter initer;
	public Data(Class<?> message, Class<?> handler, IHandlerIniter initer) {
		this.message = message;
		this.handler = handler;
		this.initer = initer;
	}
	public Handler createHandler(Player player) throws Exception {
		Handler ret = (Handler) handler.newInstance();
		ret.setMessage((Message) message.newInstance());
		ret.setExecutor(player);
		return ret;
	}
	public IHandlerIniter getIniter() {
		return initer;
	}
	
}

public class RobotThread implements Runnable {
	private static Logger logger = Logger.getLogger(RobotThread.class);

	private Vector<Integer> ids = new Vector<>();
	private ConcurrentHashMap<Integer, Data> initers = new ConcurrentHashMap<>();
	
	private void register(int id, Class<?> messageClass, Class<?> handlerClass, IHandlerIniter initer) {
		ids.add(id);
		initers.put(id, new Data(messageClass, handlerClass, initer));
	}


	@Override
	public void run() {
		while (true) {
			try {
				List<Player> list = ManagerPool.getInstance().playerManager.getOnlinePlayerList();
				for (Player player : list) {
					timer(player);
				}
				Thread.sleep(1000);
			} catch (Exception e) {
				logger.error(e, e);
			}
		}
	}

	private void timer(Player player) throws Exception {
		Handler handler = selectHandler(player);
		GameServer.getInstance().addNetCommand(player, handler);
	}

	private Handler selectHandler(Player player) throws Exception {
		Integer id = ids.get(RandomUtils.random(ids.size()));
		Data data = initers.get(id);
		Handler handler = data.createHandler(player);
		initers.get(id).getIniter().init(handler);
		return handler;
	}
	
	public RobotThread() {
	<#list details as detail>
		register(${detail.id}, ${detail.msgName}.class, ${detail.handlerName}.class, new com.moloong.bleach.robot.initer.${detail.name}HandlerIniter());
		</#list>
	}
}

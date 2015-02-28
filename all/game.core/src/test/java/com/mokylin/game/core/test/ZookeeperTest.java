package com.mokylin.game.core.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

class MyWatcher implements Watcher {
	private ZooKeeper zooKeeper;
	private String path;
	private int id;
	public MyWatcher(ZooKeeper zooKeeper, String path, int id) {
		this.zooKeeper = zooKeeper;
		this.path = path;
		this.id = id;
	}

	@Override
	public void process(WatchedEvent arg0) {
		try {
			System.err.println(id + ":" + new String(zooKeeper.getData(path, false, null),"UTF-8"));
			zooKeeper.exists(path, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ZookeeperTest {

	public static void main(String[] args) throws Exception {
		{
			ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 110, new Watcher() {
				@Override
				public void process(WatchedEvent arg0) {
					System.err.println(arg0);
				}
			});
			
			zooKeeper.getChildren("/root", new MyWatcher(zooKeeper, "/root", 1));
//			zooKeeper.exists("/root", new MyWatcher(zooKeeper, "/root", 1));
		}
		
		{
			ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2182", 110, new Watcher() {
				@Override
				public void process(WatchedEvent arg0) {
					System.err.println(arg0);
				}
			});
			
			zooKeeper.exists("/root", new MyWatcher(zooKeeper, "/root", 2));
		}
		
		{
			ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2183", 110, new Watcher() {
				@Override
				public void process(WatchedEvent arg0) {
					System.err.println(arg0);
				}
			});
			
			zooKeeper.exists("/root", new MyWatcher(zooKeeper, "/root", 3));
		}
		
		for (;;) {
			Thread.sleep(1000);
		}
//		zooKeeper.close();
	}

}

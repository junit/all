package com.mokylin.game.server.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BaseDao<T> {
	private SqlSessionFactory factory = DbFactory.getInstance()
			.getDataFactory();
	private final static int INSERT_DELAY = 50;
	private final static int DELETE_DELAY = 10;
	private final static int UPDATE_DELAY = 10;
	private final static int SELECT_DELAY = 10;

	protected List<T> selectListWithTimeCheck(String arg) {
		long s = System.currentTimeMillis();
		SqlSession session = factory.openSession();
		try {
			List<T> list = session.selectList(arg);
			long interval = System.currentTimeMillis() - s;
			if (interval > SELECT_DELAY) {
				com.mokylin.game.server.logger.GlobalLogger.db
						.error(new StringBuilder().append(arg).append(":")
								.append(interval));
			}
			return list;
		} finally {
			session.close();
		}
	}

	protected List<T> selectListWithTimeCheck(String arg, Object obj) {
		long s = System.currentTimeMillis();
		SqlSession session = factory.openSession();
		try {
			List<T> list = session.selectList(arg, obj);
			long interval = System.currentTimeMillis() - s;
			if (interval > SELECT_DELAY) {
				com.mokylin.game.server.logger.GlobalLogger.db
						.error(new StringBuilder().append(arg).append(":")
								.append(interval));
			}
			return list;
		} finally {
			session.close();
		}
	}

	protected Object selectOneWithTimeCheck(String arg) {
		long s = System.currentTimeMillis();
		SqlSession session = factory.openSession();
		try {
			Object ret = session.selectOne(arg);
			long interval = System.currentTimeMillis() - s;
			if (interval > SELECT_DELAY) {
				com.mokylin.game.server.logger.GlobalLogger.db
						.error(new StringBuilder().append(arg).append(":")
								.append(interval));
			}
			return ret;
		} finally {
			session.close();
		}
	}

	protected int insertWithTimeCheck(String arg, T obj) {
		long s = System.currentTimeMillis();
		SqlSession session = factory.openSession();
		try {
			int ret = session.insert(arg, obj);
			session.commit();
			long interval = System.currentTimeMillis() - s;
			if (interval > INSERT_DELAY) {
				com.mokylin.game.server.logger.GlobalLogger.db
						.error(new StringBuilder().append(arg).append(":")
								.append(interval));
			}
			return ret;
		} finally {
			session.close();
		}
	}

	protected int updateWithTimeCheck(String arg, Object obj) {
		long s = System.currentTimeMillis();
		SqlSession session = factory.openSession();
		try {
			int ret = session.insert(arg, obj);
			session.commit();
			long interval = System.currentTimeMillis() - s;
			if (interval > UPDATE_DELAY) {
				com.mokylin.game.server.logger.GlobalLogger.db
						.error(new StringBuilder().append(arg).append(":")
								.append(interval));
			}
			return ret;
		} finally {
			session.close();
		}
	}

	protected int deleteWithTimeCheck(String arg, Object obj) {
		long s = System.currentTimeMillis();
		SqlSession session = factory.openSession();
		try {
			int ret = session.insert(arg, obj);
			session.commit();
			long interval = System.currentTimeMillis() - s;
			if (interval > DELETE_DELAY) {
				com.mokylin.game.server.logger.GlobalLogger.db
						.error(new StringBuilder().append(arg).append(":")
								.append(interval));
			}
			return ret;
		} finally {
			session.close();
		}
	}
}

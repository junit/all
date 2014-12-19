package com.mokylin.game.core.scheduler;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerManager {
	private static Logger logger = Logger.getLogger(SchedulerManager.class);
	private Scheduler scheduler;

	public boolean add(Class<? extends Job> jobClass, long interval) {
		JobDetail job = JobBuilder.newJob(jobClass).withIdentity(jobClass.getName(), Scheduler.DEFAULT_GROUP).build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClass.getName() + "Trigger", Scheduler.DEFAULT_GROUP).startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(interval).repeatForever()).build();

		try {
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			logger.error(e, e);
			return false;
		}
		return true;
	}
	
	public boolean add(Class<? extends Job> jobClass, String cron) {
		JobDetail job = JobBuilder.newJob(jobClass).withIdentity(jobClass.getName(), Scheduler.DEFAULT_GROUP).build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClass.getName() + "Trigger", Scheduler.DEFAULT_GROUP).startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();

		try {
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			logger.error(e, e);
			return false;
		}
		return true;
	}

	public SchedulerManager() {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			logger.error(e, e);
			System.exit(-1);
		}
	}
}


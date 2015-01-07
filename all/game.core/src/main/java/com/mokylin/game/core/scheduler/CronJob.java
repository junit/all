package com.mokylin.game.core.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CronJob implements Job {
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.err.println(this);
	}
}
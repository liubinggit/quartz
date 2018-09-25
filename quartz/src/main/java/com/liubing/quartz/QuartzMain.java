/**
 * 
 */
package com.liubing.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author 123
 *
 */
public class QuartzMain {
	
	public static void main(String[] args) throws SchedulerException {
		//创建job对象， 执行事件
		JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class).build();
		
		//创建trigger对象 执行时间
		/**
		 * trigger 两种
		 * 1.简单的
		 * 2.cron
		 */
//		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();
		
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		
		//创建scheduler对象 时间执行事件
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(jobDetail, trigger);
		
		//启动
		scheduler.start();
	}

}

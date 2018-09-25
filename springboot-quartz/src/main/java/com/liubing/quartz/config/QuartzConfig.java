/**
 * 
 */
package com.liubing.quartz.config;

import org.quartz.SimpleScheduleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.liubing.quartz.job.QuartzDemo;

/**
 * @author 123
 *
 */
@Configuration
public class QuartzConfig {

	@Autowired
	private AdaptableJobFactory myAdaptableJobFactory;

	/**
	 * 创建job
	 * 
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(QuartzDemo.class);
		return factoryBean;
	}

	// /**
	// * 创建简单的trigger
	// */
	// @Bean
	// public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean
	// jobDetailFactoryBean) {
	// SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
	// factory.setJobDetail(jobDetailFactoryBean.getObject());
	// factory.setRepeatInterval(1000 * 5); // 毫秒数
	// return factory;
	// }
	//
	//
	// /**
	// * 创建scheduler
	// */
	// @Bean
	// public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean
	// simpleTriggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory) {
	// SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
	// factoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
	// factoryBean.setJobFactory(myAdaptableJobFactory);
	// return factoryBean;
	// }

	/**
	 * 创建Cron的trigger
	 */
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		factory.setCronExpression("0/5 * * * * ?");
		return factory;
	}

	/**
	 * 创建scheduler
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean) {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
		factoryBean.setTriggers(cronTriggerFactoryBean.getObject());
		factoryBean.setJobFactory(myAdaptableJobFactory);
		return factoryBean;
	}

}

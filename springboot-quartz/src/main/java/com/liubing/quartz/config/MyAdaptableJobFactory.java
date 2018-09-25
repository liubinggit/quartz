package com.liubing.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {
	
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	/**
	 * 需要实例化的任务对象手动的添加到springioc容器中并且完成对象的注入
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object object = super.createJobInstance(bundle);
		this.autowireCapableBeanFactory.autowireBean(object);
		
		return object;
	}
}

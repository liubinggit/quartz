/**
 * 
 */
package com.liubing.quartz.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 123
 * scheduled定时任务器
 *
 */
@Component
public class ScheduledDemo {
	
	/**
	 * 定时任务
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	public void scheduledMethod() {
		System.out.println("定时执行时间:" + new Date());
	}

}

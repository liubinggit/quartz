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
	 * cron 有6个值 或7个值, 第7个值为年, 推荐使用6个值
	 * 
	 * 秒 分 24小时 日 月  周几
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	public void scheduledMethod() {
		System.out.println("定时执行时间:" + new Date());
	}

}

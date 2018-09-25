/**
 * 
 */
package com.liubing.quartz.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.liubing.quartz.service.UserService;

/**
 * @author 123
 *
 */
public class QuartzDemo implements Job {
	
	@Autowired
	private UserService userService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("QuartzDemo执行时间：" + new Date());
		userService.getUser();
	}

}

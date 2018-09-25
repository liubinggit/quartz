/**
 * 
 */
package com.liubing.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author 123
 *
 */
public class QuartzDemo implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("QuartzDemo执行时间：" + new Date());
	}

}

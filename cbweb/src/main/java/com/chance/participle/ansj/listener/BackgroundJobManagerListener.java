package com.chance.participle.ansj.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.util.MyStaticValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * 
 * @author Sean
 * @date 创建时间：Sep 20, 2017 10:16:20 AM
 * @version 1.0
 * 
 */
public class BackgroundJobManagerListener  implements ServletContextListener {

	final static Logger logger = LoggerFactory.getLogger(BackgroundJobManagerListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		logger.info("Start initialize the ansj");
		
//		MyStaticValue myConfig = new MyStaticValue();
		MyStaticValue.putLibrary("dic", "jar://userLibrary.dic");
		BaseAnalysis.parse("test！");
		
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	
	
}


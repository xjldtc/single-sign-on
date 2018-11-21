package com.newland.singlesignon.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.newland.framework.common.CommonConfig;
import com.newland.singlesignon.biz.BizConfig;

/**
 * restful 应用服务 入口点
 * @author xjldtc
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { CommonConfig.class,BizConfig.class, SSORestfulApplication.class })
public class SSORestfulApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(SSORestfulApplication.class, args);
		/**
		 * 监控暂时不实现
		 */
		//context.addApplicationListener(new ApplicationPidFileWriter());// 创建监听PID文件application.pid
		//context.addApplicationListener(new EmbeddedServerPortFileWriter());// 监听PID
	}
}

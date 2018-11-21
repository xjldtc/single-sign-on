package com.newland.singlesignon.assembly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.newland.singlesignon.restful.SSORestfulApplication;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class SSOApplication {

	private static final Logger logger = LoggerFactory.getLogger(SSOApplication.class);

	public static void main(String[] args) throws Exception {
		System.setProperty("spring.devtools.restart.enabled","true");
		/**
		 * 公共模块加载
		 */
		ConfigurableApplicationContext commonContext = new SpringApplicationBuilder(SSOApplication.class)
				.web(WebApplicationType.NONE).run(args);
		//commonContext.addApplicationListener(new ApplicationPidFileWriter());
		logger.info(commonContext.getId() + " isActive: " + commonContext.isActive());

		/**
		 * restful 模块加载
		 */
		if (commonContext.getEnvironment().containsProperty("restful")) {
			ConfigurableApplicationContext configContext = 
					new SpringApplicationBuilder(SSORestfulApplication.class).parent(commonContext).run(args);
			logger.info(configContext.getId() + " isActive: " + configContext.isActive());
		}
	}
}

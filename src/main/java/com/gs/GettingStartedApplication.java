package com.gs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.config", "com.web", "com.repo", "com.service", "com.domain", "com.sec"})
public class GettingStartedApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GettingStartedApplication.class, args);
        /*EventHolderBean bean = ctx.getBean(EventHolderBean.class);
        System.out.println("Event Processed?? - " + bean.getEventFired());*/
	}
}

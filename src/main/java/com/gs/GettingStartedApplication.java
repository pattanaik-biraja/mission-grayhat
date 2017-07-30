package com.gs;

import org.sfg.blog.cntxref.EventHolderBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.sfg.blog.cntxref", "com.web", "com.repo.config", "com.service"})
public class GettingStartedApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GettingStartedApplication.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(GettingStartedApplication.class, args);
        EventHolderBean bean = ctx.getBean(EventHolderBean.class);
        System.out.println("Event Processed?? - " + bean.getEventFired());
	}
}

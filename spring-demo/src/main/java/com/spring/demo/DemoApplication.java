package com.spring.demo;

import com.spring.demo.config.DemoConfig;
import com.spring.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilei
 * @version 1.0
 * @date 2021/12/7 9:39
 * @description
 */
public class DemoApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		UserService userService = context.getBean(UserService.class);
		System.out.println(userService);
		System.out.println(context.getBean(UserService.class));
	}
}

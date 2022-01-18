package com.spring.demo.annotation.spring;

import com.spring.demo.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor#postProcessBeforeInitialization");
		if (bean instanceof UserService) {
			System.out.println(beanName);
		}
		// 自己的逻辑
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor#postProcessAfterInitialization");
		// 自己的逻辑
		return bean;
	}

	@Override
	public int getOrder() {
		return 0;
	}

}
package com.spring.demo.annotation.spring;

import org.springframework.beans.factory.FactoryBean;

//为了区分 “FactoryBean” 和 “FactoryBean 创建的 bean 实例”，
// Spring 使用了 “&” 前缀。假设我们的 beanName 为 apple，则 getBean("apple") 获得的是 AppleFactoryBean 通过 getObject() 方法创建的 bean 实例；
// 而 getBean("&apple") 获得的是 AppleFactoryBean 本身。

public class AppleFactoryBean implements FactoryBean<Apple> {
 
    @Override
    public Apple getObject() throws Exception {
        Apple apple = new Apple();
        apple.setName("bigApple");
        return apple;
    }
 
    @Override
    public Class<?> getObjectType() {
        return Apple.class;
    }
 
    @Override
    public boolean isSingleton() {
        return true;
    }
}

class Apple{
	public Apple() {
	}

	String name;

	public Apple(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

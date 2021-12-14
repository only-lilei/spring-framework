package com.spring.demo.annotation.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
 
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        FirstBeanDefinitionRegistryPostProcessor firstBeanDefinitionRegistryPostProcessor = new FirstBeanDefinitionRegistryPostProcessor();
        // 将自定义的firstBeanDefinitionRegistryPostProcessor添加到应用上下文中
        applicationContext.addBeanFactoryPostProcessor(firstBeanDefinitionRegistryPostProcessor);
        // ...自定义操作
        System.out.println("SpringApplicationContextInitializer#initialize");
    }
}

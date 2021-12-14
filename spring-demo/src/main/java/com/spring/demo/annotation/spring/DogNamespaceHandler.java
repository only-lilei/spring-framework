package com.spring.demo.annotation.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author lilei
 * @version 1.0
 * @date 2021/12/10 17:23
 * @description
 */
public class DogNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		// 注册一个自定义的解析器, 用于解析命名空间下的annotation节点
		registerBeanDefinitionParser("annotation", new DogAnnotationDefinitionParser());
	}
}

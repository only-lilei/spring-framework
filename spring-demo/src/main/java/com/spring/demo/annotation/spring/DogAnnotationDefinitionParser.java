package com.spring.demo.annotation.spring;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author lilei
 * @version 1.0
 * @date 2021/12/10 17:24
 * @description
 */
public class DogAnnotationDefinitionParser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClass(DogBean.class);

		MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
		// 添加name属性
		if (element.hasAttribute("name")) {
			mutablePropertyValues.addPropertyValue("name", element.getAttribute("name"));
		}
		// 添加package属性
		if (element.hasAttribute("package")) {
			mutablePropertyValues.addPropertyValue("package", element.getAttribute("package"));
		}
		String id = element.getAttribute("id");
		// 拿到注册表, 注册BeanDefinition
		parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
		return beanDefinition;
	}
}


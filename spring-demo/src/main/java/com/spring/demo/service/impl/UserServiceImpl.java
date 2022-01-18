package com.spring.demo.service.impl;

import com.spring.demo.service.TestAutowireService;
import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author lilei
 * @version 1.0
 * @date 2021/12/7 9:40
 * @description
 */
@Service
@Scope("singleton")
public class UserServiceImpl implements UserService {

	@Autowired
	private TestAutowireService testAutowireService;


	public UserServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "构造方法");
	}
}

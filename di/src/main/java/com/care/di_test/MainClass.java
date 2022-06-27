package com.care.di_test;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.root02.STBean;

public class MainClass {

	public static void main(String[] args) {
		String path = "classpath:application_test.xml"; //classpath : src/main/resources의 경로를 의미
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(path); 
		PrintBean pBean = ctx.getBean("printB", PrintBean.class); 

		pBean.printString();
	}
}

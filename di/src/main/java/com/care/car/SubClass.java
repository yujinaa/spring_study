package com.care.car;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SubClass {
	public void subFunc() {
		//Car car = new Controller02(); 
		String path = "classpath:applicationCAR.xml"; 
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(path); 
		Car car = ctx.getBean("car", Car.class);
		
		System.out.println("서브에서 속력을내고 있습니다");
		car.speed();
	}
}

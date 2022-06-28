package com.care.car;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//Car car = new Controller02(); //자바로 일반적인 controller 객체 만드는방법
		String path = "classpath:applicationCAR.xml"; 
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(path); 
		Car car = ctx.getBean("car", Car.class);
		
		System.out.println("메인에서 속력을내고 있습니다");
		car.speed(); //controller에 있는 기능 사용으로 controller01의 오버라이딩에 의해 자식이 가지고 있는 speed실행 
		
		//서브클래스 기능추가
		SubClass sc = new SubClass();
		sc.subFunc();
	}

}

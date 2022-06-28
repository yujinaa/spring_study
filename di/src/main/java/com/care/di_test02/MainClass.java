package com.care.di_test02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String path = "classpath:application_test02.xml"; 
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(path); 
		SaveClass sc = ctx.getBean("sc", SaveClass.class);
		
		Scanner input = new Scanner(System.in);
		System.out.println("연산값을 입력해보자");
		sc.setNum1(input.nextInt());
		sc.setOp(input.next());
		sc.setNum2(input.nextInt());
		sc.operationClass();
		sc.printClass();

	}
}

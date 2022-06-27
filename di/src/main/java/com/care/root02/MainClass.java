package com.care.root02;

import org.springframework.context.support.GenericXmlApplicationContext;

//객체 만들기
public class MainClass {
	public static void main(String[] arge) {
		String path = "classpath:applicationST.xml"; //classpath : src/main/resources의 경로를 의미
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(path); //해당하는 컨테이너에 대한 정보를 가져옴(잘 안쓴다)
		STBean stBean = ctx.getBean("stb", STBean.class); //stb를 가져오고, 자료형은 STBean.class이다.

		//STBean stBean = new STBean();
		//stBean.setName("홍길동11");
		//stBean.setAge(201343);

		//stBean.setSt(new Student());
		stBean.namePrint();
		stBean.agePrint(); 
	}
}

package com.care.root;
//객체 만들기
public class MainClass {
	public static void main(String[] arge) {
		STBean stBean = new STBean();
		stBean.setName("홍길동");
		stBean.setAge(20);
		
		stBean.setSt(new Student());
		stBean.namePrint();
		stBean.agePrint(); 
	}
}

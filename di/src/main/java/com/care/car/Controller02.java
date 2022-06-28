package com.care.car;

public class Controller02 implements Car{
	@Override
	public void speed() {//controller01이 아닌 02로 실행하고 싶다면 어차피 동일 부모 Car를 가지고 있으니 01을 02로 바꾸면된다
		System.out.println("새로운 내용으로 수정합니다");
	
	}
}

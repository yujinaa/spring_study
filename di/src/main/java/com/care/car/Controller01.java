package com.care.car;

public class Controller01 implements Car{//상속받기
@Override
public void speed() {//controller에 있는 기능 사용으로 controller01의 오버라이딩에 의해 자식이 가지고 있는 speed실행
	System.out.println("시속 100km입니다");
	
}

}

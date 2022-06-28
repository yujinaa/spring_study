package com.care.car;

public class SubClass {
	public void subFunc() {
		Car car = new Controller02(); 
		System.out.println("서브에서 속력을내고 있습니다");
		car.speed();
	}

}

package com.care.root02;

//자바를 이용한 방법

//이름과 나이를 저장하는 기능
public class STBean {
	private String name;
	private int age;
	private Student st;
	
	public void namePrint() {
		st.namePrint(name); //st라는 객체를 이용해서 이름을 출력하는 쪽으로 연결
	}
	public void agePrint() {
		st.agePrint(age);  //st라는 객체를 이용해서 나이를 출력하는 쪽으로 연결
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	
	}



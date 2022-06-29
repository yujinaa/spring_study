package com.care.root;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//service : 연산 기능 담당 
@Service
public class MemberService { 
	MemberDAO dao;//service는 DAO를 호출한다
	public MemberService() {//객체가 만들어졌기에 생성자호출
		System.out.println("서비스 생성자 실행");
	}
	public int insert() { //Controller에서 데이터를 가지고 해당하는 메소드를 찾아간다
		//dao = new MemberDAO(); 
		return dao.insert(); //DAO로 넘어가서 코드 작성 (사용자가 넘긴 값을 dao로 전달) 
	}
}

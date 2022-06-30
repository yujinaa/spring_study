package com.care.root.member.service;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{ //상속받기
	public MemberServiceImpl() {
		System.out.println("service 생성자 실행");//제대로 실행이 되는지 보기위해서 생성자를 만들어주는게 좋다
	}

}

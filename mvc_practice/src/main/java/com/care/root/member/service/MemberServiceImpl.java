package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{ //상속받기
	@Autowired 	MemberDAO dao;
	public MemberServiceImpl() {
		System.out.println("service 생성자 실행");//제대로 실행이 되는지 보기위해서 생성자를 만들어주는게 좋다
	}
	public void test() {
		System.out.println("dao : " + dao);
	}

}

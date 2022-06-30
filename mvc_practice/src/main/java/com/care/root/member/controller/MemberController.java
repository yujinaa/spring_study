package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired 	MemberService ms;
	public MemberController() {
		System.out.println("controller 생성자 실행"); //서버를 끄고 다시 실행했을 때 이 문구가 떠야 빈들이 만들어진것
	}

}

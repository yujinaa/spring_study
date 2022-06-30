package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired 	MemberService ms;
	public MemberController() {
		System.out.println("controller 생성자 실행"); //서버를 끄고 다시 실행했을 때 이 문구가 떠야 빈들이 만들어진것
	}
	@RequestMapping("test")//빈이 들어왔는지 ms를 출력해본다(서버를 끄고 다시 실행해 test페이지를 열면 콘솔에 출력돼는걸 확인
	public void test() {
		System.out.println("ms :" + ms);
		ms.test();
	}

}

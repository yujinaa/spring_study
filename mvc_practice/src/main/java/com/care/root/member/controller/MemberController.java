package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")//공통적으로 쓰는 경로를 쓰면 번거로움이 줄일수 있음
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
	@GetMapping("/index")//경로명(url)
	public String memberIndex() {
		return "/member/index";//패키지명(views)
	}
	@GetMapping("/register_view")//<a>태그는 get방식
	public String registerView() {
		return "/member/register_view";
	}
	@GetMapping("/member_list")//requestMapping으로 member생략 가능
	public String memberList() {
		return "/member/member_list";
	}

}

package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms; //넘어갈 서비스 연결
	@GetMapping("member/login")
	public String login() {
		System.out.println("멤버 로그인 연결");
		return "member/login";
	}
	@PostMapping("member/user_check")
	public String userCheck(@RequestParam String id, @RequestParam String pw, //사용자로부터 id,pwd넘어오면
							RedirectAttributes rs) {
		int result = ms.userCheck(id, pw);//service로 id,pw넘긴다
		if(result == 0) {//로그인 성공시
			return "redirect:successLogin";
		}else {//로그인 실패시
			return "redirect:login";
		}
			
		
	}
}

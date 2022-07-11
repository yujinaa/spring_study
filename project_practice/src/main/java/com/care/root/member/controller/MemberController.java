package com.care.root.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.MemberSessionName;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")//공통경로라 한번에 적음
public class MemberController implements MemberSessionName{//공통모듈인 로그인세션 상속받아 사용하기
	@Autowired MemberService ms; //넘어갈 서비스 연결
	@GetMapping("/login")
	public String login() {
		System.out.println("멤버 로그인 연결");
		return "member/login";
	}
	@PostMapping("/user_check")
	public String userCheck(@RequestParam String id, @RequestParam String pw, //사용자로부터 id,pwd넘어오면
							RedirectAttributes rs) {
		int result = ms.userCheck(id, pw);//service로 id,pw넘긴다
		if(result == 0) {//로그인 성공시
			rs.addAttribute("id",id);//jsp까지 연동, 컨트롤러까지만 연결할거면 model도 사용가능
			return "redirect:successLogin";
		}else {//로그인 실패시
			return "redirect:login";
		}		
	}
	@GetMapping("/successLogin")
	public String successLogin(@RequestParam String id, HttpSession session) {
		session.setAttribute(LOGIN, id);// =loginUser(로그인한 사용자)
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute(LOGIN) !=null)//세션이 있는 사용자라면
			session.invalidate();//세션 종료
			return "redirect:/index";//인덱스 페이지로 이동
	}
}

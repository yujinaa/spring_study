package com.care.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("login")
	public String login() {
		return "login/login";
	}
	@PostMapping("chkUser")
	public String chkUser(@RequestParam String id, @RequestParam String pwd,
			HttpSession session) {//사용자로부터 넘어오는 값 받아서 처리
		String db_id = "1",db_pwd = "1", db_nick="날씨가 너무 더워";//아직 db연결을 하지않아서 가정
		if(id.equals(db_id) && pwd.equals(db_pwd)) {
			session.setAttribute("loginId", db_id);
			session.setAttribute("loginNick", db_nick);
			return "redirect:main";//로그인 인증 통과시 main페이지로 이동
		}else {
			return "redirect:login"; //로그인 실패시 다시 로그인페이지로 이동하도록
		}
	}
	@RequestMapping("main")
	public String main(HttpSession session, HttpServletResponse response) {		
//		PrintWriter out = null;
//		response.setContentType("text/html; charset=utf-8");
//		try {
//			out = response.getWriter();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		if(session.getAttribute("loginId") != null) {
			//out.print("<script>alert('로그인 성공')</script>");//사용자에게 응답할 메시지
			return "login/main"; //null이 아니면 main으로			  
		}
		return "redirect:login"; //null이면 login으로(무분별하게 페이지가 넘어가지 않도록)
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();//모든 세션 완료
		return "login/logout";
	}
}

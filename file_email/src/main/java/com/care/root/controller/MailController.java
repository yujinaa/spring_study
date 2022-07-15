package com.care.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.servicce.MailService;

@Controller
public class MailController {
	@Autowired MailService ms;
	@GetMapping("sendmail")
	public void sendMail(HttpServletResponse response) throws Exception{

		StringBuffer sb = new StringBuffer();
		sb.append("<h1>제품소개</h1>");
		sb.append("<a href=\"https://comic.naver.com/index\">");
		sb.append("<img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqWj4CcnT6AHv-rk1pPl6YWV94FRzjZEPh0w&usqp=CAU\">");
		sb.append("</a>");

		String msg = sb.toString();//단순 Sring으로 변환


		ms.sendMail("받을메일계정", "(제목)광고",msg); //만든 msg를 보내기

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("메일이 전송되었습니다");
	}
	@GetMapping("auth_form")
	public String authForm() {
		return "auth";
	}
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:https://www.naver.com/";//받는 사람 주소
	}
	@GetMapping("auth_check")
	public String authCheck(@RequestParam String userid, @RequestParam String userkey,
			HttpSession session) {
		String sessionKey = (String)session.getAttribute(userid);
		if(sessionKey!=null) {
			if(sessionKey.equals(userkey)) {
				session.setAttribute("userid",userid);
			}
		}
		return "redirectLauth_form";
	}

}

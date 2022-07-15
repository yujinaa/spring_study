package com.care.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		
		String msg = sb.toString();//Sring으로 변환헤야한다
		
		
		ms.sendMail("받을메일계정", "(제목)광고",msg); //만든 msg를 보내기
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("메일이 전송되었습니다");
	}

}

package com.care.root;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	@RequestMapping("make_session")
	public String makeSession(HttpServletRequest req) {//session만드는방법1.Request
		HttpSession session = req.getSession();//session만들기(request를 이용해 얻어온다)
		session.setAttribute("id", "abc123");
		session.setAttribute("name", "이영자");
		return "session/makeSession";
	}
	@RequestMapping("result_session")
	public String resultSession(Model model) {
		model.addAttribute("id","모델로 저장한 아이디");
		return "session/resultSession";
	}
	@RequestMapping("del_session")
	public String delSession(HttpSession session) { //session만드는방법2.HttpSession(알아서 session 자동주입)
		session.removeAttribute("id"); //세션 하나씩 삭제
		//session.invalidate(); //모든 session 삭제(만료)
		return "session/delSession";
	}
}

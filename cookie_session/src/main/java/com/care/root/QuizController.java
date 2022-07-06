package com.care.root;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quiz")
public class QuizController {
	@RequestMapping("cookie")
	public String myCookie(HttpServletResponse response, Model model,
							@CookieValue(value="myCookie", required = false) Cookie cook,
							HttpServletRequest request) {
		//jsp방식으로도 만들어보았다
//		Cookie[] cookies = request.getCookies();
//		if(cookies != null) {
//			for(Cookie c : cookies)
//				System.out.println(c.getName()+":" +c.getValue());
//		}
		if(cook!=null)
			model.addAttribute("cook", cook.getValue());
		return "quiz/cookie";
	}
	@RequestMapping("popup")
	public String popup() {
		return "quiz/popup";
	}
	@RequestMapping("cookieChk")
	public void cookieChk(HttpServletResponse  response) {//어차피 자신 불러내는거라 void를 써서 return값 쓰지 않았다
		Cookie cook = new Cookie("myCookie", "나의 쿠키");
		cook.setMaxAge(10);
		cook.setPath("/");
		response.addCookie(cook);
	}
}

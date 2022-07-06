package com.care.root;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	@GetMapping("cookie")
	public String cookie(HttpServletResponse response) {//사용자 응답용으로 사용
		//자바코드로 쿠키설정
		Cookie cook = new Cookie("myCookie", "쿠키생성");
		cook.setMaxAge(5);//시간설정
		response.addCookie(cook);//사용자에게 응답
		return "cook/cookie";
	}

}

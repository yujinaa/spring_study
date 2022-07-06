package com.care.root;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	@GetMapping("cookie")
	public String cookie(HttpServletResponse response, //사용자 응답용으로 사용
							HttpServletRequest req,//쿠키값 얻어오기
							@CookieValue(value = "myCookie", required=false) Cookie cookie) {//사용자에게 myCookie있다면 cookie에 넣겠다, 값이 없으면 required=false null값으로 처리한다
		System.out.println("cookie : " + cookie);
		//자바코드로 쿠키설정
		Cookie cook = new Cookie("myCookie", "쿠키생성");
		cook.setMaxAge(5);//시간설정
		response.addCookie(cook);//사용자에게 응답
		
		for(Cookie c : req.getCookies() ) {
			System.out.println(c.getName());
		}
		return "cook/cookie";
	}
}

package com.care.root.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.common.MemberSessionName;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter implements MemberSessionName{
	
	@Autowired MemberService ms;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); //WebUtils로 쿠키값 한번에 가져오기
		System.out.println("loginCookie : " + loginCookie);
		if(loginCookie != null) {
			MemberDTO dto = ms.getUserSessionId(loginCookie.getValue());//getUserSessionId이용해 이것과 같은 getValue값 가져오기
			if(dto != null) {
				request.getSession().setAttribute(LOGIN, dto.getId());//세션 만든다
			}
		}
		return true;
	}
	

}

package com.care.root.testboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.common.MemberSessionName;

public class BoardTestInterceptor extends HandlerInterceptorAdapter implements MemberSessionName{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();//session 얻어오기
		if(session.getAttribute(LOGIN) == null) {//session이 없다면
			//response.sendRedirect("login");//login으로 가라
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 해주세요');"
					//					 + "location.href='/root/member/login';</script>");
					+ "location.href='" +request.getContextPath() + "/member/login'; </script>");
			return false;//false면 해당 sendRedirect가 들어간다
		}
		return true;
	}

}

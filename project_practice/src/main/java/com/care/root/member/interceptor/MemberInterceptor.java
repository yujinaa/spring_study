package com.care.root.member.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.common.MemberSessionName;
//인터셉터
public class MemberInterceptor extends HandlerInterceptorAdapter
								implements MemberSessionName{//로그인 세션 사용위해서 상속받기
	//이걸 더 많이 씀
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//컨트롤러 가기전에 미리 처리하기
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
		
		System.out.println("index(컨트롤러) 실행 전 실행");
		return true;//해당하는 사용자가 요청한 경로로 연결, 여기서 인터셉터가 끝나면 멤버 컨트롤러가 실행된다
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("index(컨트롤러) 실행 후 실행");
	}//상속받기
	

}

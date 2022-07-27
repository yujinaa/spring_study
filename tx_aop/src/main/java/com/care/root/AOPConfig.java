package com.care.root;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect //이걸 써줘야 aop로 인정된다(공통기능으로 동작)
@EnableAspectJAutoProxy //해당 aop를 찾아 연결을 알려줌
public class AOPConfig {
//	@Before("execution(* com.care.root.controller.TestController.buy_form(..))")
	@Around("execution(public String buy_form(..))") //@Around: 특정 메소드 실행전 두번 동작한다
	public void commonAop(ProceedingJoinPoint joinpoint) { //@Around사용시 ProceedingJoinPoint joinpoint 매게변수 꼭 사용해야한다
		try {
			System.out.println("==== 컨트롤러 공통기능 시작 ====");
			joinpoint.proceed();//일시정지
			System.out.println("==== 컨트롤러 공통기능 종료 ====");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
//	@Before : 해당 메소드 실행전 한번실행
	@Before("execution(* com.care.root.service.TestServiceImpl.buy(..))")
	public void commonAop02() {
		System.out.println("==== service 공통 기능(buy) 시작====");
	}
//	@After : 해당 메소드 실행후 실행
	@After("execution(* com.care.root.service.TestServiceImpl.dbResult(..))")
	public void commonAop03() {
		System.out.println("==== service 공통 기능(db_result) 종료====");
	}}

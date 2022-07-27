package com.care.root;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.reflect.MethodSignature;

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
	@Before("execution(* com.care.root.service.TestServiceImpl.buy(..))")  //=("execution(* buy(..))")  : 반환타입은 전부, 메소드 이름은 buy,매게변수는 0개 이상
	public void commonAop02() {
		System.out.println("==== service 공통 기능(buy) 시작====");
	}
	//	@After : 해당 메소드 실행후 실행
	@After("execution(* com.care.root.service.TestServiceImpl.dbResult(..))")
	public void commonAop03() {
		System.out.println("==== service 공통 기능(db_result) 종료====");
	}
	Logger LOG = Logger.getGlobal();
	@Around("execution(* com.care.root.controller.*.*(..))")//controller는 패키지 모든값
	public Object commonAop00(ProceedingJoinPoint joinpoint) {
		MethodSignature methodSignature = (MethodSignature)joinpoint.getSignature();//joinpoint이용해 MethodSignature 메소드 관련 얻어오기
		Method method = methodSignature.getMethod();
		Object[] objects = joinpoint.getArgs(); //objects 이용해서 
		for(Object param : objects) {//param 매개변수 하나씩 가져오기
			LOG.log(Level.INFO, "들어온 파라미터 값 : "+param);
		}
		LOG.log(Level.INFO,"실행된 메소드 : "+method.getName());//실행되는 메소드 출력
		Object obj=null;
		try {
			obj = joinpoint.proceed();//실행해서
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;//결과값 반드시 리턴으로 출력(그렇지 않으면 페이지를 못찾아가고 여기서 끝난다)
	}
}
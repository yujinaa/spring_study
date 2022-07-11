package com.care.root.common;
//공통 모듈 만들기
//공통적으로 쓸 파일을 만들어준다
public interface MemberSessionName {//로그인 세션은 누구나 가지고 있어야해서 공통파일로 만들었다
	//로그인 성공시 생성되는 세션 이름
	static final String LOGIN = "loginUser";
}

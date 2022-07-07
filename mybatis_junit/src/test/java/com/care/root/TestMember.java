package com.care.root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;

//테스트 동작때 무조건 있어야한다
@RunWith(SpringRunner.class)//@RunWith :테스트 동작 , SpringRunner : 이걸로 동작시키겠다
@ContextConfiguration(locations={"classpath:TestMember.xml"})
public class TestMember {
	@Autowired MemberController mc;  //autowired로 memberController 자동주입
	
	@Test
	public void testMc() {
		System.out.println("mc : " +mc);
	}

}

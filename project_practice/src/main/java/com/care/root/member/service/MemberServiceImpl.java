package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{//상속받기
	@Autowired MemberMapper mapper; //mapper연결하기
	public int userCheck(String id,String pw) {//오버라이딩
		mapper.usercheck(id);//id 넘기기
		
	}
}

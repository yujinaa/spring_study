package com.care.root.mybatis.member;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO userCheck(String id);//dto값 전달
}

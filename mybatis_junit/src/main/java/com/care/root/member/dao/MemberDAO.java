package com.care.root.member.dao;

import com.care.root.member.dto.MemberDTO;
//dao는 db 연결만하기 때문에 코드가 들어가는 공간이 아님(그래서 보통 dao가 아닌 mapper라고 지음)
public interface MemberDAO {
	public void insertMember(MemberDTO dto);

}

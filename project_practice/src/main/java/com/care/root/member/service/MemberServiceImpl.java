package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{//상속받기
	@Autowired MemberMapper mapper; //mapper연결하기
	public int userCheck(String id,String pw) {//오버라이딩
		MemberDTO dto = mapper.userCheck(id);//id 넘기기
		if(dto!=null) {//id있는경우
			if(pw.equals(dto.getPw())) {//사용자가 입력한 pw가 dto의 pw와 같다면
				return 0;//로그인 성공이면 0
			}
		}
		return 1;//로그인 실패시 1을 돌려준다
	}
	public void memberInfo(Model model) {
		model.addAttribute("memberList", mapper.memberInfo());
	}
	public void info(Model model,String id) {
		model.addAttribute("info", mapper.userCheck(id));
	}
	public int register(MemberDTO dto) {
		int result = 0;
		result = mapper.register(dto);
		return result;
	}
}

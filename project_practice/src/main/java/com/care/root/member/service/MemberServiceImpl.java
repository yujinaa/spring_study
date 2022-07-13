package com.care.root.member.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{//상속받기
	@Autowired MemberMapper mapper; //mapper연결하기
	BCryptPasswordEncoder encoder;//값을 암호화
	
	public MemberServiceImpl() {//객체 생성
		encoder = new BCryptPasswordEncoder();
	}
	
	
	
	public int userCheck(String id,String pw) {//오버라이딩
		MemberDTO dto = mapper.userCheck(id);//id 넘기기
		if(dto!=null) {//id있는경우
			//if(pw.equals(dto.getPw())) {//사용자가 입력한 pw가 dto의 pw와 같다면
			if(encoder.matches(pw, dto.getPw())){//비번암호화를 했기 때문에 비교를 해야한다(pw:암호화 되지않은 사용자입력값,dto.getPw():암호화된값 
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
	public int register(MemberDTO dto) {//비밀번호 암호화
		System.out.println("비번 변경 전 : " + dto.getPw());
		String securePw = encoder.encode(dto.getPw()); //securePw :변경값
		System.out.println("비번 변경 후 : " + securePw);
		
		dto.setPw(securePw);//변경값 dto에 저장하기
		
		int result = 0;
		try {//중복아이디로 회원가입시 에러메시지가 안보이도록 예외처리
			result = mapper.register(dto);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void keepLogin(String sessionId, Date limitDate, String id) {//sql date
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sessionId", sessionId);
		map.put("limitDate", limitDate);
		map.put("id", id);
		mapper.keepLogin(map);
		
	}
}

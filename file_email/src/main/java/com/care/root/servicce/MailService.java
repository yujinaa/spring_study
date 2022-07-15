package com.care.root.servicce;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired JavaMailSender mailSender; //JavaMailSender : 보내는 사람 계정
	public void sendMail(String to, String subject, String body) {//받는 사용자, 제목, 내용
		MimeMessage message = mailSender.createMimeMessage();//받는 사용자 세팅값
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);//true를 써줘야 html형식으로 넘어간다

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//이메일 로그인 인증
	public void auth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userid = "사용자이름";
		String userkey = rand();      //랜덤키
		session.setAttribute(userid, userkey);
		String body="<h2>안녕하세요 아뱅입니다</h2><hr>"  //사용자 이메일로 넘어갈 값
				+"<h3>"+userid+" 님</h3>"
				+"<p>인증하기 버튼을 누르면 로그인 됩니다</p>"
				+"<a href='http://localhost:8089"
				+request.getContextPath()+"/auth_check?userid="
				+userid+"&userkey="+userkey+"'>인증하기</a>";
		sendMail("받을메일","이메일 인증입니다",body);
	}
	private String rand() {//랜덤키 메소드 만들어줌
		Random ran = new Random();
		String str="";
		int num;
		while(str.length() != 20) {
			num = ran.nextInt(75)+48;
			if((num>=48 && num<=57)||(num>=65 && num<=90)||(num>=97 && num<=122)) {
				str+=(char)num;
			}else {
				continue;
			}
		}
		return str;
	}
}

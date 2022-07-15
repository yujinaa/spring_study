package com.care.root.servicce;

import javax.mail.internet.MimeMessage;

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
			helper.setText(body);

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

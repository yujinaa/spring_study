package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class BoardFileServiceImpl implements BoardFileService{
	public String getMessage(int num, HttpServletRequest request) {
		String message = null;
		if(num == 1) {
			message = "<script>alert('새글을 추가하였습니다.');";
			message += "location.href='"+request.getContextPath()+
					"/board/boardAllList'</script>";
		}else {
			message = "<script>alert('문제가 발생하였습니다.');";
			message += "location.href='"+request.getContextPath()+
					"/board/writeForm'</script>";
		}
		return message;
	}
}

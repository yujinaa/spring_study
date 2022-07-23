package com.care.root.board.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.board.dto.BoardRepDTO;
import com.care.root.board.service.BoardService;
import com.care.root.common.MemberSessionName;
@RestController
@RequestMapping("/board")
public class BoardRepController implements MemberSessionName{
	@Autowired BoardService bs;
	@PostMapping(value="addReply", produces = "application/json; charset=utf-8")
	public String addReply(@RequestBody Map<String, Object> map, HttpSession session){//사용자가 넘겨주는 값 @RequestBody으로 json타입받기

		BoardRepDTO dto = new BoardRepDTO();
		dto.setId( (String)session.getAttribute(LOGIN) );
		dto.setWrite_group( Integer.parseInt((String)map.get("write_no")) );
		dto.setTitle((String)map.get("title"));
		dto.setContent((String)map.get("content"));

		return bs.addReply(dto);
	} 
}

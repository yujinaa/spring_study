package com.care.root.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardConroller {
	@Autowired BoardService bs;
	
	@GetMapping("boardAllList")
	public String selectAllBoardList(Model model) {
		bs.selectAllBoardList(model);
		return "board/boardAllList";
	}
	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeForm";
	}

}

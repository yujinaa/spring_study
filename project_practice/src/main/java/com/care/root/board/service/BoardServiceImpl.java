package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired BoardMapper mapper;
	public void selectAllBoardList(Model model) {
		model.addAttribute("boardList", mapper.selectAllBoardList());
			
		}
}

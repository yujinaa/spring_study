package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.common.MemberSessionName;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired BoardMapper mapper;
	public void selectAllBoardList(Model model) {
		model.addAttribute("boardList", mapper.selectAllBoardList());

	}
	public String writeSave(MultipartHttpServletRequest mul, 
			HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle( mul.getParameter("title") );
		dto.setContent( mul.getParameter("content") );
		HttpSession session = request.getSession();
		dto.setId((String)session.getAttribute(MemberSessionName.LOGIN));

		MultipartFile file = mul.getFile("image_file_name");
		BoardFileService bfs = new BoardFileServiceImpl();
		if(file.getSize() != 0) {
			//이미지 있을경우 처리
		}else {
			dto.setImageFileName("nan");
		}
		int result = 0;
		try {
			result = mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bfs.getMessage(result, request);//메시지가 있을 경우 0 또는 1을 넘긴다
	}
}

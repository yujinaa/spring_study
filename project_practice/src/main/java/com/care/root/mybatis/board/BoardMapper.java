package com.care.root.mybatis.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.dto.BoardRepDTO;

public interface BoardMapper {
	public List<BoardDTO> selectAllBoardList(); //게시판에 대한 모든 데이터 요청
	public int writeSave(BoardDTO dto);
	public BoardDTO contentView(int writeNo);
	public void upHit(int writeNo);
	public int delete(int writeNo);
	public int modify(BoardDTO dto);
	public int addReply(BoardRepDTO dto);
	public List<BoardRepDTO> getRepList(int write_group);
}


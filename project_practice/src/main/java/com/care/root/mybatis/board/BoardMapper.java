package com.care.root.mybatis.board;

import java.util.List;

import com.care.root.board.dto.BoardDTO;

public interface BoardMapper {
	public List<BoardDTO> selectAllBoardList(); //게시판에 대한 모든 데이터 요청
	public int writeSave(BoardDTO dto);
	public BoardDTO contentView(int writeNo);

}

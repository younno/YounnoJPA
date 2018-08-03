package com.lyn.study.springboot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.lyn.study.springboot.entity.Board;
import com.lyn.study.springboot.repository.BoardPagingRepository;


@Service("board")
public class BoardServiceImpl implements BoardService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardPagingRepository boardRepository;
	
	public Page<Board> list(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	public Board findById(Board board, Pageable pageable){
		return boardRepository.findById(board.getId()).get();
	}
	
	public Page<Board> findByTitleLike(Board board, Pageable pageable) {
		return boardRepository.findByTitleLike(board.getTitle(), pageable);
	}
	
	public Page<Board> findByContentLike(Board board, Pageable pageable) {
		return boardRepository.findByContentLike(board.getContent(), pageable);
	}
	
	public Page<Board> findByTitleLikeAndContentLike(Board board, Pageable pageable) {
		return boardRepository.findByTitleLikeAndContentLike(board.getTitle(), board.getContent(), pageable);
	}
	
	public Page<Board> findByTitle(String title, Pageable pageable){
		return boardRepository.findByTitle(title, pageable);
	}
}

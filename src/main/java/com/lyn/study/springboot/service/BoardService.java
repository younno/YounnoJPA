package com.lyn.study.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.lyn.study.springboot.entity.Board;

public interface BoardService {

	public Page<Board> list(Pageable pageable);
	
	public Board findById(Board board, Pageable pageable);

	public Page<Board> findByContentLike(Board board, Pageable pageable);
	public Page<Board> findByTitleLike(Board board, Pageable pageable);
	
	public Page<Board> findByTitleLikeAndContentLike(Board board, Pageable pageable);
	
	Page<Board> findByTitle(String title, Pageable pageable);
}

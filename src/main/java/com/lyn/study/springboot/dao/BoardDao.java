package com.lyn.study.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.study.springboot.domain.Board;

public interface BoardDao extends JpaRepository<Board, Integer> {
	
	
	public Page<Board> findByTitle(String title, Pageable pageable);

/*
	public Page<Board> findByBoardTagListTagName(String tagName, Pageable pageable);

	public Page<Board> findByContentContaining(String query, Pageable pageable);

	public Page<Board> findByTitleContainingOrSubtitleContaining(String title, String subtitle, Pageable pageable);

	public Page<Board> findByTitleContainingOrSubtitleContainingOrContentContaining(String title, String subtitle,
			String content, Pageable pageable);
			*/
}

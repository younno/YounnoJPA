package com.lyn.study.springboot.service;

import java.util.EventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lyn.study.springboot.entity.Board;
import com.lyn.study.springboot.repository.BoardPagingRepository;


@Service("board")
public class BoardServiceImpl implements BoardService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardPagingRepository boardRepository;
	
	public Page<Board> list(Model model, Pageable pageable){
		return boardRepository.findAll(pageable);
	}

}

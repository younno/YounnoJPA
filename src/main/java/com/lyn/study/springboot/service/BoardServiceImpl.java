package com.lyn.study.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyn.study.springboot.domain.Board;
import com.lyn.study.springboot.repository.BoardRepository;


@Service("contents")
public class BoardServiceImpl {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardRepository boardRepository;


	public Page<Board> list(Model model, @RequestParam(defaultValue = "title") String type,
			@RequestParam(required = true) String query,
			@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		
		return boardRepository.getList(pageable);
	}

}

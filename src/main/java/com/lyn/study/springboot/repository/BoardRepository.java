package com.lyn.study.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.lyn.study.springboot.dao.BoardDao;
import com.lyn.study.springboot.domain.Board;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class BoardRepository {
	
	
	@Autowired
	private BoardDao boardDao;
	

	
	public Page<Board> getList(Pageable pageable){
		Page<Board> boardPage = boardDao.findAll(pageable);
		log.debug("postPage = {}", boardPage);
		
		return boardPage;
	}

}

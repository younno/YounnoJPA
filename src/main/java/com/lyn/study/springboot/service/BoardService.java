package com.lyn.study.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lyn.study.springboot.domain.Board;

public interface BoardService {

	Page<Board> findPost(String query, Pageable pageable);

}

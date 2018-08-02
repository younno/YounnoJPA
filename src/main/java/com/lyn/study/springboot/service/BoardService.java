package com.lyn.study.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import com.lyn.study.springboot.entity.Board;

public interface BoardService {

	Page<Board> list(Model model, Pageable pageable);

}

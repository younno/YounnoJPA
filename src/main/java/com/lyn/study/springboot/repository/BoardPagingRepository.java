package com.lyn.study.springboot.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lyn.study.springboot.entity.Board;


@Repository
public interface BoardPagingRepository extends PagingAndSortingRepository<Board, Long> {

	Page<Board> findAll(Pageable pageable);
	
}

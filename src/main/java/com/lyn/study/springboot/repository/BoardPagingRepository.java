package com.lyn.study.springboot.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lyn.study.springboot.entity.Board;


@Repository
public interface BoardPagingRepository extends PagingAndSortingRepository<Board, Integer> , JpaRepository<Board, Integer>{

	Page<Board> findAll(Specification<Board> spec, Pageable pageable);
	
	Page<Board> findByTitleLike(String title, Pageable pageable);
	
	Page<Board> findByContentLike(String content, Pageable pageable);
	
	Page<Board> findByTitleLikeAndContentLike(String title, String content, Pageable pageable);
	
	@Query("SELECT u FROM Board u WHERE u.title = :title ")
	Page<Board> findByTitle(@Param("title") String title, Pageable pageable);
}

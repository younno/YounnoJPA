package com.lyn.study.springboot.repository.crud;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lyn.study.springboot.entity.Board;


@Repository
public interface BoardCrudRepository extends CrudRepository<Board, Integer>{
	
}

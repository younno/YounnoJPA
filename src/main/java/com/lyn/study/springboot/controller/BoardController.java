package com.lyn.study.springboot.controller;

import java.util.Calendar;
import java.util.Optional;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyn.study.springboot.common.SqlUtils;
import com.lyn.study.springboot.entity.Board;
import com.lyn.study.springboot.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/list")
	public String list(Model model
			, @RequestParam(name="title", required = false) String title
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		model.addAttribute("list", boardService.list(pageable));
		return "board/list";
	}
	
	@RequestMapping("/findTitle")
	public String title(Model model
			, @RequestParam(name="title", required = true) String title
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		Board board = new Board();
		board.setTitle("%"+Optional.ofNullable(title).orElse("")+"%");
		model.addAttribute("list", boardService.findByTitleLike(board, pageable));
		return "board/list";
	}
	
	@RequestMapping("/findContent")
	public String content(Model model
			, @RequestParam(name="content", required = true) String content
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		Board board = new Board();
		board.setContent("%"+Optional.ofNullable(content).orElse("")+"%");
		model.addAttribute("list", boardService.findByContentLike(board, pageable));
		return "board/list";
	}
	
	@RequestMapping("/findWriter")
	public String writer(Model model
			, @RequestParam(name="writer", required = true) String writer
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		Board board = new Board();
		board.setWriter("%"+Optional.ofNullable(writer).orElse("")+"%");
		model.addAttribute("list", boardService.findByContentLike(board, pageable));
		return "board/list";
	}
	
	@RequestMapping("/findRegdate")
	public String regdate(Model model
			, @RequestParam(name="regdate1", required = true) String regdate1
			, @RequestParam(name="regdate2", required = true) String regdate2
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		Board board = new Board();
		board.setRegDate1(Optional.ofNullable(regdate1).orElse(Calendar.getInstance().getTime().toString()));
		board.setRegDate2(Optional.ofNullable(regdate2).orElse(Calendar.getInstance().getTime().toString()));
		model.addAttribute("list", boardService.findByRegDateBetween(board, pageable));
		return "board/list";
	}
	
	@RequestMapping("/findMulti")
	public String titleContent(Model model
			, @RequestParam(name="title", required = true) String title
			, @RequestParam(name="content", required = true) String content
			, @RequestParam(name="writer", required = true) String writer
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		log.debug("content = " + content + ", title = " + title);
		Board board = new Board();
		if(null != title) board.setTitle(SqlUtils.likeOpt(title));
		if(null != content) board.setContent(SqlUtils.likeOpt(content));
		if(null != writer) board.setWriter(SqlUtils.likeOpt(writer));
		model.addAttribute("list", boardService.findByMulti(board, pageable));
		return "board/list";
	}
	
	@RequestMapping("/sqlTitle")
	public String sqlTitle(Model model
			, @RequestParam(name="title", required = true) String title
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		log.debug("title = " + title);
		Board board = new Board();
		if(null != title) board.setTitle(SqlUtils.likeOpt(title));
		model.addAttribute("list", boardService.findByTitle(title,pageable));
		return "board/list";
	}
	
	
	@RequestMapping("/detail")
	public String id(Model model 
			, @RequestParam(name="id") int id
			, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
		Board board = new Board();
		
		board.setId(Optional.ofNullable(id).orElse(0));
		model.addAttribute("item", boardService.findById(board, pageable));
		return "board/detail";
	}
	
	
}

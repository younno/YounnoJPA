package com.lyn.study.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyn.study.springboot.service.BoardServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class BoardController {
	
	@Autowired
	BoardServiceImpl boardService;
	
	@RequestMapping("/")
	public String index() {
		
		log.debug("index >>>> ");
		
		return "hello";
	}
	
	@RequestMapping("/test")
	public String test() {
		log.debug("aaaaaa");
		return "test";
	}
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(defaultValue = "title") String type,
			@RequestParam(required = true) String query,
			@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 5) Pageable pageable) {
	
		log.debug("type = {} & query = {}" + type + ":" +  query);
		
		model.addAttribute("list", boardService.list(model, type, query, pageable));
		return "list";
	}
	
	/*
	@RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
*/
}

package com.themountaineers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.themountaineers.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/group/*")
public class GroupController {
	
	@GetMapping("/main")
	public void groupMain() {
		
	}
	
	@GetMapping("/create")
	public void groupCreate() {
		log.info("********** 그룹 생성 **********");
	}
	
	@PostMapping("/new")
	public String groupNew(){
		return null;
	}

}

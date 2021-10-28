package com.themountaineers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.themountaineers.domain.Criteria;
import com.themountaineers.domain.PageMaker;
import com.themountaineers.service.MountainInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/mountain/*")
public class MountainController {

	MountainInfoService service;
	
	@GetMapping("/list")
	public void list(Criteria cri,Model model){
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(9400);
		
		model.addAttribute("list", service.list(cri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("listImg",service.listImg());
		
	}
	
}

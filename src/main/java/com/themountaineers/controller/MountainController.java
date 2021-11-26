package com.themountaineers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.themountaineers.domain.Criteria;
import com.themountaineers.domain.MountainVO;
import com.themountaineers.domain.PageMaker;
import com.themountaineers.service.MountainInfoService;
import com.themountaineers.service.MountainService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/mountain/*")
public class MountainController {

	@Setter(onMethod_ = @Autowired)
	private MountainService service;
	
	@GetMapping("/main") 
	public void getMountainMain(Model model, 
			@RequestParam(value="lastmountain", required=false) String lastMountain,
			@RequestParam(value="keyword", required=false) String keyword) {
		log.info(lastMountain);
		log.info(keyword);
		
		if(lastMountain == null) {
			lastMountain = "nomountain";
		} 
		
		if(keyword == null) {
			keyword = "";
		}
		List<MountainVO> mountainList = service.getMountainList(lastMountain, keyword);
		model.addAttribute("mountains", mountainList);
	}
	
	@GetMapping("/getList")
	public @ResponseBody List<MountainVO> mountainGet(Model model,
			@RequestParam(value="lastmountain", required=false) String lastMountain,
			@RequestParam(value="keyword", required=false) String keyword) {
		log.info(lastMountain);
		log.info(keyword);
		
		if(lastMountain == null) {
			lastMountain = "nomountain";
		} 
		
		if(keyword == null) {
			keyword = "";
		}
		List<MountainVO> mountainList = service.getMountainList(lastMountain, keyword);
		return mountainList;
	}
}

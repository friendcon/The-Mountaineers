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
import com.themountaineers.domain.MountainPathVO;
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
		log.info(mountainList);
		return mountainList;
	}
	
	@GetMapping("/view")
	public void mountainView(Model model, @RequestParam(value="mountain_code") String mountain_code) {
		log.info("****************view************");
		MountainVO mountain = service.getMountainInfo(mountain_code);
		List<MountainPathVO> path = service.getpathList(mountain_code);
		for(MountainPathVO moun : path) {
			int upTime = Integer.parseInt(moun.getClimb_path_uptime());
			int downTime = Integer.parseInt(moun.getClimb_path_downtime());
			float length = Float.parseFloat(moun.getClimb_path_length());
			String changeLength = (float) (Math.floor(length*100)/100.0) +"";
			moun.setClimb_path_length(changeLength);
			moun.setClimb_path_uptime(changeTime(upTime));
			moun.setClimb_path_downtime(changeTime(downTime));
			
			if(moun.getClimb_path_name().equals(" ")) {
				moun.setClimb_path_name(mountain.getMountain_name());
			}
			log.info("1 : " + moun.getClimb_path_name());
		}
		
		
		model.addAttribute("mountain", mountain);
		model.addAttribute("path", path);
	}
	
	private static String changeTime(int time) {
		String finTime = null;
		if(time/60 >= 1) {
			int hour = time/60;
			int minute = time%60;
			finTime = hour + "시간 " + minute + "분";
		} else {
			finTime = time + "분";
		}
		return finTime;
	}
	
}

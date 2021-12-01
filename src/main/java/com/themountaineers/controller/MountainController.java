package com.themountaineers.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.core.authority.mapping.MappableAttributesRetriever;
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
	
	@GetMapping("/auth")
	public void mountainAuth(Model model, @RequestParam(value="mountain_code") String mountain_code){
		model.addAttribute("mountain_code", mountain_code);
	}
	
	@GetMapping("/compareXY")
	public @ResponseBody String mountainXYcompare(@RequestParam("mountaincode") String mountain_code, 
			@RequestParam("currentX") double currentX,
			@RequestParam("currentY") double currentY) {
		String resultVal = "";
		log.info("Asdasdasd");
		double mX = Double.parseDouble(String.valueOf(service.getMountainXY(mountain_code).get(0).get("mountain_y")));
		double mY = Double.parseDouble(String.valueOf(service.getMountainXY(mountain_code).get(0).get("mountain_x")));
		log.info(mX);
		
		double nowX = currentX;
		double nowY = currentY;
		double distanceMeter = distanceXY(mX, mY, nowX, nowY);
		log.info(distanceMeter);
		if(distanceMeter >= 100) {
			resultVal = "failauth";
		} else {
			resultVal = "succesauth";
		}
		log.info(resultVal);
		return resultVal;
	}
	
	private static double distanceXY(double mountainX, double mountainY, double nowX, double nowY) {
		double theta = mountainY-nowY;
		double dist = (Math.sin(deg2rad(mountainX))*Math.sin(deg2rad(nowX))
				+ Math.cos(deg2rad(mountainX))*Math.cos(deg2rad(nowX))*Math.cos(deg2rad(theta)));
		
		dist = Math.acos(dist);
	    dist = rad2deg(dist);
	    dist = (dist * 60 * 1.1515);
	    dist =(dist * 1609.344);
		return dist;
	}

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
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

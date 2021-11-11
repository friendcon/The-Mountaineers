package com.themountaineers.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupProfileVO;
import com.themountaineers.domain.GroupVO;
import com.themountaineers.service.GroupService;
import com.themountaineers.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/group/*")
public class GroupController {
	
	@Setter(onMethod_ = @Autowired)
	private GroupService service;
	
	@GetMapping("/main")
	public void groupMain(Model model) {
		log.info("********** 그룹 메인 페이지**********");
		
		
		List<GroupProfileVO> profiles = new ArrayList<>();
		for(GroupVO vo : service.groupTotal()){
			profiles.add(vo.getProfile());
		}
		
		List<String> thumPath = new ArrayList<>();
		for(GroupProfileVO profile : profiles) {
			String totalPath = "C:upload\\group\\profile\\";
			totalPath += profile.getGroup_photo_path();
			totalPath += "\\thum_" + profile.getGroup_photo_name();
			thumPath.add(totalPath);
		}
		
		model.addAttribute("groups", service.groupTotal());
		model.addAttribute("thumlist", thumPath);
	}
	
	@GetMapping("/create")
	public void groupCreate() {
		log.info("********** 그룹 생성 페이지**********");
	}
	
	@PostMapping("/new")
	public String groupNew(GroupVO group, Principal principal, @RequestParam("hashList") List<Integer> groupHashList){
		log.info("********** 그룹 생성 post **********");
		log.info(principal.getName());
		log.info(group);

		String memberId = principal.getName();

		GroupProfileVO profile = new GroupProfileVO();
		profile.setGroup_photo_name("noimage");
		profile.setGroup_photo_path("noimage");
		profile.setGroup_photo_type("noimage");
		profile.setUuid("noimage");
		group.setProfile(profile);
		
		service.groupInsert(group, memberId, groupHashList);
		
		return "redirect:/group/main";
	}


}

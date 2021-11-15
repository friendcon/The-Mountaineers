package com.themountaineers.controller;

import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	private static final int PAGESIZE = 9;
	
	@Setter(onMethod_ = @Autowired)
	private GroupService service;
	
	@GetMapping("/getImg/{group_no}")
	public void groupGetImg(@PathVariable("group_no") int group_no, HttpServletResponse response) throws Exception {

		String groupImagePath = "file:///C:/upload//themountaineers//group//profile//";
		GroupProfileVO profile = service.groupProfileGet(group_no);
		if(profile.getGroup_photo_name().equals("noimage")){
			groupImagePath += "thum_noimage.jpg";
		} else {
			groupImagePath += profile.getGroup_photo_path().replace('\\', '/') + "\\" + "thum_" + profile.getGroup_photo_name();
		}

		URL fileUrl = new URL(groupImagePath);
		IOUtils.copy(fileUrl.openStream(), response.getOutputStream());
	}
	
	@GetMapping("/main")
	public void groupMain(Model model, @RequestParam(value="hashList", required=false) List<Integer> hashList,
			@RequestParam(value="lastGroup", required=false) String lastGroup) {
		log.info("********** 그룹 메인 페이지**********");
		
		
		log.info("해시 : " + hashList);
		log.info("마지막 그룹 : " + lastGroup);
		List<GroupProfileVO> profiles = new ArrayList<>();
		int lastCursor = 0;
		
		if(lastGroup == null) {
			lastCursor = 0;
		} else {
			lastCursor = Integer.parseInt(lastGroup);
		}
		
		List<GroupVO> groupList = service.groupTotal(hashList, lastCursor);
		
		for(GroupVO vo : groupList){
			profiles.add(vo.getProfile());
		}
		
		model.addAttribute("groups", groupList);
	}
	
	@GetMapping("/getlist")
	public @ResponseBody List<GroupVO> groupGetList(Model model, 
			@RequestParam(value="hashList[]", required=false) List<Integer> hashList,
			@RequestParam(value="lastGroup", required=false) String lastGroup){
		List<GroupProfileVO> profiles = new ArrayList<>();
		List<Integer> list = hashList;
		int lastCursor = Integer.parseInt(lastGroup);
		
		log.info("해시 : " + hashList);
		log.info("마지막 그룹 : " + lastGroup);
		
		if(lastGroup == null) {
			lastCursor = 0;
		} else {
			lastCursor = Integer.parseInt(lastGroup);
		}

		List<GroupVO> groups = service.groupTotal(list, lastCursor);
		groups.forEach(group -> log.info(group.getGroup_no()));
		for(GroupVO vo : groups){
			profiles.add(vo.getProfile());
		}
		
		return groups;
	}
	
	@GetMapping("/create")
	public void groupCreate() {
		log.info("********** 그룹 생성 페이지**********");
	}
	
	@PostMapping("/new")
	public String groupNew(GroupVO group, Principal principal, 
			@RequestParam("hashList") List<Integer> groupHashList){
		log.info("********** 그룹 생성 post **********");
		log.info(principal.getName());
		log.info(group);

		String memberId = principal.getName();

		if(group.getProfile() == null) {
			GroupProfileVO profile = new GroupProfileVO();
			profile.setGroup_photo_name("noimage");
			profile.setGroup_photo_path("noimage");
			profile.setGroup_photo_type("noimage");
			profile.setUuid("noimage" + group.getGroup_no());
			group.setProfile(profile);
		}
		
		service.groupInsert(group, memberId, groupHashList);
		
		return "redirect:/group/main";
	}


}

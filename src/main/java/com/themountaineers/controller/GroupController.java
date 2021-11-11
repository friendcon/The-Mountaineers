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
	public void groupMain(Model model) {
		log.info("********** 그룹 메인 페이지**********");
		
		
		List<GroupProfileVO> profiles = new ArrayList<>();
		for(GroupVO vo : service.groupTotal()){
			profiles.add(vo.getProfile());
		}
		
		/*List<String> thumPath = new ArrayList<>();
		for(GroupProfileVO profile : profiles) {
			//String totalPath = "C:upload\\group\\profile\\";
			String totalPath = "";
			
			if(profile.getGroup_photo_name().equals("noimage")){
				totalPath += "\\thum_noimage.jpg";
				thumPath.add(totalPath);
			} else {
				totalPath += profile.getGroup_photo_path();
				totalPath += "\\thum_" + profile.getGroup_photo_name();
				thumPath.add(totalPath);
			}
		}*/
		
		model.addAttribute("groups", service.groupTotal());
		//model.addAttribute("thumlist", thumPath);
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

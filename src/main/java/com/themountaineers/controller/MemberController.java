package com.themountaineers.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.themountaineers.domain.MemberVO;
import com.themountaineers.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	// 회원 권한 거부시 이동 페이지
	@GetMapping("/login")
	public void memberLogin(String error, String logout, Model model) {
		log.info("********** member login **********");
		log.info("********** error : " + error + " **********");
		log.info("********** logout : " + logout + " **********");
		
		if(error != null) {
			model.addAttribute("error", "Login Error ! 계정을 확인하세요");
		} 
		
		if(logout != null) {
			model.addAttribute("logout", "Logout !");
		}
	}
	
	@GetMapping("/logout")
	public void memberLogout(){
		log.info("********** member logout **********");
	}
	
	@ResponseBody
	@GetMapping("/idCheck")
	public String memberIdCheck(@RequestParam Map<String, Object> param) {
		log.info("********** member id check **********");
		String memberId = (String) param.get("id");
		log.info("id : " + memberId);
		String checkId = service.memberIdCheck(memberId);
		log.info("result : " + checkId);
		if(checkId != null) {
			return "notavailable";
		} else {
			return "available";
		}
	}
	
	// 회원가입 관련 페이지
	@GetMapping("/join")
	public void memberJoin() {
		log.info("********** member join page **********");
	}
	
	@GetMapping("/loginsuccess") 
	public void memberLoginSuccess() {
		log.info("********** login success **********");
	}
	@PostMapping("/new")
	public String memberJoin(MemberVO member) {
		log.info("********** member join post **********");
		log.info(member);
		if(member.getProfile() != null){
			log.info(member.getProfile());
		}
		log.info(service.memberjoin(member));
		return "redirect:/member/fin";
	}
	
	@GetMapping("/fin")
	public void memberJoinFin() {
		log.info("********** member join fin page **********");
	}

	// 회원정보 조회 페이지
	@GetMapping("/read/{memberId}")
	public void memberRead(@PathVariable("memberId") String memberId, Model model) {
		log.info("********** member read page **********");
		model.addAttribute("member", service.memberRead(memberId));
	}
	
	// 회원정보 수정
	@PostMapping("/modify/{memberId}")
	public String memberModify(@PathVariable("memberId") String memberId,
			MemberVO member) {
		log.info("********** member modify post **********");
		service.memberModify(member);
		return "redirect:/member/read/" + memberId;
	}
	
	// 회원탈퇴 
	@GetMapping("/delete")
	public void memberDelete() {
		log.info("********** member delete page **********");
	}

	@PostMapping("/delete/{memberId}")
	public String memberDeleteFin() {
		log.info("********** member delete post **********");
		return "redirect:/";
	}
}

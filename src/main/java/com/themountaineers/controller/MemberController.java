package com.themountaineers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	// ȸ������ ���� ������
	@GetMapping("/join")
	public void memberJoin() {
		log.info("********** member join page **********");
	}
	
	@PostMapping("/new")
	public String memberJoin(MemberVO member) {
		log.info("********** member join post **********");
		log.info(member);
		log.info(service.memberjoin(member));
		return "redirect:/member/fin";
	}
	
	@GetMapping("/fin")
	public void memberJoinFin() {
		log.info("********** member join fin page **********");
	}

	// ȸ������ ��ȸ ������
	@GetMapping("/read/{memberId}")
	public void memberRead(@PathVariable("memberId") String memberId, Model model) {
		log.info("********** member read page **********");
		model.addAttribute("member", service.memberRead(memberId));
	}
	
	// ȸ������ ����
	@PostMapping("/modify/{memberId}")
	public String memberModify(@PathVariable("memberId") String memberId,
			MemberVO member) {
		log.info("********** member modify post **********");
		service.memberModify(member);
		return "redirect:/member/read/" + memberId;
	}
	
	// ȸ��Ż�� 
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

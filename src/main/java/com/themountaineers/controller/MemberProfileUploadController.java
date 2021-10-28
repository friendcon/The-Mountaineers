package com.themountaineers.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MemberProfileUploadController {
	@GetMapping("/uploadProfile")
	public void uploadProfileForm() {
		log.info("********** upload profile form controller **********");
	}

	@PostMapping("/uploadProfilePost")
	public void uploadProfileFormPost(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload\\themountaineers";
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("********** Upload File Name**********");
			log.info("File Name : " + multipartFile.getOriginalFilename());
			log.info("File Size : " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
		
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
}

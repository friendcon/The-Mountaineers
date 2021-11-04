package com.themountaineers.controller;

import java.io.File;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.themountaineers.domain.ProfileVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/profile/*")
public class MemberProfileUploadController {
	
	@ResponseBody
	@PostMapping(value="/upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProfileVO> uploadProfileFormPost(MultipartFile uploadFile, String memberId) {
		log.info("**********upload ajax**********");
		String uploadFolder = "C:\\upload\\themountaineers\\profile\\" + memberId;
		ProfileVO profile = new ProfileVO();

		
		if(uploadFile == null){
			log.info("null이라고");
			new ResponseEntity<>(profile, HttpStatus.NOT_FOUND);
		}
		
		// 업로드 경로 생성
		File uploadPath = new File(uploadFolder);

		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		} else {
			// 디렉토리 존재시 디렉토리 안 파일 삭제
			File[] list = uploadPath.listFiles();
			
			for(int i=0; i<list.length; i++){
				list[i].delete();
				log.info(list[i].getName() + "파일 삭제");
			}
		}
		
		log.info("********** Upload File Name**********");
		log.info("File Name : " + uploadFile.getOriginalFilename());
		log.info("File Size : " + uploadFile.getSize());

		String uploadFileName = uploadFile.getOriginalFilename();
		String extension = uploadFileName.substring(uploadFileName.indexOf(".") + 1);
		log.info("Real File Name : " + memberId + extension);
		log.info(uploadFolder + uploadFileName);
		// 서버 경로에 파일 생성
		File saveFile = new File(uploadFolder, uploadFileName);
		
		profile.setMem_id(memberId);
		profile.setProfile_name(memberId + extension);
		profile.setProfile_path(uploadPath.getPath());
		profile.setProfile_type(extension);
		
		log.info(profile);
		try {
			uploadFile.transferTo(saveFile);
		} catch (Exception e) {
			log.error(e);
		}
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}
}

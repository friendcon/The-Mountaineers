package com.themountaineers.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.themountaineers.domain.GroupProfileVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/groupprofile/*")
public class GroupUploadController {
	
	@ResponseBody
	@PostMapping(value="/upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<GroupProfileVO> uploadGroupProfileFormPost(MultipartFile uploadFile){
		log.info("**********group profile upload ajax**********");
		String uploadFolder = "C:\\upload\\themountaineers\\group\\profile";
		
		if(uploadFile == null) {
			log.info("첨부파일 없음");
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		File uploadPath = new File(uploadFolder, getFolder());
		
		if(uploadPath.exists() == false){
			uploadPath.mkdirs();
		}
		
		log.info("********** Upload File Name**********");
		log.info("File Name : " + uploadFile.getOriginalFilename());
		log.info("File Size : " + uploadFile.getSize());
		
		UUID uuid = UUID.randomUUID();
		
		String uploadFileName = uuid.toString() + "_" + uploadFile.getOriginalFilename();
		
		GroupProfileVO profile = new GroupProfileVO();
		
		String extension = uploadFileName.substring(uploadFileName.indexOf(".") + 1);
		
		profile.setUuid(uuid.toString());
		profile.setGroup_photo_path(getFolder());
		profile.setGroup_photo_name(uploadFileName);
		profile.setGroup_photo_type(extension);
	
		try {
			File saveFile = new File(uploadFolder + "//" + getFolder(), uploadFileName);
			uploadFile.transferTo(saveFile);
			if(checkImageType(saveFile)) {
				FileOutputStream thumnail = new FileOutputStream(new File(uploadPath,
						"thum_" + uploadFileName));
				/*Thumbnailator.createThumbnail(uploadFile.getInputStream(), thumnail, 100, 100);
				thumnail.close();*/
				Thumbnails.of(uploadFile.getInputStream())
				.scale(0.45).outputFormat(extension).toOutputStream(thumnail);
				thumnail.close();
			}
		} catch (Exception e) {
			log.error(e);
		}
		return new ResponseEntity<GroupProfileVO>(profile, HttpStatus.OK);
	}
	
	private String getFolder(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file){
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

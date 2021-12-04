package com.themountaineers.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MountainAuthPostServiceImpl implements MountainAuthPostService{

	@Setter(onMethod_ = @Autowired)
	private AmazonS3 awsS3Service;

	private static final String BUCKETNAME = "버킷이름";
	private static final Region REGIONNAME = Region.getRegion(Regions.AP_NORTHEAST_2);
	
	@Override
	public void uploadMountainAuthPostImage(String member_id, int climb_post_num, MultipartFile[] multipartFile) {
		
		awsS3Service.setRegion(REGIONNAME);
		
		int fileCount=0;
		for(MultipartFile file : multipartFile) {
			StringBuilder builder = new StringBuilder(member_id);
			ObjectMetadata metadata = new ObjectMetadata();
			
			String fileName = file.getOriginalFilename();
			log.info(fileName);
			String extension = fileName.substring(fileName.indexOf(".")+1);
			log.info(extension);
			if(extension.equalsIgnoreCase("jpg")) {
				log.info(extension);
				metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
			} else if(extension.equalsIgnoreCase("gif")) {
				metadata.setContentType(MediaType.IMAGE_GIF_VALUE);
			} else if(extension.equalsIgnoreCase("png")) {
				metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
			}
			metadata.setContentLength(file.getSize());
			
			builder.append("/" + climb_post_num + "/");
			builder.append((++fileCount) + "_" + file.getOriginalFilename());
			try {
				awsS3Service.putObject(BUCKETNAME, builder.toString(), file.getInputStream(), metadata);
			} catch (SdkClientException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<String> getUploadPath(MultipartFile[] multipartFiles) {
		List<String> pathList = new ArrayList<String>();
		List<String> pathURL = new ArrayList<>();
		
		for(MultipartFile file : multipartFiles) {
			
			StringBuilder builder = new StringBuilder("temp");
			UUID uuid = UUID.randomUUID();
			String path = file.getOriginalFilename();
			
			builder.append("/" + uuid.toString() + "_" + path);
			pathList.add(builder.toString());
			
			String extension = path.substring(path.indexOf(".")+1);
			ObjectMetadata metadata = new ObjectMetadata();
			
			if(extension.equalsIgnoreCase("jpg")) {
				metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
			} else if(extension.equalsIgnoreCase("gif")) {
				metadata.setContentType(MediaType.IMAGE_GIF_VALUE);
			} else if(extension.equalsIgnoreCase("png")) {
				metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
			}
			
			metadata.setContentLength(file.getSize());
			
			try {
				awsS3Service.putObject(BUCKETNAME, builder.toString(), file.getInputStream(), metadata);
			} catch (SdkClientException | IOException e) {
				e.printStackTrace();
			}
		}
		
		for(String path : pathList) {
			String[] splitPath = path.split("/");
			log.info(splitPath[0] + " : " + splitPath[1]);
			URL s3Path = awsS3Service.getUrl(splitPath[0], splitPath[1]);
			String url = "awss3주소" + splitPath[0] + "/" + splitPath[1];
			pathURL.add(url);
		}
		log.info(pathURL);
		return pathURL;
	}

}

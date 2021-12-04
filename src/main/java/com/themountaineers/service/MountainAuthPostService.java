package com.themountaineers.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface MountainAuthPostService {
	public void uploadMountainAuthPostImage(String member_id, int climb_post_num, MultipartFile[] multipartFile);
	public List<String> getUploadPath(MultipartFile[] multipartFiles);
}

package com.themountaineers.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MountainAuthPostServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private MountainAuthPostService service;
	
	@Test
	public void uploadServiceTest() {
		File file = new File("C:\\Users\\imhyy\\OneDrive\\바탕 화면", "1174530.jpg");
		MultipartFile files = null;
		try {
			files = new MockMultipartFile("file", file.getName(), "multipart/form-data", new FileInputStream(file));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		MultipartFile[] arr = {files};
		
		log.info(files);
		service.uploadMountainAuthPostImage("sleep1027", 1, arr);
	}
	
	/*@Test
	public void uploadPathGet() {
		File file = new File("C:\\Users\\imhyy\\OneDrive\\바탕 화면", "1174530.jpg");
		MultipartFile files = null;
		try {
			files = new MockMultipartFile("file", file.getName(), "multipart/form-data", new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		MultipartFile[] arr = {files};
		log.info(service.getUploadPath(arr));
	}*/
}

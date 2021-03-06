package com.themountaineers.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.themountaineers.domain.ClimbPathImageVO;
import com.themountaineers.domain.ClimbPostVO;
import com.themountaineers.domain.MountainVO;
import com.themountaineers.mapper.MountainMapper;
import com.themountaineers.mapper.MountainMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MountainServiceTests {
	@Setter(onMethod_ = @Autowired)
	private MountainService service;
	
	@Test
	public void selectMountain() {
		log.info(service.getMountainList("nomountain", "북한산"));
	}
	
	@Test
	public void mountainPostTests() {
		ClimbPostVO vo = new ClimbPostVO();
		vo.setMountain_code("112300301");
		vo.setMem_id("kakaocon");
		vo.setClimb_post_content("adsdsa");
		vo.setClimb_post_num(1);
		
		File file = new File("C:\\Users\\imhyy\\OneDrive\\바탕 화면", "asdasd.jpg");
		MultipartFile files = null;
		try {
			files = new MockMultipartFile("file", file.getName(), "multipart/form-data", new FileInputStream(file));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		MultipartFile[] arr = {files};
		
		service.postClimbAuth(vo, arr);
	}
}

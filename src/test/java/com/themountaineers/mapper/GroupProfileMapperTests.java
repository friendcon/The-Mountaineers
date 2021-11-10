package com.themountaineers.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.themountaineers.domain.GroupProfileVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class GroupProfileMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private GroupProfileMapper mapper;
	
	@Test
	public void insertGroupProfileTest(){
		GroupProfileVO profile = new GroupProfileVO();
		profile.setGroup_no(1);
		profile.setGroup_photo_name("photo");
		profile.setGroup_photo_path("//c");
		profile.setGroup_photo_type("png");
		profile.setUuid("dsaads");
		mapper.insertGroupProfile(profile);
	}
}

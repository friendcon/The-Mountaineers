package com.themountaineers.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.themountaineers.domain.ProfileVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class ProfileMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private ProfileMapper mapper;
	
	private String memberId = "sleep1027";
	
	/*@Test
	public void profileInsertTest() {
		ProfileVO profile = new ProfileVO();
		profile.setMem_id(memberId);
		profile.setProfile_name(memberId);
		profile.setProfile_path("c://themountaineers//profile");
		profile.setProfile_type("jpg");
		mapper.profileInsert(profile);
	}*/
	
	/*@Test
	public void profileCheckTest() {
		mapper.profileCheck(memberId);
	}
	 */
	
	/*@Test
	public void profileUpdateTest() {
		ProfileVO profile = new ProfileVO();
		profile.setMem_id(memberId);
		profile.setProfile_name(memberId);
		profile.setProfile_path("c://themountaineers//profile");
		profile.setProfile_type("jpg");
		mapper.profileInsert(profile);
		profile.setProfile_name("modify profile");
		mapper.profileUpdate(profile);
	}*/
}

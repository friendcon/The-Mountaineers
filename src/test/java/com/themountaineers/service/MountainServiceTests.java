package com.themountaineers.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}

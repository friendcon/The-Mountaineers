package com.themountaineers.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.themountaineers.domain.MountainVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MountainMapperTests {
	@Setter(onMethod_ = @Autowired)
	private MountainMapper mapper;
	
	@Test
	public void insertMountainTest() {
		MountainVO mountain = new MountainVO();
		MountainVO mountain2 = new MountainVO();
		List<MountainVO> list = new ArrayList<MountainVO>();
		mountain.setMountain_address("222");
		mountain.setMountain_code("1322");
		mountain.setMountain_content("asdads");
		mountain.setMountain_hight("ass");
		mountain.setMountain_name("adsasdads");
		mountain.setMountain_phone("asdasdasd");
		
		mountain2.setMountain_address("222");
		mountain2.setMountain_code("dss");
		mountain2.setMountain_content("asdads");
		mountain2.setMountain_hight("ass");
		mountain2.setMountain_name("adsasdads");
		mountain2.setMountain_phone("asdasdasd");
		list.add(mountain2);
		list.add(mountain);
		mapper.insertMountain(list);
	}
	
}

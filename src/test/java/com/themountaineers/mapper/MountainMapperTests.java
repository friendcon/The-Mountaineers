package com.themountaineers.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.themountaineers.domain.MountainPathVO;
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
	
	/*@Test
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
		
		mountain2.setMountain_address("서울특별시 성북구 석관동");
		mountain2.setMountain_code("112300301");
		mountain2.setMountain_content("북한산 사당동(동장대)에서 칼바위 능선을 따라 동남쪽으로 마구 뻗은 가지산이 다시 갈라져 화계사의 주봉을 "
				+ "이루고 수유리 고개를 지나 번동의 드림랜드가 있는 오패산을 이룬다. 여기서 다시 동남쪽으로 뻗은 구릉 줄기는 장위동 고개를 넘어 해발 140m의 천장산(天藏山)을 이룬다. "
				+ "그 서남쪽 가지산은 회묘터(경희대 의료원 자리)를 서쪽으로 감아돌아 다시 안화현을 넘어 청량사의 뒷산 봉우리인 바리봉을 이루며 다시 동남쪽으로 떡전고개를 뻗어 배봉을 만들고 "
				+ "중량천과 청풍계천(청계천)을 만나 산줄기는 끝이 난다. "
				+ "이렇게 북한산에서 뻗어 서울의 동쪽 외곽을 에워싼 한가닥의 산줄기 중간에 자리한 회기동과 청량리동에 걸쳐 천장산이 있다.");
		mountain2.setMountain_hight("0");
		mountain2.setMountain_name("천장산");
		mountain2.setMountain_phone("02-2241-3114");
		list.add(mountain2);
		//list.add(mountain);
		mapper.insertMountain(list);
	}
	*/
	/*@Test
	public void insertMountainPathTest() {
		MountainPathVO path1 = new MountainPathVO();
		MountainPathVO path2 = new MountainPathVO();
		
		path1.setClimb_path_difficult("112300301");
		path1.setClimb_path_downtime("112300301");
		path1.setClimb_path_length("112300301");
		path1.setClimb_path_name("112300301");
		path1.setClimb_path_num("112300301");
		path1.setClimb_path_uptime("112300301");
		path1.setClimb_path_XY("112300301");
		path1.setMountain_code("112300301");
		
		path2.setClimb_path_difficult("112300301");
		path2.setClimb_path_downtime("112300301");
		path2.setClimb_path_length("112300301");
		path2.setClimb_path_name("112300301");
		path2.setClimb_path_num("112300302");
		path2.setClimb_path_uptime("112300301");
		path2.setClimb_path_XY("112300301");
		path2.setMountain_code("112300301");
		
		List<MountainPathVO> pathList = new ArrayList<>();
		pathList.add(path1);
		pathList.add(path2);
		mapper.insertMountainPath(pathList);
	}*/
	
	/*@Test
	public void selectMountainTest() {
		List<MountainVO> mountain = mapper.selectMountain("nomountain", "북한");
		log.info(mountain);
	}*/
	
	/*@Test
	public void getMountainNameCode() {
		mapper.getMountainNameCode();
	}*/
	
	/*@Test
	public void MountainImgInsert() {
		mapper.insertMountainImg("111100101", "dassda");
	}*/
	
	/*@Test
	public void MountainSelectInfo() {
		MountainVO vo = mapper.selectMountainDetail("112300101");
		log.info(vo);
		log.info(vo.getPathList());
	}*/
	
	/*@Test
	public void MountainNameAddrUpdate() {
		Map<String, Object> updateMap = new HashMap<>();
		updateMap.put("mountain_x", 10.213123123);
        updateMap.put("mountain_y", 10.213123123);
        updateMap.put("mountain_code", "112300101");
		mapper.updateMountainXYAddr(updateMap);
	}*/
	
	@Test
	public void MountainGetXY() {
		List<Map<String, String>> map = mapper.getXY("112300101");
		log.info(map);
	}
}

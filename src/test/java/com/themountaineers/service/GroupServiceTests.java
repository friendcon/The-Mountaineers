package com.themountaineers.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private GroupService service;
	
	/*@Test
	public void groupInsertTest() {
		GroupHashVO hash = new GroupHashVO(1,9);
		GroupHashVO hash2 = new GroupHashVO(1,10);
		
		List<GroupHashVO> list = new ArrayList<>();
		list.add(hash2);
		list.add(hash);
		
		GroupVO group = new GroupVO();
		group.setGroup_name("주말등산");
		group.setGroup_content("등산 중급자");
		group.setGroup_open(1);
		group.setGroup_count(30);
		
		service.groupInsert(group, list);
	}*/

	/*@Test
	public void groupMemberInsertTest() {
		GroupMemberVO groupmember = new GroupMemberVO();
		groupmember.setGroup_no(1);
		groupmember.setGroupmem_auth(3);
		groupmember.setMem_id("mount1027");
	}*/
	
	@Test
	public void groupTotalTest() {
		List<Integer> hashList = new ArrayList<>();
		hashList.add(3);
		hashList.add(4);
		hashList.add(14);
		service.groupTotal(hashList).forEach(group -> log.info(group));
	}
	
}

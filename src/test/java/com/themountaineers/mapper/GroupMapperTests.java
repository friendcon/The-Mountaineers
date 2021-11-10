package com.themountaineers.mapper;

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
import com.themountaineers.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

public class GroupMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	public GroupMapper mapper;
	
	/*@Test
	public void insertGroupTest() {
		GroupVO group = new GroupVO();
		group.setGroup_name("��� �����ڰ�");
		group.setGroup_content("��� �ʺ���");
		group.setGroup_open(1);
		group.setGroup_count(30);
		
		mapper.groupInsert(group);
	}*/
	
	/*@Test
	public void groupHashInsertTest() {
		List<GroupHashVO> group = new ArrayList<GroupHashVO>();
		for(int i=0; i<3; i++) {
			group.add(new GroupHashVO(1,i+4));
		}
		log.info(mapper.groupHashInsert(group));
	}*/
	
	/*@Test
	public void groupMemberInsertTest() {
		GroupMemberVO groupmember = new GroupMemberVO();
		groupmember.setGroup_no(1);
		groupmember.setGroupmem_auth(1);
		groupmember.setMem_id("sleep1027");
		mapper.groupMemberInsert(groupmember);
	}*/
}
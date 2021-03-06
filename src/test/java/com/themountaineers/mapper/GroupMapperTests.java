package com.themountaineers.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.themountaineers.domain.GroupClimbVO;
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
		group.setGroup_name("등산 가보자고");
		group.setGroup_content("등산 초보자");
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
	
	/*@Test
	public void groupTotalSelectTest(){
		mapper.groupTotalSelect().forEach(group -> log.info(group));
		List<GroupVO> list = mapper.groupTotalSelect();
		list.get(0).getGroupHashList().forEach(hash -> log.info("hash!!" + hash));
	}*/
	
	/*@Test
	public void groupTotalSelectHashTest() {
		List<Integer> hashList = new ArrayList<>();
		//assertThat(hashList, is(nullValue()));
		log.info("크기 : " + hashList.size());
		hashList.add(3);
		hashList.add(4);
		hashList.add(14);
		mapper.groupTotalSelect(hashList, 11, "").forEach(group -> log.info(group));
	}*/
	
	/*@Test
	public void groupViewTest(){
		GroupVO vo = mapper.groupView(1);
		log.info(vo);
	}*/
	
	/*@Test
	public void groupMemberCount(){
		log.info(mapper.groupMemberCount(1));
	}*/
	
	/*@Test
	public void groupScheduleInsertTest() {
		GroupClimbVO vo = new GroupClimbVO();
		vo.setGroup_no(1);
		vo.setStart_date("2021/11/17");
		vo.setFinish_date("2021/11/18");
		vo.setClimb_title("북한산 등반");
		vo.setClimb_content("불광역 3번출구에서 오전 10시에 만나요.");
		
		mapper.groupScheduleInsert(vo);
	}*/
	
	@Test
	public void groupScheduleGetTest(){
		log.info(mapper.groupScheduleGet(21));
	}
}

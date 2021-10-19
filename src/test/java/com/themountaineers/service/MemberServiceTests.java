package com.themountaineers.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.themountaineers.domain.MemberVO;
import com.themountaineers.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	private String memberId = "sleep1019";
	
	/*@Test
	public void memberJoinTest() {
		MemberVO member = new MemberVO();
		member.setMem_id(memberId);
		member.setMem_name("홍길동");
		member.setMem_pwd("sleep1015");
		member.setMem_email("sleep1015@gmail.com");
		member.setMem_phone("010-1234-5678");
		member.setMem_birth("1999-12-25");
		member.setMem_img("c://user");
		member.setMem_address("서울시");
		log.info(mapper.memberInsert(member));
	}*/

	/*@Test
	public void memberReadTest() {
		log.info(mapper.memberRead(memberId));
	}*/
	
	/*@Test
	public void memberModifyTest() {
		MemberVO member = mapper.memberRead(memberId);
		member.setMem_email("sleep1019@gmail.com");
		log.info(mapper.memberUpdate(member));
	}*/
	
	/*@Test
	public void memberDeleteTest() {
		log.info(mapper.memberDelete(memberId));
	}*/
}

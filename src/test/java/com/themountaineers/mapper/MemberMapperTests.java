package com.themountaineers.mapper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.themountaineers.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MemberMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	private String memberId = "sleep1027";
	
	/*@Test
	public void memberInsertTest() {
		MemberVO member = new MemberVO();
		member.setMem_id(memberId);
		member.setMem_name("홍길동");
		member.setMem_pwd("sleep1015");
		member.setMem_email("sleep1015@gmail.com");
		member.setMem_phone("010-1234-5678");
		member.setMem_birth("1999");
		member.setMem_img("c://user");
		member.setMem_address("서울시");
		member.setMem_month("12");
		member.setMem_day("25");
		log.info("insert 결과" + mapper.memberInsert(member));
	}
	
	@Test
	public void memberAuthInsertTest() {
		log.info(mapper.memberAuthInsert(memberId));
	}*/
	
	/*@Test
	public void memberReadTest() {
		log.info(mapper.memberRead("sleep1025"));
	}*/
	
	/*@Test
	public void memberUpdateTest() {
		MemberVO member = mapper.memberRead(memberId);
		log.info("before : " + member);
		member.setMem_address("sleep1018@gmail.com");
		log.info(mapper.memberUpdate(member));
		log.info("after : " + member);
	}*/
	
	/*@Test
	public void memberDeleteTest() {
		log.info(mapper.memberDelete(memberId));
	}*/
	
	/*@Test
	public void memberIdCheckTest() {
		log.info(mapper.memberIdCheck(memberId));
	}*/
}

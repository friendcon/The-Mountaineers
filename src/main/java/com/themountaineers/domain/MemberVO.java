package com.themountaineers.domain;


import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String mem_name;
	private String mem_id;
	private String mem_pwd;
	private String mem_email;
	private String mem_birth;
	private String mem_phone;
	private String mem_joindate;
	private String mem_address;
	private String mem_month;
	private String mem_day;
	
	private ProfileVO profile;
	
	private List<AuthVO> authList;
	
}

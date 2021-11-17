package com.themountaineers.domain;

import java.util.Date;

import lombok.Data;

@Data
public class GroupClimbVO {
	private int climb_no;
	private int group_no;
	private String start_date;
	private String finish_date;
	private String climb_title;
	private String climb_content;
}

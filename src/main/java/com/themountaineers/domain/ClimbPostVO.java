package com.themountaineers.domain;

import lombok.Data;

@Data
public class ClimbPostVO {
	private int climb_post_num;
	private String mem_id;
	private String mountain_code;
	private String climb_post_content;
}

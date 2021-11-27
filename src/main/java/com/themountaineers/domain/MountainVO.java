package com.themountaineers.domain;

import java.util.List;

import lombok.Data;

@Data
public class MountainVO {
	private String mountain_code;
	private String mountain_name;
	private String mountain_phone;
	private String mountain_hight;
	private String mountain_content;
	private String mountain_address;
	private String mountain_img_src;
	private double mountain_x;
	private double mountain_y;
	
	List<MountainPathVO> pathList;
}

package com.themountaineers.domain;

import lombok.Data;

@Data
public class MountainPathVO {
	private String climb_path_num;
	private String mountain_code;
	private String climb_path_XY;
	private String climb_path_difficult;
	private String climb_path_uptime;
	private String climb_path_downtime;
	private String climb_path_length;
	private String climb_path_name;
}

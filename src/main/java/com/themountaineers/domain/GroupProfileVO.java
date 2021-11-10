package com.themountaineers.domain;

import lombok.Data;

@Data
public class GroupProfileVO {
	private String uuid;
	private String group_photo_path;
	private String group_photo_name;
	private String group_photo_type;
	private int group_no;
}

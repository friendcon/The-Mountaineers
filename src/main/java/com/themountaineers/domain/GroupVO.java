package com.themountaineers.domain;

import java.util.List;

import lombok.Data;

@Data
public class GroupVO {
	private int group_no;
	private String group_name;
	private String group_content;
	private int group_point;
	private int group_count; // 그룹원 수
	private int group_open;
	
	private GroupProfileVO profile;
	private List<GroupHashVO> groupHashList;
}

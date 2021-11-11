package com.themountaineers.mapper;

import com.themountaineers.domain.GroupProfileVO;

public interface GroupProfileMapper {
	public int insertGroupProfile(GroupProfileVO profile);
	public GroupProfileVO groupProfileSelect(int group_no);
}

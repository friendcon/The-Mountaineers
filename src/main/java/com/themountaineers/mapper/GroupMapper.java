package com.themountaineers.mapper;

import java.util.List;

import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupVO;

public interface GroupMapper {
	public int groupInsert(GroupVO group);
	public int groupHashInsert(List<GroupHashVO> grouphash);
	public int groupMemberInsert(GroupMemberVO groupmember);
	public List<GroupVO> groupTotalSelect();
}

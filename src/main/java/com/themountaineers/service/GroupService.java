package com.themountaineers.service;

import java.util.List;

import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupVO;

public interface GroupService {
	public int groupInsert(GroupVO group, List<GroupHashVO> grouphash);
	public int groupMemberInsert(GroupMemberVO groupmember);
	
}

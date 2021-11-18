package com.themountaineers.service;

import java.util.List;

import com.themountaineers.domain.GroupClimbVO;
import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupProfileVO;
import com.themountaineers.domain.GroupVO;

public interface GroupService {
	public int groupInsert(GroupVO group, String memberId, List<Integer> groupHashList);
	public List<GroupVO> groupTotal(List<Integer> hashList, int lastGroup, String keyword);
	public GroupProfileVO groupProfileGet(int group_no);
	public GroupVO groupView(int group_no);
	public int groupMemCount(int group_no);
	public int groupScheduleInsert(GroupClimbVO schedule);
	public List<GroupClimbVO> groupScheduleGet(int group_no, String month);
}

package com.themountaineers.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupProfileVO;
import com.themountaineers.domain.GroupVO;

public interface GroupMapper {
	public int groupInsert(GroupVO group);
	public int groupHashInsert(List<GroupHashVO> grouphash);
	public int groupMemberInsert(GroupMemberVO groupmember);
	public List<GroupVO> groupTotalSelect(@Param("hashList") List<Integer> hashList,
			@Param("lastGroup") int lastGroup,
			@Param("keyword") String keyword);
}

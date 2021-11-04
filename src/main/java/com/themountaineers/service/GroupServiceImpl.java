package com.themountaineers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupVO;
import com.themountaineers.mapper.GroupMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

	@Setter(onMethod_ = @Autowired)
	private GroupMapper mapper;
	
	@Override
	public int groupInsert(GroupVO group, List<GroupHashVO> grouphash) {
		return mapper.groupInsert(group)*mapper.groupHashInsert(grouphash);
	}

	@Override
	public int groupMemberInsert(GroupMemberVO groupmember) {
		return mapper.groupMemberInsert(groupmember);
	}
	
}

package com.themountaineers.service;

import java.util.ArrayList;
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
	public int groupInsert(GroupVO group, String memberId, List<Integer> groupHashList) {
		int query1 = mapper.groupInsert(group);
		
		List<GroupHashVO> hashList = new ArrayList<GroupHashVO>();
		for(int hashNum : groupHashList) {
			hashList.add(new GroupHashVO(group.getGroup_no(), hashNum));
		}
		
		int query2 = mapper.groupHashInsert(hashList);
		GroupMemberVO groupmember = new GroupMemberVO();
		groupmember.setGroup_no(group.getGroup_no());
		groupmember.setGroupmem_auth(1);
		groupmember.setMem_id(memberId);
		int query3 = mapper.groupMemberInsert(groupmember);
		return query1*query2*query3;
	}
	
}

package com.themountaineers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.themountaineers.domain.GroupHashVO;
import com.themountaineers.domain.GroupMemberVO;
import com.themountaineers.domain.GroupProfileVO;
import com.themountaineers.domain.GroupVO;
import com.themountaineers.mapper.GroupMapper;
import com.themountaineers.mapper.GroupProfileMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

	@Setter(onMethod_ = @Autowired)
	private GroupMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private GroupProfileMapper profilemapper;
	
	@Transactional
	@Override
	public int groupInsert(GroupVO group, String memberId, List<Integer> groupHashList) {
		int query1 = mapper.groupInsert(group);
		log.info("결과 : " + query1);
		
		group.getProfile().setGroup_no(group.getGroup_no());
		
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
		int query4 = profilemapper.insertGroupProfile(group.getProfile());
		return query1*query2*query3*query4;
	}

	@Override
	public List<GroupVO> groupTotal(List<Integer> hashList, int lastGroup, String keyword) {
		log.info("서비스까지 왔어");
		return mapper.groupTotalSelect(hashList, lastGroup, keyword);
	}

	@Override
	public GroupProfileVO groupProfileGet(int group_no) {
		return profilemapper.groupProfileSelect(group_no);
	}
	
}

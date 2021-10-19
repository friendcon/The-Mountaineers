package com.themountaineers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themountaineers.domain.MemberVO;
import com.themountaineers.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public int memberjoin(MemberVO member) {
		return mapper.memberInsert(member);
	}

	@Override
	public MemberVO memberRead(String memberId) {
		return mapper.memberRead(memberId);
	}

	@Override
	public int memberModify(MemberVO member) {
		return mapper.memberUpdate(member);
	}

	@Override
	public int memberDelete(String memberId) {
		return mapper.memberDelete(memberId);
	}
	
}

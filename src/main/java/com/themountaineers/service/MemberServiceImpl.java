package com.themountaineers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.themountaineers.domain.MemberVO;
import com.themountaineers.mapper.MemberMapper;
import com.themountaineers.mapper.ProfileMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ProfileMapper profileMapper;
	
	@Setter(onMethod_ = @Autowired)
	private BCryptPasswordEncoder encoder;
	
	@Override
	@Transactional
	public int memberjoin(MemberVO member) {
		member.setMem_pwd(encoder.encode(member.getMem_pwd()));
		int insertQuery = mapper.memberInsert(member);
		int insertQuery2 = mapper.memberAuthInsert(member.getMem_id());
		int insertQuery3 = profileMapper.profileInsert(member.getProfile());
		return insertQuery*insertQuery2*insertQuery3;
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

	@Override
	public String memberIdCheck(String memberId) {
		return mapper.memberIdCheck(memberId);
	}
	
}

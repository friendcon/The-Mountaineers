package com.themountaineers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Setter(onMethod_ = @Autowired)
	private BCryptPasswordEncoder encoder;
	
	@Override
	public int memberjoin(MemberVO member) {
		member.setMem_pwd(encoder.encode(member.getMem_pwd()));
		return mapper.memberInsert(member) * mapper.memberAuthInsert(member.getMem_id());
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

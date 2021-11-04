package com.themountaineers.service;

import com.themountaineers.domain.MemberVO;

public interface MemberService {
	public int memberjoin(MemberVO member);
	public MemberVO memberRead(String memberId);
	public int memberModify(MemberVO member);
	public int memberDelete(String memberId);
	public String memberIdCheck(String memberId);
}

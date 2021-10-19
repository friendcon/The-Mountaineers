package com.themountaineers.mapper;

import com.themountaineers.domain.MemberVO;

public interface MemberMapper {
	public int memberInsert(MemberVO member); // 회원가입
	public MemberVO memberRead(String memberId); // 회원 1명 조회
	public int memberUpdate(MemberVO member); // 회원 정보 수정
	public int memberDelete(String memberId); // 회원 탈퇴
}

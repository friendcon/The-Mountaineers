package com.themountaineers.mapper;

import com.themountaineers.domain.MemberVO;

public interface MemberMapper {
	public int memberInsert(MemberVO member); // ȸ������
	public int memberAuthInsert(String memberId); // ��� ���� �߰�
	
	public MemberVO memberRead(String memberId); // ȸ�� 1�� ��ȸ
	
	public int memberUpdate(MemberVO member); // ȸ�� ���� ����
	public int memberDelete(String memberId); // ȸ�� Ż��
	public String memberPwRead(String memberId); // ��й�ȣ
}

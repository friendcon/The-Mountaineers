package com.themountaineers.mapper;

import com.themountaineers.domain.ProfileVO;

public interface ProfileMapper {
	public int profileInsert(ProfileVO profile);
	public int profileDelete(String mem_id);
	public String profileCheck(String mem_id);
	public int profileUpdate(ProfileVO profile);
}

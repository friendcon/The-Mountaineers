package com.themountaineers.service;

import java.util.List;

import com.themountaineers.domain.MountainVO;

public interface MountainService {
	public List<MountainVO> getMountainList(String lastMountain, String keyword);
}

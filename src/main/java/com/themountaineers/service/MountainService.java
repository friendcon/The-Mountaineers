package com.themountaineers.service;

import java.util.List;
import java.util.Map;

import com.themountaineers.domain.MountainPathVO;
import com.themountaineers.domain.MountainVO;

public interface MountainService {
	public List<MountainVO> getMountainList(String lastMountain, String keyword);
	public MountainVO getMountainInfo(String mountain_code);
	List<MountainPathVO> getpathList(String mountain_code);
	public List<Map<String, String>> getMountainXY(String mountain_code);

}

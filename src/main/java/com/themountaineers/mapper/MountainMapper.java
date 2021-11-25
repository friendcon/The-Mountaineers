package com.themountaineers.mapper;

import java.util.List;

import com.themountaineers.domain.MountainPathVO;
import com.themountaineers.domain.MountainVO;

public interface MountainMapper {
	public int insertMountain(List<MountainVO> mountainList);
	public String selectMountainCode(String code);
	public int insertMountainPath(List<MountainPathVO> pathList);
}

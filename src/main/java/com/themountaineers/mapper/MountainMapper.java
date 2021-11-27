package com.themountaineers.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.themountaineers.domain.MountainPathVO;
import com.themountaineers.domain.MountainVO;

public interface MountainMapper {
	public int insertMountain(List<MountainVO> mountainList);
	public String selectMountainCode(String code);
	public int insertMountainPath(List<MountainPathVO> pathList);
	public List<MountainVO> selectMountain(@Param("lastmountain") String lastmountain, 
			@Param("keyword") String keyword);
	public List<MountainVO> getMountainNameCode();
	public int insertMountainImg(@Param("mountain_code") String mountain_code,
			@Param("mountain_img_src") String mountain_img_src);
	public MountainVO selectMountainDetail(String mountain_code);
}

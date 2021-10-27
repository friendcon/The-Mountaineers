package com.themountaineers.service;

import com.themountaineers.domain.MountainInfoImgVO;
import com.themountaineers.domain.MountainInfoVO;

public interface MountainInfoService {
	int insert(MountainInfoVO vo);
	int count();
	int insertImg(MountainInfoImgVO vo);
}

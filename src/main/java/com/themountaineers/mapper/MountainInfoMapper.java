package com.themountaineers.mapper;

import java.util.List;

import com.themountaineers.domain.Criteria;
import com.themountaineers.domain.MountainInfoImgVO;
import com.themountaineers.domain.MountainInfoVO;

public interface MountainInfoMapper {
	int insert(MountainInfoVO vo);
	int count();
	int insertImg(MountainInfoImgVO vo);
	List<MountainInfoVO> list(Criteria cri);
	List<MountainInfoImgVO> listImg();
}

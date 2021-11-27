package com.themountaineers.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themountaineers.domain.MountainVO;
import com.themountaineers.mapper.MountainMapper;

import lombok.Setter;

@Service
public class MountainServiceImpl implements MountainService {

	@Setter(onMethod_ = @Autowired)
	private MountainMapper mapper;
	
	@Override
	public List<MountainVO> getMountainList(String lastMountain, String keyword) {
		return mapper.selectMountain(lastMountain, keyword);
	}

	@Override
	public MountainVO getMountainInfo(String mountain_code) {
		return mapper.selectMountainDetail(mountain_code);
	}

}

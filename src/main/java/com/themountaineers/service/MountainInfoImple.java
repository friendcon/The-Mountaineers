package com.themountaineers.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.themountaineers.domain.Criteria;
import com.themountaineers.domain.MountainInfoImgVO;
import com.themountaineers.domain.MountainInfoVO;
import com.themountaineers.mapper.MountainInfoMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MountainInfoImple implements MountainInfoService{

	private MountainInfoMapper mapper;
	
	@Override
	public int insert(MountainInfoVO vo) {		
		return mapper.insert(vo);
		
	}

	@Override
	public int count() {
		return mapper.count();
	}

	@Override
	public int insertImg(MountainInfoImgVO vo) {
		return mapper.insertImg(vo);
	}

	@Override
	public List<MountainInfoVO> list(Criteria cri) {
		return mapper.list(cri);
	}

	@Override
	public List<MountainInfoImgVO> listImg() {
		return mapper.listImg();
	}

}

package com.themountaineers.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.themountaineers.domain.MountainPathVO;
import com.themountaineers.domain.MountainVO;
import com.themountaineers.mapper.MountainMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
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
	
	@Override
	public List<MountainPathVO> getpathList(String mountain_code) {
		MountainVO mountain = mapper.selectMountainDetail(mountain_code);
		List<MountainPathVO> pathList = mountain.getPathList();
		//log.info(mountain);
		List<MountainPathVO> afterPathList = new ArrayList<>();

		String[] grade = {"쉬움", "중간", "어려움"};
		int [][] count = null;
		Set<String> pathName = new HashSet<>();
		
		/*
		 * 등산로 이름이 같은 것 끼리 묶음
		 */
		for(MountainPathVO path : pathList) {
			pathName.add(path.getClimb_path_name());
		}
		
		//log.info(pathName);
		
		/*
		 * 등산로 이름만큼 등산로 객체 생성
		 */
		for(String name : pathName){
			MountainPathVO vo = new MountainPathVO();
			vo.setClimb_path_name(name);
			afterPathList.add(vo);
		}
		
		count = new int[afterPathList.size()][3];
		
		// path 리스트중 하나
		for(MountainPathVO path : pathList) {
			String name = path.getClimb_path_name();
			System.out.println(pathName.size());
			for(int i=0; i<pathName.size(); i++) {
				String afterPathName = afterPathList.get(i).getClimb_path_name();
				if(name.equals(afterPathName)){
					MountainPathVO afterPath = afterPathList.get(i);

					// 등산시간 처리
					Integer uptime = null;
					Integer afterUpTime = null;
					
					try {
						uptime = Integer.parseInt(path.getClimb_path_uptime());
						afterUpTime = Integer.parseInt(afterPath.getClimb_path_uptime());
					} catch (Exception e) {
						if(uptime == null){
							uptime = 0;
						}
						if(afterUpTime == null){
							afterUpTime = 0;
						}
					}
					
					int totalUp = uptime + afterUpTime;
					afterPath.setClimb_path_uptime(totalUp+"");
					
					// 하산시간 처리
					Integer afterDownTime = null;
					Integer downtime = null;
					try {
						downtime = Integer.parseInt(path.getClimb_path_downtime());
						afterDownTime = Integer.parseInt(afterPath.getClimb_path_downtime()); 
					} catch (Exception e) {
						if(downtime == null){
							downtime = 0;
						}
						if(afterDownTime == null){
							afterDownTime = 0;
						}
					}
					
					int totalDown = downtime + afterDownTime;
					afterPath.setClimb_path_downtime(totalDown+"");
					
					// 등산거리 처리
					Float length = null;
					Float afterLength = null; 
					try {
						length = Float.parseFloat(path.getClimb_path_length());
						afterLength = Float.parseFloat(afterPath.getClimb_path_length());
					} catch (Exception e) {
						if(length == null){
							length = (float) 0;
						}
						if(afterLength == null){
							afterLength = (float) 0;
						}
					}
					
					float totalLength = length + afterLength;
					afterPath.setClimb_path_length(totalLength+"");
					
					// 등산로 좌표 처리
					String xy = path.getClimb_path_XY();
					System.out.println(xy);
					String afterXY = afterPath.getClimb_path_XY();
					System.out.println(afterXY);
					String totalXY = xy + afterXY;
					afterPath.setClimb_path_XY(totalXY);
					
					// 등산 난이도 처리}
					String mountainGrade = null;
					try {
						mountainGrade = path.getClimb_path_difficult();
					} catch (Exception e) {
						if(mountainGrade == null) {
							mountainGrade="알수없음";
						}
					}
					switch (mountainGrade) {
					case "쉬움":
						count[i][0]++;
						break;
					case "중간":
						count[i][1]++;
						break;
					case "어려움":
						count[i][2]++;
						break;
					}
				}
			}
		}
		// 등산 난이도 최대값 처리
		for(int i=0; i<afterPathList.size(); i++) {
			int max = 0;
			int num = 0;
			for(int j=0; j<3 ; j++) {
				if(count[i][j] > max) {
					max = count[i][j];
					num = j;
				}
			}
			if(num == 0) {
				afterPathList.get(i).setClimb_path_difficult("쉬움");
			} else if(num == 1){
				afterPathList.get(i).setClimb_path_difficult("중간");
			} else if(num == 2){
				afterPathList.get(i).setClimb_path_difficult("어려움");
			}
		}
		
		//log.info(afterPathList);
		return afterPathList;
	}
}

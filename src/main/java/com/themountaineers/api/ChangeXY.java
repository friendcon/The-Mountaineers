package com.themountaineers.api;

import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.CoordinateTransform;
import org.locationtech.proj4j.CoordinateTransformFactory;
import org.locationtech.proj4j.ProjCoordinate;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

public class ChangeXY {

	public static void main(String[] args) {
		CRSFactory crsFactory = new CRSFactory();
		CoordinateReferenceSystem kakao = crsFactory.createFromName("EPSG:5181");
		CoordinateReferenceSystem mountain = crsFactory.createFromName("EPSG:5186");
		
		CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
		
		CoordinateTransform KakaoToMountain = ctFactory.createTransform(kakao, mountain);
		ProjCoordinate result = new ProjCoordinate();
		KakaoToMountain.transform(new ProjCoordinate(183871.98187484033, 553662.63450966775), result);
		double realX = result.x;
		double realY = result.y;
		System.out.println(realX + ":" + realY);
	}
}

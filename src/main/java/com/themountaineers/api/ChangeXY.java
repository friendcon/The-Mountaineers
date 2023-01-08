package com.themountaineers.api;

import org.locationtech.proj4j.BasicCoordinateTransform;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.CoordinateTransform;
import org.locationtech.proj4j.CoordinateTransformFactory;
import org.locationtech.proj4j.Proj4jException;
import org.locationtech.proj4j.ProjCoordinate;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.ContentSecurityPolicyConfig;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

import net.coobird.thumbnailator.geometry.Position;

/**
 * Proj4j : 위도 경도 변환을 위해 테스트를 진행
 */
public class ChangeXY {

	public static void main(String[] args) {
		CRSFactory crsFactory = new CRSFactory();

		CoordinateReferenceSystem mountain = crsFactory.createFromName("EPSG:5186");

		CoordinateReferenceSystem kakao = crsFactory.createFromName("EPSG:4326");
		CoordinateReferenceSystem KAKAO2 = crsFactory.createFromName("EPSG:5181");
		
		BasicCoordinateTransform transform = new BasicCoordinateTransform(mountain, kakao);
		ProjCoordinate srcCoord = new ProjCoordinate(183871.98187484033,553662.63450966775);
		ProjCoordinate desCoord = new ProjCoordinate();
		System.out.println(transform.transform(srcCoord, desCoord));
	}
}

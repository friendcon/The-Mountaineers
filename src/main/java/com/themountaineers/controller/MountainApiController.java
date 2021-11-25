package com.themountaineers.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.locationtech.proj4j.BasicCoordinateTransform;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.ProjCoordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.themountaineers.domain.MountainPathVO;
import com.themountaineers.domain.MountainVO;
import com.themountaineers.mapper.MountainMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/API/*")
public class MountainApiController {
	@Setter(onMethod_ = @Autowired)
	private MountainMapper mapper;
	
	// JSON 을 PATHVO로 파싱
	private static MountainPathVO makePathVO(JsonObject attribute, String paths) {
		MountainPathVO mountainPathVO = new MountainPathVO();
		log.info("함수 : " + attribute);
		log.info(paths);
		String difficult = attribute.get("PMNTN_DFFL").toString();
		String downTime = attribute.get("PMNTN_GODN").toString();
		String pathLength = attribute.get("PMNTN_LT").toString();
		String pathName = attribute.get("PMNTN_NM").toString();
		String pathNum = attribute.get("PMNTN_SN").toString();
		String upTime = attribute.get("PMNTN_UPPL").toString();
		String mountainCode = attribute.get("MNTN_CODE").toString();
		mountainPathVO.setClimb_path_difficult(difficult.isEmpty() ? difficult= " " : difficult);
		mountainPathVO.setClimb_path_downtime(downTime.isEmpty() ? downTime=" " : downTime);
		mountainPathVO.setClimb_path_length(pathLength.isEmpty() ? pathLength = " " : pathLength);
		mountainPathVO.setClimb_path_name(pathName.isEmpty() ? pathName = " " : pathName);
		mountainPathVO.setClimb_path_num(pathNum.isEmpty() ? pathNum = " " : pathNum);
		mountainPathVO.setClimb_path_uptime(upTime.isEmpty() ? upTime = " " : upTime);
		mountainPathVO.setMountain_code(mountainCode.isEmpty() ? mountainCode = " " : mountainCode);
		mountainPathVO.setClimb_path_XY(paths);
		return mountainPathVO;
	}
	
	// 좌표 변환 
	private static String changeXY(Double x, Double y){
		CRSFactory crsFactory = new CRSFactory();
		CoordinateReferenceSystem mountain = crsFactory.createFromName("EPSG:5186");
		CoordinateReferenceSystem kakao = crsFactory.createFromName("EPSG:4326");
		
		BasicCoordinateTransform transform = new BasicCoordinateTransform(mountain, kakao);
		ProjCoordinate srcCoord = new ProjCoordinate(x,y);
		ProjCoordinate desCoord = new ProjCoordinate();
		Double latitude = transform.transform(srcCoord, desCoord).y;
		Double longitude = transform.transform(srcCoord, desCoord).x;
		//log.info(latitude + " " + longitude);
		String totalXY = latitude + "," + longitude + "/";
		return totalXY;
	}
	
	// 변환된 좌표 하나로 합치는 과정
	private static String addChangeXY(String[] result) {
		StringBuilder changedXY = new StringBuilder();
		for(String one : result) {
			String[] str = one.split(",");
			Double X = Double.parseDouble(str[0]);
			Double Y = Double.parseDouble(str[1]);
			changedXY.append(changeXY(X,Y));
		}
		//log.info(changedXY);
		return changedXY.toString();
	}
	
	// 경로 처리.. 
	private static String[] pathCheck(JsonElement paths) {
		JsonArray arr = paths.getAsJsonArray().getAsJsonArray();
		if(arr.size() == 1) {
			log.info("사이즈1");
			StringBuilder builder = new StringBuilder(paths.toString());
			builder.replace(0, 3, "");
			builder.replace(builder.length()-3, builder.length(), "");
			String strbuild = builder.toString();
			String[] splitResult = strbuild.split("\\],\\[");
			return splitResult;
		}
		List<String> list = new ArrayList<>();
		for(int i=0; i<arr.size(); i++) {
			log.info("사이즈1초과");
			StringBuilder p = new StringBuilder(arr.get(i).toString());
			p.replace(0, 2, "");
			p.replace(p.length()-2, p.length(), "");
			String[] splitResult = p.toString().split("\\],\\[");
			for(String add : splitResult){
				list.add(add);
			}
		}
		String[] result = list.toArray(new String[list.size()]);
		return result;
	}
	
	@GetMapping("/insertPath")
	public void mountainPathInsert() throws FileNotFoundException, ParseException {
		String path = "C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain\\unzip";
		File file = new File("C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain\\unzip");
		
		String[] fileNames = file.list();

		List<MountainPathVO> pathList = new ArrayList<>();
		
		Gson gson = new Gson();
		JsonObject jsonObj = null;
		JsonElement obj1 = null;
		JsonArray ar = null;
		
		for(String fileName : fileNames) {
			Reader reader = new FileReader(path + "\\" + fileName);
			//log.info(fileName);
			jsonObj = gson.fromJson(reader, JsonObject.class);
			obj1 = jsonObj.get("features");
			ar = obj1.getAsJsonArray();
			
			for(int i=0; i< ar.size(); i++) {
				JsonElement feature = ar.get(i);
				log.info(ar.get(i));
				JsonObject feature_Object = feature.getAsJsonObject();
				
				JsonObject attribute = feature_Object.get("attributes").getAsJsonObject();
				JsonElement paths = feature_Object.get("geometry").getAsJsonObject().get("paths");
				
				//pathCheck(paths);
				String changeResult = addChangeXY(pathCheck(paths));

				MountainPathVO pathVO = makePathVO(attribute, changeResult);
				pathList.add(pathVO);
			}
		}
		
		mapper.insertMountainPath(pathList);
	}
	
	@GetMapping("/readJSON")
	public void mountainJsonInsert() throws IOException {
		String path = "C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain";

		File directory = new File(path); //복제대상 폴더
		String[] fileNames = directory.list();
		
		List<String> fileNameList = new ArrayList<String>();
		List<String> mountCode = new ArrayList<>();
		
		// J S O N 파일 이름만 추출
		for(String name : fileNames) {
			if(name.contains("geojson")) {
				fileNameList.add(name);
			}
		}

		// db에 있는 산만 추출
		for(String name : fileNameList) {
			String code = name.substring(0, 9);
			if(code.equals(mapper.selectMountainCode(code))){
				mountCode.add(name);
			}
		}
		
		// 해당 파일들만 압축 풀어서 폴더에 복제하기
		for(String name : mountCode) {
			File file = new File(path, name);
			ZipInputStream zis = new ZipInputStream(new FileInputStream(file)
					, Charset.forName("EUC-KR"));
			copyFiles(file, zis);
		}
	}
	
	@GetMapping("/mountainInsert")
	public void mountainDataInsert() throws IOException, ParserConfigurationException, SAXException {
		
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI"); 
	     urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + 
	    		 "=서비스키"); 
	     urlBuilder.append("&" + URLEncoder.encode("searchWrd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); 
	     urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" 
	     + URLEncoder.encode("서비스키", "UTF-8")); 
	     
        List<MountainVO> mountainList = new ArrayList<>();
        
        for(int k = 1; k<472; k++) {
        	int urlLength = urlBuilder.length();
        	log.info("pageNo의 위치" + urlBuilder.indexOf("pageNo"));
        	if(urlBuilder.indexOf("pageNo") != -1) {
        		urlBuilder.delete(urlBuilder.indexOf("&pageNo"), urlLength);
        		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(k+"", "UTF-8"));
        	} else {
        		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(k+"", "UTF-8"));
        	}
        	
        	URL url = new URL(urlBuilder.toString());
        	log.info(urlBuilder.toString());
        	log.info("길이" + urlBuilder.length());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            log.info("Response code: " + conn.getResponseCode());
            BufferedReader rd;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            String result;
            while ((line = rd.readLine()) != null) {          	
                sb.append(line);
            }
        	
            rd.close();
            conn.disconnect();
            result = sb.toString();
            log.info(result.getBytes());
        	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder builders = builderFactory.newDocumentBuilder();
            InputStream input = new ByteArrayInputStream(result.getBytes());
            Document document = builders.parse(input);
            document.getDocumentElement().normalize();
            Element element = document.getDocumentElement();
            NodeList dd = element.getElementsByTagName("item");
            int n = dd.getLength();
            log.info("데이터 길이 : " + n);
            for(int i=0; i<n; i++) {
            	log.info(i + "번째");
            	Node item = dd.item(i);
            	NodeList list = item.getChildNodes();
            	MountainVO vo = makeMountain(list);
            	log.info("리턴값 : " + vo);
            	mountainList.add(vo);
            }

            log.info(sb.toString());
        }
        log.info("리스트 : " + mountainList);
        mapper.insertMountain(mountainList);
	}
	
	private static MountainVO makeMountain(NodeList list) {
		MountainVO mountain = new MountainVO();
		
		for(int i=0; i<list.getLength(); i++) {
			Node node = list.item(i);
			String attr = node.getNodeName();
			String value = node.getTextContent();
			System.out.println("데이터값은 !! " + value);
			if(value.equals("( - )")) {
				value = "";
			}
			if(attr.equals("mntiadd")){
				mountain.setMountain_address(value);
			} else if(attr.equals("mntidetails")){
				mountain.setMountain_content(value);
			} else if(attr.equals("mntiadminnum")){
				mountain.setMountain_phone(value);
			} else if(attr.equals("mntilistno")){
				mountain.setMountain_code(value);
			} else if(attr.equals("mntihigh")){
				mountain.setMountain_hight(value);
			} else if(attr.equals("mntiname")){
				mountain.setMountain_name(value);
			}
		}
		log.info(mountain);
		return mountain;
	}
	
	private static void copyFiles(File file, ZipInputStream zis) throws IOException {
		ZipEntry entry = null;
		String unzipPath = "C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain\\unzip";

		while((entry = zis.getNextEntry()) != null) {
			if(!entry.getName().contains("SPOT") && !entry.getName().contains("txt")) {
				File newFile = new File(unzipPath, entry.getName());
				FileOutputStream fos = null;
				
				try {
					fos = new FileOutputStream(newFile);
					byte[] buffer = new byte[400];
					int size = 0;
					while((size = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, size);
					}
				} catch (Exception e) {
					log.error(e);
					throw e;
				}
				fos.close();
			}
		}
		
		zis.close();
	}
}


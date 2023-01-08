package com.themountaineers.service;

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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.locationtech.proj4j.BasicCoordinateTransform;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.ProjCoordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.themountaineers.domain.MountainPathVO;
import com.themountaineers.domain.MountainVO;
import com.themountaineers.mapper.MountainMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MountainApiServiceImpl implements MountainApiService {
	@Setter(onMethod_ = @Autowired)
	private MountainMapper mapper;

	/**
	 * getMountainDetailInfo() : 산 상세정보는.. 카카오 맵 API 를 사용하였습니다..
	 * 정상의 위도경도, 산 주소, 산 코드
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public void getMountainDetailInfo() throws UnsupportedEncodingException {
		String appKey = "KakaoAK key";

		List<MountainVO> mountainList = mapper.getMountainNameAddr();
		for(MountainVO mountain : mountainList) {
			String mountainName = mountain.getMountain_name();
			String mountainAddr = mountain.getMountain_address();
			//String total = mountainAddr + " " + mountainName;
			String mountainCode = mountain.getMountain_code();
			StringBuilder urlBuilder = new StringBuilder("http://dapi.kakao.com/v2/local/search/keyword.json");
			urlBuilder.append("?" + URLEncoder.encode("query","UTF-8") + "=");
			urlBuilder.append(URLEncoder.encode(mountainName, "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("category_group_code", "UTF-8") + "=AT4");

			try {
				
				URL url = new URL(urlBuilder.toString());
				log.info(url.toString());
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            
	            
	            con.setRequestMethod("GET");
	            con.setRequestProperty("Authorization", appKey);
	            con.setRequestProperty("Host", "dapi.kakao.com");
	            con.setDoOutput(true);

                int responseCode = con.getResponseCode();
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {  // 에러 발생
                	log.info("*******************************" + urlBuilder);
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(url.toURI());
                System.out.println("외않데?" + response.toString());
                log.info("url : " +url.toString());
                Gson gson = new Gson();
                JsonObject obj = gson.fromJson(response.toString(), JsonObject.class);
                JsonObject finArr = obj.get("documents").getAsJsonArray().get(0).getAsJsonObject();
                
                log.info(finArr);
                Map<String, Object> updateMap = new HashMap<>();
                updateMap.put("mountain_x", finArr.get("x").getAsDouble());
                updateMap.put("mountain_y", finArr.get("y").getAsDouble());
                updateMap.put("mountain_address", finArr.get("address_name").getAsString());
                updateMap.put("mountain_code", mountainCode);
                mapper.updateMountainXYAddr(updateMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	/**
	 * getImg() : 네이버 검색 API 에서 산 이미지를 가져온다
	 */
	@Override
	public void getImg() {
		String clientId = "clintId";
        String clientSecret = "SecretKey";
        List<MountainVO> mountainList = mapper.getMountainNameCode();

        log.info(mountainList);
        for(MountainVO mountain : mountainList) {
        	
        	try {
                StringBuilder urlBuilder = new StringBuilder("https://openapi.naver.com/v1/search/image");
                urlBuilder.append("?" + URLEncoder.encode("query","UTF-8") + "=");
                urlBuilder.append(URLEncoder.encode(mountain.getMountain_name(), "UTF-8"));
                urlBuilder.append("&" + URLEncoder.encode("display","UTF-8") + "=");
                urlBuilder.append(URLEncoder.encode("10", "UTF-8"));

                URL url = new URL(urlBuilder.toString());
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                log.info("url : " +url.toString());
                con.setRequestMethod("GET");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

                con.setDoOutput(true);

                int responseCode = con.getResponseCode();
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {  // 에러 발생
                	log.info("*******************************" + urlBuilder);
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                Gson gson = new Gson();
                JsonObject obj = gson.fromJson(response.toString(), JsonObject.class);
                JsonObject finArr = obj.get("items").getAsJsonArray().get(0).getAsJsonObject();
                String imgurl = finArr.get("thumbnail").getAsString();
                log.info(mountain.getMountain_code() + " : " + imgurl);
                log.info("code: " + mountain.getMountain_code());
                String code = mountain.getMountain_code();
                mapper.insertMountainImg(code, imgurl);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
	}

	/**
	 * mountainPathInsert() : unzip 폴더에서 파일 하나씩 순회하며 등산로 경로 Path 를 String 으로 만든 후 DB에 저장
	 * @throws FileNotFoundException
	 */

	@Override
	public void mountainPathInsert() throws FileNotFoundException {
		String path = "C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain\\unzip";
		File file = new File("C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain\\unzip");
		
		String[] fileNames = file.list();

		List<MountainPathVO> pathList = new ArrayList<>();
		
		Gson gson = new Gson();
		JsonObject jsonObj = null;
		JsonElement obj1 = null;
		JsonArray ar = null;
		int count = 1;
		for(String fileName : fileNames) {
			
			count++;
			MountainPathVO pathVO = null;
			
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

				String changeResult = addChangeXY(pathCheck(paths));

				pathVO = makePathVO(attribute, changeResult);
				pathList.add(pathVO);
			}
			
			if(count % 50 == 0) {
				log.info("여기");
				mapper.insertMountainPath(pathList);
				pathList = new ArrayList<>();
			}
		}
	}

	@Override
	public void readMountainJSON() throws IOException {
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

	/**
	 * mountain 정보 OPEN API 를 활용하여 저장..
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	@Override
	public void mountainInsert() throws ParserConfigurationException, IOException, SAXException {
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI"); 
	     urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + 
	    		 "key"); 
	     urlBuilder.append("&" + URLEncoder.encode("searchWrd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); 
	     urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" 
	     + URLEncoder.encode("key", "UTF-8")); 
	     
        //List<MountainVO> mountainList = new ArrayList<>();
        List<Map<String, String>> mountainList = new ArrayList<>();
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
            	//MountainVO vo = makeMountain(list);
            	Map<String, String> vo = getMountainName(list);
            	log.info("리턴값 : " + vo);
            	mapper.updateAddrFin(vo);
            	//mountainList.add(vo);
            }

            log.info(sb.toString());
        }
        log.info("리스트 : " + mountainList);
        //mapper.insertMountain(mountainList);
        
	}
	
	private static MountainVO makeMountain(NodeList list) {
		MountainVO mountain = new MountainVO();
		for(int i=1; i<=list.getLength(); i++) {
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
	
	private static Map<String,String> getMountainName(NodeList list) {
		MountainVO mountain = new MountainVO();
		Map<String, String> map = new HashMap<>();
		for(int i=0; i<list.getLength(); i++) {
			Node node = list.item(i);
			String attr = node.getNodeName();
			String value = node.getTextContent();
			System.out.println("데이터값은 !! " + value);
			if(value.equals("( - )")) {
				value = "";
			}
			if(attr.equals("mntilistno")){
				map.put("mountain_code", value);
			} else if(attr.equals("mntiadd")){
				map.put("mountain_address", value);
			} 
		}
		log.info(mountain);
		return map;
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
	
	// JSON 을 PATHVO로 파싱
		private static MountainPathVO makePathVO(JsonObject attribute, String paths) {
			MountainPathVO mountainPathVO = new MountainPathVO();
			//log.info("함수 : " + attribute);
			//log.info(paths);
			String difficult = attribute.get("PMNTN_DFFL").getAsString();
			String downTime = attribute.get("PMNTN_GODN").getAsString();
			String pathLength = attribute.get("PMNTN_LT").getAsString();
			String pathName = attribute.get("PMNTN_NM").getAsString();
			String pathNum = attribute.get("PMNTN_SN").getAsString();
			String upTime = attribute.get("PMNTN_UPPL").getAsString();
			String mountainCode = attribute.get("MNTN_CODE").getAsString();
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
				//log.info("사이즈1");
				StringBuilder builder = new StringBuilder(paths.toString());
				builder.replace(0, 3, "");
				builder.replace(builder.length()-3, builder.length(), "");
				String strbuild = builder.toString();
				String[] splitResult = strbuild.split("\\],\\[");
				return splitResult;
			}
			List<String> list = new ArrayList<>();
			for(int i=0; i<arr.size(); i++) {
				//log.info("사이즈1초과");
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
}

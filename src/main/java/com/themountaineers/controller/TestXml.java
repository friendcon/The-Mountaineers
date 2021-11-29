//package com.themountaineers.controller;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//public class TestXml {
//
//    // tag값의 정보를 가져오는 메소드
//	private static String getTagValue(String tag, Element eElement) {
//	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
//	    Node nValue = (Node) nlList.item(0);
//	    if(nValue == null) 
//	        return null;
//	    return nValue.getNodeValue();
//	}
//
//	public static void main(String[] args) {
//		int page = 1;	// 페이지 초기값 
//		try{
//			while(true){
//				// parsing할 url 지정(API 키 포함해서)
//				String url = "http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI?serviceKey=B9teqawS%2BW6wyM%2Bfz1XRrGd4aRFEyNVe0eTEHjSYgd%2FCq4kVruxy3KkWhgf4WtaMdEG%2FqnKCXqb2B7M9o7DwXA%3D%3D&pageNo="+page;
//				
//				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
//				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
//				Document doc = dBuilder.parse(url);
//				
//				// root tag 
//				doc.getDocumentElement().normalize();
//				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//				
//				// 파싱할 tag
//				NodeList nList = doc.getElementsByTagName("item");
//				//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
//				
//				for(int temp = 0; temp < nList.getLength(); temp++){
//					Node nNode = nList.item(temp);
//					if(nNode.getNodeType() == Node.ELEMENT_NODE){
//						
//						Element eElement = (Element) nNode;
//						//System.out.println(eElement.getTextContent());
//						System.out.println("산이름  : " + getTagValue("mntiname", eElement));
//						
//					}	// for end
//				}	// if end
//				
//				page += 1;
//				System.out.println("page number : "+page);
//				if(page > 10){	
//					break;
//				}
//			}	// while end
//			
//		} catch (Exception e){	
//			e.printStackTrace();
//		}	// try~catch end
//	}	// main end
//}	// class end
//

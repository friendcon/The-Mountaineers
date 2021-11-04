package com.themountaineers.controller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.themountaineers.domain.MountainInfoImgVO;
import com.themountaineers.domain.MountainInfoVO;
import com.themountaineers.service.MountainInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class MainController {
	@RequestMapping( value = {"/"}, method = RequestMethod.GET)
	public String Main() {
		return "main";
	}
/*	private MountainInfoService service;
//�뀕�뀕
	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String Main(Model model) {
//�뀕�뀕�뀕
		if (service.count() == 0) {
			int page = 1; // �럹�씠吏� 珥덇린媛�
			try {
				while (true) {
					// log.info("�럹�씠吏� 踰덊샇 紐뉖쾲"+page);
					// parsing�븷 url 吏��젙(API �궎 �룷�븿�빐�꽌)
					String url = "http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoOpenAPI?serviceKey=B9teqawS%2BW6wyM%2Bfz1XRrGd4aRFEyNVe0eTEHjSYgd%2FCq4kVruxy3KkWhgf4WtaMdEG%2FqnKCXqb2B7M9o7DwXA%3D%3D&pageNo="
							+ page;

					DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
					Document doc = dBuilder.parse(url);

					// root tag
					doc.getDocumentElement().normalize();
					// System.out.println("Root element :" +
					// doc.getDocumentElement().getNodeName());

					// �뙆�떛�븷 tag
					NodeList nList = doc.getElementsByTagName("item");
					System.out.println("�뙆�떛�븷 由ъ뒪�듃 �닔 : " + nList.getLength());

					for (int temp = 0; temp < nList.getLength(); temp++) {
						Node nNode = nList.item(temp);

						Element eElement = (Element) nNode;

						log.info("�벑濡� �궛�씠由�  : " + getTagValue("mntiname", eElement));
						MountainInfoVO vo = new MountainInfoVO();
						vo.setMntilistno(Integer.parseInt(getTagValue("mntilistno", eElement)));
						vo.setMntiname(getTagValue("mntiname", eElement));
						vo.setMntidetails(getTagValue("mntidetails", eElement));
						vo.setMntiadminnum(getTagValue("mntiadminnum", eElement));
						vo.setMntiadd(getTagValue("mntiadd", eElement));
						vo.setMntihigh(getTagValue("mntihigh", eElement));

						service.insert(vo);
						
						String x=getTagValue("mntilistno", eElement);

						String url2 = "http://apis.data.go.kr/1400000/service/cultureInfoService/mntInfoImgOpenAPI?mntiListNo="
								+ x
								+ "&ServiceKey=B9teqawS%2BW6wyM%2Bfz1XRrGd4aRFEyNVe0eTEHjSYgd%2FCq4kVruxy3KkWhgf4WtaMdEG%2FqnKCXqb2B7M9o7DwXA%3D%3D";
						// log.info(url2);

						DocumentBuilderFactory dbFactoty2 = DocumentBuilderFactory.newInstance();
						DocumentBuilder dBuilder1 = dbFactoty2.newDocumentBuilder();
						Document doc2 = dBuilder1.parse(url2);

						// root tag
						doc2.getDocumentElement().normalize();
						// System.out.println("Root element :" +
						// doc.getDocumentElement().getNodeName());

						// �뙆�떛�븷 tag
						NodeList nListImg = doc2.getElementsByTagName("item");
						log.info("�뙆�떛�븷 �씠誘몄� �닔 : " + nListImg.getLength());

						if (nListImg.getLength() != 0) {
							for (int temp2 = 0; temp2 < nListImg.getLength(); temp2++) {
								Node nNode2 = nListImg.item(temp2);
								Element eElement2 = (Element) nNode2;
								
								MountainInfoImgVO voimg=new MountainInfoImgVO();
								voimg.setMntilistno(x);
								voimg.setMnti_i_name(getTagValue("imgfilename", eElement2));
								voimg.setMnti_i_route("https://www.forest.go.kr/images/data/down/mountain/"+getTagValue("imgfilename", eElement2));
								
								service.insertImg(voimg);

							}
						} else {
							log.info("�씠誘몄� �뾾�쓬");
						}

					} // for end
					// if end

					page++;
					log.info("page number : " + page);
					if (page > 470) {
						break;
					}
				} // while end

			} catch (Exception e) {
				e.printStackTrace();
			} // try~catch end

		}

		return "main";

	}

	// tag媛믪쓽 �젙蹂대�� 媛��졇�삤�뒗 硫붿냼�뱶
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}*/
}


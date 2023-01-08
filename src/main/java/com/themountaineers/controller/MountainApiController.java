package com.themountaineers.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.themountaineers.service.MountainApiService;
import jdk.internal.org.xml.sax.SAXException;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Controller
@AllArgsConstructor
@RequestMapping("/API/*")
public class MountainApiController {
	@Setter(onMethod_ = @Autowired)
	private MountainApiService service;

	//
	@GetMapping("/getAndsaveImage")
	public void getMountainImg() {
		service.getImg();
	}
	
	@GetMapping("/insertPath")
	public void mountainPathInsert() throws FileNotFoundException {
		service.mountainPathInsert();
	}
	
	@GetMapping("/readJSON")
	public void mountainJsonInsert() throws IOException {
		service.readMountainJSON();
	}
	
	@GetMapping("/mountainInsert")
	public void mountainDataInsert() throws IOException, ParserConfigurationException, SAXException, org.xml.sax.SAXException {
		service.mountainInsert();
	}
	
	@GetMapping("/updateXYaddress")
	public void getMountainDetailInfo() {
		try {
			service.getMountainDetailInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


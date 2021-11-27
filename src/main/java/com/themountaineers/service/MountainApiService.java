package com.themountaineers.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface MountainApiService {
	public void getMountainDetailInfo() throws UnsupportedEncodingException;
	public void getImg();
	public void mountainPathInsert() throws FileNotFoundException;
	public void readMountainJSON() throws IOException;
	public void mountainInsert() throws UnsupportedEncodingException, MalformedURLException, ParserConfigurationException, IOException, SAXException;
}

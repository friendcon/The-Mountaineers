package com.themountaineers.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.google.common.io.Files;

public class GetMountainXY {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain";
		String unzipPath = "C:\\Users\\imhyy\\OneDrive\\바탕 화면\\mountain\\mountain\\unzip";
		File directory = new File(path);
		String[] fileNames = directory.list();
		List<String> fileNameList = new ArrayList<String>();
		// json 압축 파일 이름만 선택
		for(String name : fileNames) {
			if(name.contains("geojson")) {
				fileNameList.add(name);
			}
		}
		
		File file  = new File(path, fileNameList.get(0));
		System.out.println(file.getPath());
		ZipInputStream zis = new ZipInputStream(new FileInputStream(file), Charset.forName("EUC-KR"));
		
		// zip에 있는 파일리스트
		ZipEntry entry = null;
		String fileN = null;
		String mountCode = "111100101";
		
		while((entry = zis.getNextEntry()) != null) {
			if(!entry.getName().contains("SPOT") && !entry.getName().contains("txt")) {
				System.out.println(entry.getName());
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
					throw e;
				} 
				fos.close();
			}
		}
		zis.close();
		// 압축풀기
		/*for(String jsonList : fileNameList) {
			File file  = new File(path, jsonList);
			System.out.println(file.getPath());
			ZipInputStream zis = new ZipInputStream(new FileInputStream(file), Charset.forName("EUC-KR"));
			
			// zip에 있는 파일리스트
			ZipEntry entry = zis.getNextEntry();
			System.out.println(entry.getName());
			while(entry != null) {
				System.out.println("ASDasd");
				String fName = entry.getName();
				System.out.println(fName);
				if(!fName.contains("SPOT") && !fName.contains("txt")) {
					System.out.println(fName);
				}
			}
		}*/
		
		System.out.println(fileNameList);
	}

}

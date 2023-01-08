package com.themountaineers.api;

import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import javax.net.ssl.HttpsURLConnection;
import javax.security.cert.CertificateException;
public class CheckTLS {
	public static void main(String[] args) throws IOException, CertificateEncodingException, CertificateException {
		if (args == null || args.length == 0) {
			System.err.println("url parameter not suppplied. ");
			System.exit(0);
		}
		
		URL url;
		/**
		 * 외부 API 를 통해 산의 정상좌표를 가지고 오기 위한 과정
		 * category_group_code AT4의 의미 => 관광명소
		 * 카카오 지도 검색 API 에서 category_group_code 를 AT4 로 설정한 후
		 */
		url = new URL("https://dapi.kakao.com/v2/local/search/keyword.json?query=북한산 산&category_group_code=AT4");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		System.out.println("Response Code : " + con.getResponseCode());
		System.out.println("Cipher Suite : " + con.getCipherSuite());
		System.out.println("\n");
		Certificate[] certs = con.getServerCertificates();
		for (Certificate cert : certs) {
			javax.security.cert.X509Certificate c = javax.security.cert.X509Certificate.getInstance(cert.getEncoded());
			System.out.println("\tCert Dn : " + c.getSubjectDN());
			System.out.println("\tIssuer Dn : " + c.getIssuerDN());
			System.out.println("\n");
		}
		
		con.disconnect();
	}
}
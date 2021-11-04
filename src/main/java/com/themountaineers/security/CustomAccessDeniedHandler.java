package com.themountaineers.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessException)
			throws IOException, ServletException {
		log.error("********** ���� ���� ���� **********");
		log.error("********** �α��� �������� �̵��մϴ� **********");
		response.sendRedirect("/member/login");
	}

}

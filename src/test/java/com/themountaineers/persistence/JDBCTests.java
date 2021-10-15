package com.themountaineers.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/themountaineers?useSSL=false&serverTimezone=UTC"
				, "root"
				, "1234"
				)){
			log.info("jdbc 연결 성공 !" );
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}

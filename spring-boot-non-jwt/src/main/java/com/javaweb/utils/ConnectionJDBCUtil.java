package com.javaweb.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class ConnectionJDBCUtil {

	static String DB_URL ;
	static final String USER = "root" ;
	static final String PASS =  "demo123";
	
	public static Connection getConnection() {
		Connection conn = null ;
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return conn;
	}
}

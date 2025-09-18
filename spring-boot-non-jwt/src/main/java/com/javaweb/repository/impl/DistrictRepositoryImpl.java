package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistricRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistricEntity;
import com.javaweb.utils.ConnectionJDBCUtil;

@Repository
public class DistrictRepositoryImpl implements DistricRepository{

	

	
	public DistricEntity findName(Integer id) {
		String sql = "SELECT d.name FROM district d WHERE d.id = " + id +";" ;
		 DistricEntity districEntity = new DistricEntity();
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				 districEntity.setName(rs.getString("name"));		  
			}
			
			System.out.println("connected database") ;
		} catch( SQLException e ) {
			e.printStackTrace();
			System.out.println("error connect");
		}
		return districEntity;
	}
	
}

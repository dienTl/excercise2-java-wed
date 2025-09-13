package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/duan1";
	static final String USER = "root" ;
	static final String PASS =  "demo123";
	
	@Override
	public List<BuildingEntity> findAll(String name , Integer districtid) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building where 1=1");
		if(name != null && !name.equals("")) {
			sql.append(" and building.name like '%"+name+"%' ");
		}
		if(districtid != null){
			sql.append(" AND building.districtid= "+ districtid+ " ");
		}
		
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER , PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());){
			while(rs.next()) {
				 BuildingEntity building = new BuildingEntity();
				    building.setName(rs.getString("name"));
				    building.setStreet(rs.getString("street"));
				    building.setWard(rs.getString("ward"));
				    building.setNumberOfBasement(rs.getInt("numberofbasement"));
				    building.setDistrictId(rs.getInt("districtid"));  // ✅ lấy từ DB, không lấy từ param
				    result.add(building);
			}
			
			System.out.println("connected database") ;
		} catch( SQLException e ) {
			e.printStackTrace();
			System.out.println("error connect");
		}
		// TODO Auto-generated method stub
		return result;
	}

}

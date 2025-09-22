package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {

	@Override
	public List<RentAreaEntity> getValueByBuildingId(Integer Id){
		String sql ="Select * FROM rentarea WHERE rentarea.buildingid = " + Id ;
		List<RentAreaEntity> rentAreas = new ArrayList<RentAreaEntity>();
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stmt =conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			    while(rs.next()){
			        RentAreaEntity areaEntity = new RentAreaEntity();
			        areaEntity.setId(rs.getInt("id"));             // id của rentarea
			        areaEntity.setValue(rs.getInt("value"));       // diện tích thuê
					areaEntity.setBuilding(Id);  ;                // id tòa nhà (FK)
			        rentAreas.add(areaEntity);
			    }
			} catch(Exception e) {
			    e.printStackTrace();
			}
			return rentAreas ;
		}
}

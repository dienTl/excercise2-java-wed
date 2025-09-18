package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	
	public static void jointable(Map<String,Object> params , List<String> typeCode, StringBuilder sql) {
		String staffId  = (String)params.get("staffid");
		if(StringUtil.checkString(staffId)) {
				sql.append("INNER JOIN assignmentbuilding on b.id = assignmentbuilding.buildingid ");
			}
		if(typeCode != null && !typeCode.isEmpty() ) {
			sql.append("inner join buildingrenttype on b.id = buildingrenttype.buildingid ");
			sql.append("inner join renttype on renttype.id = buildingrenttype.renttypeid ");
		}
		
	}
	public static void queryNomal(Map<String,Object> params ,StringBuilder where) {
		for(Map.Entry<String, Object> it : params.entrySet()) {
			if(!it.getKey().equals("staffid") &&  !it.getKey().equals("typeCode") && !it.getKey().startsWith("area") && !it.getKey().startsWith("rentPrice")){
				String value = it.getValue().toString();
				if(!StringUtil.checkString(value)) {
					if(NumberUtil.isNumber(value)== true) {
						where.append(" AND b."+ it.getKey()+ "=" + value);
					}
					else {
						where.append(" AND b."+ it.getKey()+ " LIKE '%"+ value+ "%' ");
					}
				}
			}
		}
	}
	
	public static void querySpecial(Map<String,Object> params, List<String> typeCode ,StringBuilder where ) {
		String staffId = (String)params.get("staffid");
		if(StringUtil.checkString(staffId)) {
			where.append(" AND assignmentbuilding.staffid = " + staffId );
		}
		String rentAreaTo = (String)params.get("areaTo");
		String rentAreaFrom = (String)params.get("areaFrom");
		if(StringUtil.checkString(rentAreaFrom) == true || StringUtil.checkString(rentAreaTo)== true) {
			where.append(" AND EXISTS (SELECT * FROM rentarea r where b.id = r.buildingid ");
			if(StringUtil.checkString(rentAreaFrom)) {
				where.append(" AND r.value >=" + rentAreaFrom);
			}
			if(StringUtil.checkString(rentAreaTo)) {
				where.append(" AND r.value <=" + rentAreaTo);
			}
			where.append(") ");
		}
		
		
		String rentPriceTo = (String)params.get("rentPriceTo");
		String rentPriceFrom = (String)params.get("rentPriceFrom");
		if(StringUtil.checkString(rentPriceTo) == true || StringUtil.checkString(rentAreaTo)== true) {
			if(StringUtil.checkString(rentPriceTo)) {
				where.append(" AND b.rentprice >=" + rentPriceFrom);
			}
			if(StringUtil.checkString(rentPriceFrom)) {
				where.append(" AND b.rentprice <=" + rentPriceTo);
			}
		}
//		java7
//		if(typeCode != null && typeCode.size() != 0) {
//			List<String> code = new ArrayList<>();
//			for(String item : typeCode) {
//				code.add("'" + item + "'");
//			}
//			where.append(" AND renttype.code IN(" + String.join(",", code ) +")");
//		}
		//java8
		if(typeCode != null && typeCode.size() != 0) {
			where.append(" AND(");
			String sql = typeCode.stream().map(it-> "renttype.code LIKE" + "'%"+ it +"%'").collect(Collectors.joining("OR "));
			where.append(sql);
			where.append(" ) ");
		}
	}
	
	@Override
	public List<BuildingEntity> findAll(Map<String , Object> params,List<String> typeCode) {
		StringBuilder sql = new StringBuilder("SELECT b.id , b.name , b.districtid , b.street , b.direction , b.ward , b.emptyarea , b.floorarea , b.numberofbasement , b.floorarea ,b.rentprice ," 
				+ " b.managername , b.managerphonenumber , b.servicefee , b.brokeragefee , b.createddate FROM building b ");
		jointable(params, typeCode, sql);
		StringBuilder where = new StringBuilder(" where 1=1 ");
		queryNomal(params, where);
		querySpecial(params, typeCode, where);
		where.append(" GROUP BY b.id;");
		sql.append(where);
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());){
			while(rs.next()) {
				 BuildingEntity building = new BuildingEntity();
				    building.setName(rs.getString("name"));
				    building.setStreet(rs.getString("street"));
				    building.setWard(rs.getNString("ward"));
				    building.setDirection(rs.getString("direction"));
				    building.setNumberOfBasement(rs.getInt("numberOfBasement"));
				    building.setDirection(rs.getString("direction"));
				    building.setEmptyArea(rs.getString("emptyarea"));
				    building.setFloorArea(rs.getInt("floorarea"));
				    building.setRentprice(rs.getInt("rentprice"));
				    building.setDistrictId(rs.getInt("districtid"));
				    building.setServicefee(rs.getInt("servicefee"));
				    building.setBrokeragefee(rs.getDouble("brokeragefee"));
				    building.setManageName(rs.getNString("managername"));
				    building.setManagePhoneNumber(rs.getNString("managerphonenumber"));
				    building.setId(rs.getInt("id"));
				    result.add(building);
			}
			
			System.out.println("connected databaseeee") ;
		} catch( SQLException e ) {
			e.printStackTrace();
			System.out.println("error connectttt");
		}
		// TODO Auto-generated method stub
		return result;
	}

}

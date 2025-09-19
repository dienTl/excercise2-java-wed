package com.javaweb.repository.impl;

import java.lang.reflect.Field;
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

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	
	public static void jointable(BuildingSearchBuilder buildingSearchBuilder , StringBuilder sql) {
		Integer staffId  = buildingSearchBuilder.getStaffId();
		if(staffId != null) {
				sql.append(" INNER JOIN assignmentbuilding on b.id = assignmentbuilding.buildingid ");
			}
		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if(typeCode != null && !typeCode.isEmpty() ) {
			sql.append(" inner join buildingrenttype on b.id = buildingrenttype.buildingid ");
			sql.append(" inner join renttype on renttype.id = buildingrenttype.renttypeid ");
		}
		
	}
	public static void queryNomal(BuildingSearchBuilder buildingSearchBuilder,StringBuilder where) {
//		for(Map.Entry<String, Object> it : params.entrySet()) {
//			if(!it.getKey().equals("staffid") &&  !it.getKey().equals("typeCode") && !it.getKey().startsWith("area") && !it.getKey().startsWith("rentPrice")){
//				String value = it.getValue().toString();
//				if(!StringUtil.checkString(value)) {
//					if(NumberUtil.isNumber(value)== true) {
//						where.append(" AND b."+ it.getKey()+ "=" + value);
//					}
//					else {
//						where.append(" AND b."+ it.getKey()+ " LIKE '%"+ value+ "%' ");
//					}
//				}
//			}
//		}
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item : fields) {
				item.setAccessible(true);// cho phép truy cập vào các full của đối tượng
				String fieldName = item.getName();
				if(!fieldName.equals("staffId") &&  !fieldName.equals("typeCode") && !fieldName.startsWith("Area") && !fieldName.startsWith("rentPrice")){
					Object value = item.get(buildingSearchBuilder);
					if(value != null) {
						if(item.getType().getName().equals("java.lang.Long")||item.getType().getName().equals("java.lang.Integer")){
							where.append(" AND b."+ fieldName+ "=" + value);
						}
						else if(item.getType().getName().equals("java.lang.String")){
							where.append(" AND b."+ fieldName+ " LIKE '%"+ value+ "%' ");
						}
				}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder , StringBuilder where) {
	    Integer staffId = buildingSearchBuilder.getStaffId();
	    if (staffId != null) {
	        where.append(" AND assignmentbuilding.staffid = " + staffId);
	    }

	    Integer areaFrom = buildingSearchBuilder.getAreaFrom();
	    Integer areaTo = buildingSearchBuilder.getAreaTo();
	    if (areaFrom != null || areaTo != null) {
	        where.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid");
	        if (areaFrom != null) {
	            where.append(" AND r.value >= " + areaFrom);
	        }
	        if (areaTo != null) {
	            where.append(" AND r.value <= " + areaTo);
	        }
	        where.append(")");
	    }

	    Integer rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
	    Integer rentPriceTo   = buildingSearchBuilder.getRentPriceTo();
	    if (rentPriceFrom != null || rentPriceTo != null) {
	        if (rentPriceFrom != null) {
	            where.append(" AND b.rentprice >= " + rentPriceFrom);
	        }
	        if (rentPriceTo != null) {
	            where.append(" AND b.rentprice <= " + rentPriceTo);
	        }
	    }

	    List<String> typeCode = buildingSearchBuilder.getTypeCode();
	  //java8
	    if (typeCode != null && !typeCode.isEmpty()) {
	        where.append(" AND (");
	        String sql = typeCode.stream()
	                .map(it -> "renttype.code LIKE '%" + it + "%'")
	                .collect(Collectors.joining(" OR "));
	        where.append(sql);
	        where.append(")");
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
		
		
	
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT b.id , b.name , b.districtid , b.street , b.direction , b.ward , b.emptyarea , b.numberofbasement , b.floorarea ,b.rentprice ," 
				+ " b.managername , b.managerphonenumber , b.servicefee , b.brokeragefee , b.createddate FROM building b ");
		jointable(buildingSearchBuilder, sql);
		StringBuilder where = new StringBuilder(" where 1=1 ");
		queryNomal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder, where);
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
	@Override
	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}

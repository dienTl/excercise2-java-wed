package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.Builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
    public static BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
        
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
        		  .setName(MapUtil.getObject(params, "name", String.class))
        	        .setFloorArea(MapUtil.getObject(params, "FloorArea", Integer.class))
        	        .setWard(MapUtil.getObject(params, "ward", String.class))
        	        .setAreaFrom(MapUtil.getObject(params, "areaFrom", Integer.class)) // sửa
        	        .setAreaTo(MapUtil.getObject(params, "areaTo", Integer.class))     // sửa
        	        .setBrokerageFee(MapUtil.getObject(params, "brokenFee", Integer.class))  // sửa
        	        .setDirection(MapUtil.getObject(params, "direction", String.class))// sửa
        	        .setDistrictCode(MapUtil.getObject(params, "districtCode", String.class)) // sửa
        	        .setManagerName(MapUtil.getObject(params, "managerName", String.class))   // sửa
        	        .setManagerPhone(MapUtil.getObject(params, "managerPhone", String.class)) // sửa
        	        .setNumberOfBasement(MapUtil.getObject(params, "numberOfBasement", Integer.class)) // sửa
        	        .setServiceFee(MapUtil.getObject(params, "serviceFee", Integer.class))       // sửa
        	        .setTypeCode(typeCode)
        	        .setStaffId(MapUtil.getObject(params, "staffId", Integer.class)) // sửa
                .build();
        
        return buildingSearchBuilder;
    }
}

package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DistricRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistricEntity;
import com.javaweb.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private DistricRepository districRepository;
	@Override
	public List<BuildingDTO> findAll(Map<String , Object> params,List<String> typeCode) {
		// TODO Auto-generated method stub
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typeCode);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setDirection(item.getDirection());
			building.setNumberOfBasement(item.getNumberOfBasement());
			building.setManagerName(item.getManageName());
			building.setManagerPhone(item.getManagePhoneNumber());
			building.setFloorArea(item.getFloorArea());
			building.setEmptyArea(item.getEmptyArea());
			building.setRentPrice(item.getRentprice());
			building.setServiceFee(item.getServicefee());
			building.setBrokerageFee(item.getBrokeragefee());
			DistricEntity districEntity = districRepository.findName(item.getDistrictId());  
			building.setAddress(item.getStreet()+"," +item.getWard() + ","+ districEntity.getName());
			result.add(building);
		}
		return result;
	}
	
}

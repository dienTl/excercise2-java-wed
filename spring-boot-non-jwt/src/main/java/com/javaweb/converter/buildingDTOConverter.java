package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.DistricRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistricEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class buildingDTOConverter {
	@Autowired
	private DistricRepository districRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private ModelMapper modelMapper;
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		DistricEntity districEntity = districRepository.findName(item.getDistrictId());  
		building.setAddress(item.getStreet()+"," +item.getWard() + ","+ districEntity.getName());
		List<RentAreaEntity> rentAreas = rentAreaRepository.getValueByBuildingId(item.getId());
		String areaResult = rentAreas.stream().map(it  -> it.getValue().toString()).collect(Collectors.joining(","));
//		building.setName(item.getName());
//		building.setDirection(item.getDirection());
//		building.setNumberOfBasement(item.getNumberOfBasement());
		building.setManagerName(item.getManageName());
		building.setManagerPhone(item.getManagePhoneNumber());
//		building.setFloorArea(item.getFloorArea());
//		building.setRentPrice(item.getRentprice());
//		building.setEmptyArea(item.getEmptyArea());
//		building.setServiceFee(item.getServicefee());
//		building.setBrokerageFee(item.getBrokeragefee()); có modelmapper nên bỏ
		building.setRentArea(areaResult);
		
		return building; 
		
	}
}

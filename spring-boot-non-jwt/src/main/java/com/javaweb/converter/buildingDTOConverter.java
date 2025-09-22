package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class buildingDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO toBuildingDTO(BuildingEntity item) {
        BuildingDTO building = modelMapper.map(item, BuildingDTO.class);

        // set address
        building.setAddress(item.getStreet() + "," + item.getWard() + "," + item.getDistrict().getName());

        // set rent area
        List<RentAreaEntity> rentAreas = item.getItems();
        String areaResult = rentAreas.stream()
                                     .map(it -> it.getValue().toString())
                                     .collect(Collectors.joining(","));
        building.setRentarea(areaResult);;

        // set manager info
        building.setManagername(item.getManagername());;
        building.setManagerphonenumber(item.getManagephonenumber());

        return building;
    }
}

package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.errorResponseDTO;
import com.javaweb.service.BuildingService;
@RestController // rest controller có bao gồm cả responseBody
public class BuildingApi {
	@Autowired
	private BuildingService buildingService;
    @GetMapping(value = "/api/building/")  
    public List<BuildingDTO> GETbuilding1(@RequestParam Map<String , Object> params,
    									  @RequestParam(value="typeCode" , required = false) List<String> typeCode){
    									
    	List<BuildingDTO> result = buildingService.findAll(params,typeCode);
    	return result ;
    }
    public void validate(BuildingDTO buildingDTO) throws customException.FieldRequireException {
        if (buildingDTO.getName() == null || buildingDTO.getName().trim().isEmpty()) {
            throw new customException.FieldRequireException("name or numberofbasement");
        }
    
        
    }
    
    
//    @PostMapping(value="/api/building/")
//    public BuildingDTO GETbuilding2(@RequestBody BuildingDTO buildingDTO) {
//    	// xử lí database sau 
//    	
//    	return buildingDTO ;
//    }
    
    @DeleteMapping(value="/api/building/{id}/{name}")
    public void deleteBuilding(@PathVariable Integer id,
    						   @PathVariable String name,
    						   @RequestParam(value="ward" ,required = false ) String ward) {
    	System.out.print("sdhk"+ id );
    }
    
}

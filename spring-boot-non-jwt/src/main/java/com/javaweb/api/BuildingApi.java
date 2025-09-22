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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
import com.javaweb.model.RequestBuilding;
import com.javaweb.model.errorResponseDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
@RestController // rest controller có bao gồm cả responseBody
@PropertySource("classpath:application.properties")
public class BuildingApi {
	@Autowired
	private BuildingService buildingService;
	
	@Value("${dev}")
	private String data ;
	
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
    
	@PersistenceContext
	private EntityManager entityManager;
//    @PostMapping(value="/api/building/")
//    @Transactional
//    public void CreateBuilding(@RequestBody RequestBuilding requestBuilding ) {
//    	BuildingEntity buildingEntity = new BuildingEntity() ;
//    	buildingEntity.setName(requestBuilding.getName());
//    	entityManager.persist(buildingEntity);
//    }
    
    
//    @PostMapping(value="/api/building/")
//    public BuildingDTO GETbuilding2(@RequestBody BuildingDTO buildingDTO) {
//    	// xử lí database sau 
//    	
//    	return buildingDTO ;
//    }
    
    @DeleteMapping(value="/api/building/{id}/")
    public void deleteBuilding(@PathVariable Integer id) {
    	System.out.print(data);
    }
    
}

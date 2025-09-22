//package com.javaweb.repository.impl;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//
//import com.javaweb.Builder.BuildingSearchBuilder;
//import com.javaweb.repository.BuildingRepository;
//import com.javaweb.repository.entity.BuildingEntity;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;
//
//
//@Repository
//public class BuildingRepositoryImpl implements BuildingRepository{
//
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	@Override
//	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
//		// TODO Auto-generated method stub
//		//JPQL JPA query language
////		String sql = "FROM BuildingEntity b WHERE b.id = 1";
////		Query query = entityManager.createQuery(sql,BuildingEntity.class);
////		return query.getResultList();
//		//sql native
//		String sql = "SELECT * from building b where b.name like '%Tòa nhà A%'" ;
//		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);
//		
//		return query.getResultList();
//		
//		
//	}
//
//	@Override
//	public void DeleteById(Long id) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

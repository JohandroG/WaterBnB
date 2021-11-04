package com.proyect.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyect.model.Association;
import com.proyect.model.Pool;

public interface AssociationsRepository extends CrudRepository <Association,Long> {

//-----------------------------------------JAVA----------------------------------
	
	List<Association> findAll();
	
//----------------------------------------QUERY----------------------------------
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO associations (pool_id,user_id) " +
	"VALUES(?1, ?2)", nativeQuery=true)
	Integer insertNewPoolLink( Long pool_id,Long user_id);
	
	
}

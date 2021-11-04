package com.proyect.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyect.model.Pool;
import com.proyect.model.User;



public interface PoolsRepository extends CrudRepository <Pool,Long> {

	//-----------------------------------------JAVA----------------------------------
	
		List<Pool> findAll();
		
	//----------------------------------------QUERY----------------------------------
	
		@Query( "SELECT u FROM Pool u WHERE id = ?1" )
		User findPbyId( Long pool_id );
		
		@Query( value = "SELECT * FROM pools WHERE address LIKE %?1%", nativeQuery=true )
		List<Pool> findPbyWord( String word);


		@Modifying
		@Transactional
		@Query(value = "INSERT INTO pools(address,description,cost,size) " +
		"VALUES(?1, ?2, ?3, ?4)", nativeQuery=true)
		void insertNewPool( String address,String description,String cost, String size);
		
	
}

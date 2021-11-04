package com.proyect.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyect.model.User;

public interface UsersRepository extends CrudRepository <User,Long> {

//-----------------------------------------JAVA----------------------------------
	
	List<User> findAll();
	
//----------------------------------------QUERY----------------------------------
	
	@Query( "SELECT u FROM User u WHERE id = ?1" )
	User findbyId( Long user_id );
	
	@Query( "SELECT u FROM User u WHERE email = ?1" )
	List<User> AllUsersByEmail( String email );
	
	@Query( "SELECT u FROM User u WHERE email = ?1" )
	User UserByEmail( String email );
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO users(firstname,lastname,email,password,admin) " +
	"VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery=true)
	void insertNewUser( String firstname,String lastname,String email, String encryptedpassword,String admin);
	

}

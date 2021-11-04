package com.proyect.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.proyect.model.Pool;
import com.proyect.model.User;
import com.proyect.repositories.AssociationsRepository;
import com.proyect.repositories.PoolsRepository;
import com.proyect.repositories.UsersRepository;

@Service
public class AppService {

	public final UsersRepository ur;
	public final PoolsRepository pr;
	public final AssociationsRepository ar;
	
	public  AppService(UsersRepository ur, PoolsRepository pr, AssociationsRepository ar) {
        this.ur = ur;
        this.pr = pr;
        this.ar =ar;
    }


//-----------------------------------------------------------------------------------

//-------------------------------------------User----------------------------------------

public List<User> allUsers(){
	return ur.findAll();
}

public User findUsingID(Long user_id) {
	return ur.findbyId(user_id);
}

public List<User> getlistofUsersByEmail( String email ){
	return ur.AllUsersByEmail(email);
}

public User getUserByEmail( String email ){
	return ur.UserByEmail(email);
}


public void  registerUser( String firstname,String lastname,String email, String password,String admin ) {
	String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
	ur.insertNewUser(firstname,lastname,email, encryptedPassword,admin);
}

public Boolean validateUser (User currentUser, String password){
	return BCrypt.checkpw( password, currentUser.getPassword() );
}

//-------------------------------------------Pool---------------------------------------

public List<Pool> allPools(){
	return pr.findAll();
}

public Pool getcurrentPool(List<Pool> last) {
	return last.get(last.size()-1);
}

public User findPoolUsingID(Long pool_id) {
	return pr.findPbyId(pool_id);
}

public void createnewpool(String address,String description,String cost, String size) {
	pr.insertNewPool(address, description, cost, size);
}

public List<Pool> searchpool(String word){
	return pr.findPbyWord(word);
}


//-------------------------------------------Review-------------------------------------



//-------------------------------------------Associations-------------------------------------

public void linkpooltoUser( Long pool_id,Long user_id) {
	ar.insertNewPoolLink(pool_id, user_id);
}





}
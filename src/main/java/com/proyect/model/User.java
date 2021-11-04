package com.proyect.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@NotNull
	private Long user_id;
	
	@NotNull
	@Size( min = 2, max = 70)
	private String firstname;
	
	@NotNull
	@Size( min = 2, max = 70)
	private String lastname;
	
	@NotNull
	@Size( min = 2, max = 70)
	private String email;
	
	@NotNull
	@Size( min = 2, max = 500)
	private String password;
	
	@NotNull
	@Size( min = 2, max = 20)
	private String admin;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "pool_id")
	        )
	private List<Pool> pools;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "review_id")
	        )
	private List<Review> reviews;
	
	public User() {}
	
	public User(Long user_id, String firstname,String lastname,String email,String admin, List<Pool> pools,List<Review> reviews,String password) {
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.admin = admin;
		this.pools = pools;
		this.reviews = reviews;
		this.password = password;
	}
	
	public User(String firstname,String lastname,String email,String admin,String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.admin = admin;
		this.password = password;
	}

//---------------------------------------Getters y Setters------------------------
	
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public List<Pool> getPools() {
		return pools;
	}

	public void setPools(List<Pool> pools) {
		this.pools = pools;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
	
	

}

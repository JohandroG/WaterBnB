package com.proyect.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pools")
public class Pool {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@NotNull
	private Long pool_id;
	
	@NotNull
	@Size( min = 2, max = 200)
	private String address;
	
	@NotNull
	@Size( min = 2, max = 500)
	private String description;
	
	@NotNull
	private BigDecimal cost;
	
	@NotNull
	@Size( min = 2, max = 200)
	private String size;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "pool_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	        )
	private List<User> users;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "pool_id"), 
	        inverseJoinColumns = @JoinColumn(name = "review_id")
	        )
	private List<Review> reviews;

	public Pool() {};
	
	public Pool(Long pool_id, String address,
			String description, BigDecimal cost,
			String size, List<User> users, List<Review> reviews) {
		
		this.pool_id = pool_id;
		this.address = address;
		this.description = description;
		this.cost = cost;
		this.size = size;
		this.users = users;
		this.reviews = reviews;
	}
	
	//Use this one
	public Pool( String address,
			String description, BigDecimal cost,
			String size, List<User> users) {
		
		this.address = address;
		this.description = description;
		this.cost = cost;
		this.size = size;
		this.users = users;
	}
//-------------------------------Getters y Setters------------------------------
	
	public Long getPool_id() {
		return pool_id;
	}

	public void setPool_id(Long pool_id) {
		this.pool_id = pool_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
	
	
}

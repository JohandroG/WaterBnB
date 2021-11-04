package com.proyect.model;

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
@Table(name = "reviews")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@NotNull
	private Long review_id;
	
	@NotNull
	@Size( min = 2, max = 200)
	private String review;
	
	@NotNull
	private Long rating;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "review_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	        )
	private List<User> users;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "associations", 
	        joinColumns = @JoinColumn(name = "review_id"), 
	        inverseJoinColumns = @JoinColumn(name = "pool_id")
	        )
	private List<Pool> pools;

	public Review() {}
	
	public Review(Long review_id, String review, Long rating,
			List<User> users, List<Pool> pools) {
		this.review_id = review_id;
		this.review = review;
		this.rating = rating;
		this.users = users;
		this.pools = pools;
	}
	
	public Review( String review, Long rating,
			List<User> users, List<Pool> pools) {
		this.review = review;
		this.rating = rating;
		this.users = users;
		this.pools = pools;
	}

	
	
}

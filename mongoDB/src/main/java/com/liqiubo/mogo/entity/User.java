package com.liqiubo.mogo.entity;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	
	public String toString(){
		return "id:"+id+", username:"+username+", country:"+country+", address:[aCode="+address.getaCode()+",add="+address.getAdd()+"], favorites:[movies="+favorites.getMovies()+",cities="+favorites.getCites()+"], age:"+age+", salary:"+salary+", length:"+length;
	}
	
	@Id
	private ObjectId id;
		
	private String username;
	
	private String country;
	
	private Address address;
	
	private Favorites favorites;
	
	private int age;
	
	private BigDecimal salary;
	
	private float length;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Favorites getFavorites() {
		return favorites;
	}
	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
}

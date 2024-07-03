package com.use;

import java.io.InputStream;

public class Player {
	String name, gender, district, position, email ;
	int age;
	InputStream photo;
	public Player(String name,  int age, String gender, String district, String position, String email, InputStream photo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.district = district;
		this.position = position;
		this.email = email;
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getDistrict() {
		return district;
	}
	public String getPosition() {
		return position;
	}
	public String getEmail() {
		return email;
	}
	public InputStream getPhoto() {
		return photo;
	}

	
	

}

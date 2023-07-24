package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int admin_id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String password;
	private String name;
	private int age;
	private int exp;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String name, int age, int exp) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.exp = exp;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", age=" + age + ", exp=" + exp + "]";
	}

		

}

package com.masai.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String name;
	private String est;
	
	@OneToMany(mappedBy = "company" , fetch = FetchType.EAGER)
	private Set<Flight> flight= new HashSet<>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Company( String name, String est, Set<Flight> flight) {
		super();
		this.name = name;
		this.est = est;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public Set<Flight> getFlight() {
		return flight;
	}

	public void setFlight(Set<Flight> flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", est=" + est + "]";
	}
	

	
}

package com.masai.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private int CustomerId;
	@Column(name= "Name",nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false, unique = true)
	private String password;
	@Column(nullable = false)
	private double walletAmount;
	private int is_dealeted;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="Customer_Flight")
	private Flight flight;
//	List<Booking>booking= new ArrayList<>();
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String username, String password, double walletAmount, int is_dealeted) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.walletAmount = walletAmount;
		this.is_dealeted = is_dealeted;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}

	public int getIs_dealeted() {
		return is_dealeted;
	}

	public void setIs_dealeted(int is_dealeted) {
		this.is_dealeted = is_dealeted;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", walletAmount=" + walletAmount + ", is_dealeted=" + is_dealeted + ", flight=" + flight
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CustomerId, flight, is_dealeted, name, password, username, walletAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return CustomerId == other.CustomerId && Objects.equals(flight, other.flight)
				&& is_dealeted == other.is_dealeted && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username)
				&& Double.doubleToLongBits(walletAmount) == Double.doubleToLongBits(other.walletAmount);
	}

	
}

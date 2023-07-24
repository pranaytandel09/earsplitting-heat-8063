package com.masai.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Travigo_Flights")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Flight_Id")
	private int id;
	@Column(nullable = false, unique = true)
	private String flightNo;
	
	@ManyToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="Company_flights")
	private Company company;
	
	@OneToMany(mappedBy = "flight",fetch = FetchType.EAGER)
	private Set<Customer> customerSet= new HashSet<>();
	
	@Column(name="Departure_Date_Time")
	private LocalDateTime departureDateTime;
	@Column(name="Arriving_Date_Time")
	private LocalDateTime arrivingDateTime;
	@Column(name="Departure_City")
	private String departureCity;
	@Column(name="Arrival_City")
	private String arrivalCity;
	
	private double buisinessClassPrice;
	private double economyClassPrice;

	private int buisinessClassSeats;
	private int economyClassSeats;
	
	private int isDeleted;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(String flightNo,LocalDateTime departureDateTime, LocalDateTime arrivingDateTime,
			String departureCity, String arrivalCity, double buisinessClassPrice, double economyClassPrice,
			int buisinessClassSeats, int economyClassSeats, int isDeleted) {
		super();
		this.flightNo = flightNo;
		
		this.departureDateTime = departureDateTime;
		this.arrivingDateTime = arrivingDateTime;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.buisinessClassPrice = buisinessClassPrice;
		this.economyClassPrice = economyClassPrice;
		this.buisinessClassSeats = buisinessClassSeats;
		this.economyClassSeats = economyClassSeats;
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArrivingDateTime() {
		return arrivingDateTime;
	}

	public void setArrivingDateTime(LocalDateTime arrivingDateTime) {
		this.arrivingDateTime = arrivingDateTime;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public double getBuisinessClassPrice() {
		return buisinessClassPrice;
	}

	public void setBuisinessClassPrice(double buisinessClassPrice) {
		this.buisinessClassPrice = buisinessClassPrice;
	}

	public double getEconomyClassPrice() {
		return economyClassPrice;
	}

	public void setEconomyClassPrice(double economyClassPrice) {
		this.economyClassPrice = economyClassPrice;
	}

	public int getBuisinessClassSeats() {
		return buisinessClassSeats;
	}

	public void setBuisinessClassSeats(int buisinessClassSeats) {
		this.buisinessClassSeats = buisinessClassSeats;
	}

	public int getEconomyClassSeats() {
		return economyClassSeats;
	}

	public void setEconomyClassSeats(int economyClassSeats) {
		this.economyClassSeats = economyClassSeats;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNo=" + flightNo + ", company=" + company + ", departureDateTime="
				+ departureDateTime + ", arrivingDateTime=" + arrivingDateTime + ", departureCity=" + departureCity
				+ ", arrivalCity=" + arrivalCity + ", buisinessClassPrice=" + buisinessClassPrice
				+ ", economyClassPrice=" + economyClassPrice + ", buisinessClassSeats=" + buisinessClassSeats
				+ ", economyClassSeats=" + economyClassSeats + ", isDeleted=" + isDeleted + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalCity, arrivingDateTime, buisinessClassPrice, buisinessClassSeats, company,
				departureCity, departureDateTime, economyClassPrice, economyClassSeats, flightNo, id, isDeleted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(arrivalCity, other.arrivalCity)
				&& Objects.equals(arrivingDateTime, other.arrivingDateTime)
				&& buisinessClassPrice == other.buisinessClassPrice && buisinessClassSeats == other.buisinessClassSeats
				&& Objects.equals(company, other.company) && Objects.equals(departureCity, other.departureCity)
				&& Objects.equals(departureDateTime, other.departureDateTime)
				&& economyClassPrice == other.economyClassPrice && economyClassSeats == other.economyClassSeats
				&& Objects.equals(flightNo, other.flightNo) && id == other.id && isDeleted == other.isDeleted;
	}

}

package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;

import com.masai.entity.Customer;
import com.masai.entity.Flight;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.SomethingWentWrongException;

public interface CustomerService {

	void CustomerRegistration(Customer customer) throws SomethingWentWrongException,AccountAlreadyExist;

	void CustomerLogin(String username, String password) throws SomethingWentWrongException;

	List<Flight> searchFligts(String departureCity, String destinationCity, LocalDateTime departureDateTime) throws SomethingWentWrongException;

	List<Flight> viewFlightInfo() throws SomethingWentWrongException;

	List<Flight> filterByPrice(int sp, int ep, String flightClass) throws SomethingWentWrongException;


}

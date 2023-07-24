package com.masai.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.masai.entity.Customer;
import com.masai.entity.Flight;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.SomethingWentWrongException;

import cm.masai.dao.CustomerDAO;
import cm.masai.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void CustomerRegistration(Customer customer) throws SomethingWentWrongException,AccountAlreadyExist {
		// TODO Auto-generated method stub
		CustomerDAO cdo= new CustomerDAOImpl();
		cdo.CustomerRegistration(customer);
	}

	@Override
	public void CustomerLogin(String username, String password) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDAO cdo= new CustomerDAOImpl();
		cdo.CustomerLogin(username, password);
	}

	@Override
	public List<Flight> searchFligts(String departureCity, String destinationCity, LocalDateTime departureDateTime) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDAO cdo= new CustomerDAOImpl();
		return cdo.searchFligts(departureCity, destinationCity,departureDateTime);
		
	}

	@Override
	public List<Flight> viewFlightInfo() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDAO cdo= new CustomerDAOImpl();
		return cdo.viewFlightInfo();
	}

	@Override
	public List<Flight> filterByPrice(int sp, int ep, String flightClass) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDAO cdo= new CustomerDAOImpl();
		List<Flight> flightlist=  cdo.viewFlightInfo();
		
	if(flightClass.equalsIgnoreCase("buissinessClass")) {
		return flightlist.stream().filter(s-> s.getBuisinessClassPrice()>=sp && s.getBuisinessClassPrice()<=ep).toList();
	}
	else {
		return flightlist.stream().filter(s-> s.getEconomyClassPrice()>=sp && s.getEconomyClassPrice()<=ep).toList();
	}
		
		
	}

	

}

package com.masai.service;

import java.util.Scanner;

import com.masai.entity.Admin;
import com.masai.entity.Flight;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.FlightDoesNotExist;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.dbUtils;

import cm.masai.dao.AdminDao;
import cm.masai.dao.AdminDaoImpl;
import jakarta.persistence.EntityManager;

public class AdminServiceImpl implements AdminService {
	@Override
	public void adminLogin(String username, String password) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		AdminDao ad= new AdminDaoImpl();
		ad.adminLogin(username,password);
	}

	@Override
	public void AdminRegistration(Admin admin) throws AccountAlreadyExist, SomethingWentWrongException {
		// TODO Auto-generated method stub
	AdminDao ad= new AdminDaoImpl();
	ad.AdminRegistration(admin);
	}

	@Override
	public void addNewFligts(Flight flight, int cId) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		AdminDao ad= new AdminDaoImpl();
		ad.addNewFligts(flight, cId);
	}

	@Override
	public void updateFlight(int id, Scanner sc) throws FlightDoesNotExist, SomethingWentWrongException {
		// TODO Auto-generated method stub
		AdminDao ad= new AdminDaoImpl();
		ad.updateFlight(id, sc);
	}

	@Override
	public void removeFlight(int id, Scanner sc) throws FlightDoesNotExist, SomethingWentWrongException {
		// TODO Auto-generated method stub
		AdminDao ad= new AdminDaoImpl();
		ad.removeFlight(id, sc);
	}

}

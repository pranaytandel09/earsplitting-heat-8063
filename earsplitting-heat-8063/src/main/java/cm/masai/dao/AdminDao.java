package cm.masai.dao;

import java.util.Scanner;

import com.masai.entity.Admin;
import com.masai.entity.Flight;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.FlightDoesNotExist;
import com.masai.exception.SomethingWentWrongException;

public interface AdminDao {

	void AdminRegistration(Admin admin) throws AccountAlreadyExist, SomethingWentWrongException;

	void adminLogin(String username, String password) throws SomethingWentWrongException;

	void addNewFligts(Flight flight, int cId) throws SomethingWentWrongException;

	void updateFlight(int id, Scanner sc) throws FlightDoesNotExist, SomethingWentWrongException;

	void removeFlight(int id, Scanner sc) throws FlightDoesNotExist, SomethingWentWrongException;

}

package cm.masai.ui;

import java.nio.file.spi.FileSystemProvider;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.masai.entity.Admin;
import com.masai.entity.Flight;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.FlightDoesNotExist;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.AdminService;
import com.masai.service.AdminServiceImpl;

public class AdminUI {
	


	public static void addNewFligts(Scanner sc) {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.println("Enter flight No");
		String flighNo= sc.nextLine();
		System.out.println("Enter company id");
		int cId= sc.nextInt();
	
		sc.nextLine();
		System.out.println("Enter departure date and time (yyyy-mm-dd HH:mm:ss");
		String dDT= sc.nextLine();
		LocalDateTime departureDateTime= LocalDateTime.parse(dDT, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("Enter arrival date and time (yyyy-mm-dd HH:mm:ss");
		String aDT= sc.nextLine();
		LocalDateTime arrivalDateTime= LocalDateTime.parse(dDT, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		System.out.println("Enter departure city");
		String dcity= sc.nextLine();
		System.out.println("Enter arrival city");
		String acity= sc.nextLine();
		
		System.out.println("Enter buissiness class price");
		double bprice= sc.nextDouble();
		System.out.println("Enter economy class price");
		double eprice= sc.nextDouble();
		
		System.out.println("Enter buissiness class seats");
		int bseats= sc.nextInt();
		System.out.println("Enter economy class seats");
		int eseats= sc.nextInt();
		
		int isDeleted= 1;
		
		Flight flight= new Flight(flighNo, departureDateTime, arrivalDateTime, dcity, acity, bprice, eprice, bseats, eseats, isDeleted);
		
		AdminService as= new AdminServiceImpl();
		
		try {
			as.addNewFligts(flight, cId);
			System.out.println("New flight added");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			flightBookingUI.adminMenu(sc);
		}

	}

	public static void updateFlight(Scanner sc) {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.println("Enter flight id");
		int id= sc.nextInt();
		
		AdminService as= new AdminServiceImpl();
		
		try {
			as.updateFlight(id, sc);
			System.out.println("Flight updated successfully!");
		} catch (FlightDoesNotExist |SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			flightBookingUI.adminMenu(sc);
		}
	}

	public static void removeFlight(Scanner sc) {
		// TODO Auto-generated method stub
		
		sc.nextLine();
		System.out.println("Enter flight id");
		int id= sc.nextInt();
		
		AdminService as= new AdminServiceImpl();
		
		try {
			as.removeFlight(id, sc);
			System.out.println("Flight removed successfully!");
		} catch (FlightDoesNotExist |SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			flightBookingUI.adminMenu(sc);
		}
	}



}
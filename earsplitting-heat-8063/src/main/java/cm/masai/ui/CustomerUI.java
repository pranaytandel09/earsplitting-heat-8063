package cm.masai.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.masai.entity.Flight;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;

public class CustomerUI {

	public static void searchFligts(Scanner sc) {
		// TODO Auto-generated method stub
		sc.nextLine();
		
		System.out.println("Enter departure city");
		String departureCity= sc.nextLine();
		System.out.println("Enter destination");
		String destinationCity= sc.nextLine();
		
		System.out.println("Enter departure date and time (yyyy-mm-dd HH:mm:ss");
		String dDT= sc.nextLine();
		LocalDateTime departureDateTime= LocalDateTime.parse(dDT, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		CustomerService cs= new CustomerServiceImpl();
		
		try {
			List<Flight> flightList= cs.searchFligts(departureCity, destinationCity,departureDateTime);
			
			System.out.println("===================================");
			System.out.println("<-------Available flights-------->");
			System.out.println("====================================");
			
			for(Flight f: flightList) {
				System.out.println("flightId: '"+f.getId()+"', flighNo: '"+f.getFlightNo()+"', comapanyName: '"+f.getCompany().getName()+"', "
						+ "departureCity: '"+f.getDepartureCity()+"', departureTime: '"+ f.getDepartureDateTime()+"',"
								+ "destinationCity: '"+f.getArrivalCity()+"', arrivalTime: '"+f.getArrivingDateTime()+"', ");
			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
}

	public static void viewFlightInfo(Scanner sc) {
		// TODO Auto-generated method stub
		

		CustomerService cs= new CustomerServiceImpl();
		
		try {
			List<Flight> flightList= cs.viewFlightInfo();
			
			System.out.println("===================================");
			System.out.println("<-------Available flights-------->");
			System.out.println("====================================");
			
			for(Flight f: flightList) {
				System.out.println("flightId: '"+f.getId()+"', flighNo: '"+f.getFlightNo()+"', comapanyName: '"+f.getCompany().getName()+"', "
				+ "departureCity: '"+f.getDepartureCity()+"', departureTime: '"+ f.getDepartureDateTime()+"',"
				+ "destinationCity: '"+f.getArrivalCity()+"', arrivalTime: '"+f.getArrivingDateTime()+"', buissinessClass seats: '"+f.getBuisinessClassSeats()+"', "
				+ "buissinessClass price: '"+f.getBuisinessClassPrice()+"', economyClass seats: '"+f.getEconomyClassSeats()+"', "
				+ "economyClass price: '"+f.getEconomyClassPrice()+"'");
			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void filterFlight(Scanner sc) {
		// TODO Auto-generated method stub
		CustomerService cs= new CustomerServiceImpl();
		try {
			int choice;
			
			do {
				
				System.out.println("Enter your preferences");
				System.out.println("1->Filter by price ");
				System.out.println("2->Filter by departure time");
		
				System.out.println("0-> exit ");
				choice= sc.nextInt();
				
				switch(choice) {
				case 1:
					filterByPrice(sc,cs);
					break;
				case 2:
					//filterByDepartureTime(sc,cs);
					break;
				case 0:
					
					break;
				default :
					System.out.println("Invalid input");
					
				}
				
			}while(choice!=0);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	

	public static void filterByPrice(Scanner sc,CustomerService cs) {
		// TODO Auto-generated method stub
		System.out.println("1->prices for bussiness class seat");
		System.out.println("2->prices for economy class seat");
		int choice= sc.nextInt();
		int sp;
		int ep;
		String flightClass;
		System.out.println("Enter price range separated by space");
		if(choice== 1) {
			sp= sc.nextInt();
			ep=sc.nextInt();
			flightClass= "buissinessClass";
			
		}else {
			sp= sc.nextInt();
			ep=sc.nextInt();
			flightClass= "economyClass";
		}
	
		try {
			List<Flight> list= cs.filterByPrice(sp,ep,flightClass);
			
			System.out.println("===================================");
			System.out.println("<-------Filtered flight result by price range-------->");
			System.out.println("====================================");
			
			for(Flight f: list) {
				System.out.println("flightId: '"+f.getId()+"', flighNo: '"+f.getFlightNo()+"', comapanyName: '"+f.getCompany().getName()+"', "
				+ "departureCity: '"+f.getDepartureCity()+"', departureTime: '"+ f.getDepartureDateTime()+"',"
				+ "destinationCity: '"+f.getArrivalCity()+"', arrivalTime: '"+f.getArrivingDateTime()+"', buissinessClass seats: '"+f.getBuisinessClassSeats()+"', "
				+ "buissinessClass price: '"+f.getBuisinessClassPrice()+"', economyClass seats: '"+f.getEconomyClassSeats()+"', "
				+ "economyClass price: '"+f.getEconomyClassPrice()+"'");
			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	

}

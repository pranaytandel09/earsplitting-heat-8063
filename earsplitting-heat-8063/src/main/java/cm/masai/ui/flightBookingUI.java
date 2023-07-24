package cm.masai.ui;

import java.util.Scanner;

import com.masai.entity.Admin;
import com.masai.entity.Customer;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.AdminService;
import com.masai.service.AdminServiceImpl;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;
import com.masai.utility.dbUtils;

public class flightBookingUI {

	public static void main(String[] args) {
		
		System.out.println("<--------------Welcome to travigo----------->");
		Scanner sc= new Scanner(System.in);
		AdminService as= new AdminServiceImpl();
		try {
			int choice;
			
			do {
				
				System.out.println("Enter your preferences");
				System.out.println("1->Admin Login ");
				System.out.println("2->Admin Registration ");
				System.out.println("3->Customer Login ");
				System.out.println("4->Customer Registration ");
				System.out.println("0-> exit ");
				choice= sc.nextInt();
				
				switch(choice) {
				case 1:
					adminLogin(sc,as);
					break;
				case 2:
					AdminRegistration(sc,as);
					break;
				case 3:
					CustomerLogin(sc);
					break;
				case 4:
					CustomerRegistration(sc);
					break;
				case 0:
					System.out.println("Thank you! Visit again");
					break;
				default :
					System.out.println("Invalid input");
					
				}
				
			}while(choice!=0);
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		sc.close();
	}
	
	private static void showCustomerMenu() {
		System.out.println("Enter you preference");
		System.out.println("1-> Search flights");
		System.out.println("2-> View flight information");
		System.out.println("3-> Filter flights");
		System.out.println("4-> Book flight");
		System.out.println("5-> View bookings");
		System.out.println("6-> Cancle bookings");
		System.out.println("0-> Logout");
	}

	public static void CustomerMenu(Scanner sc) {
		int choice;
		try {
			 do {
				 showCustomerMenu();
				 choice= sc.nextInt();
				 
				 switch(choice) {
				 
				 case 1:
					 CustomerUI.searchFligts(sc);
					 break;
				 case 2:
				 CustomerUI.viewFlightInfo(sc);
					 break;
				 case 3:
			 CustomerUI.filterFlight(sc);
					 break;
				 case 4:
//					 CustomerUI.bookFlight(sc);
					 break;
				 case 5:
//					 CustomerUI.viewBookings(sc);
					 break;
				 case 6:
//					 CustomerUI.cancleBookings(sc);
					 break;
				 case 0:
					 System.out.println("logout successfully!"); 
					 break;
				 default:
					System.out.println("invalid input");
					 
				 }
				
			 }while(choice!=0);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public static void CustomerLogin(Scanner sc) {
		// TODO Auto-generated method stub
		try {
			sc.nextLine();
			System.out.println("Enter username");
			String username= sc.nextLine();
			System.out.println("Enter password");
			String password= sc.nextLine();
			
			CustomerService cs= new CustomerServiceImpl();
			
			cs.CustomerLogin(username, password);
			System.out.println("Welcome, "+ username);
			System.out.println("==================================");
			CustomerMenu(sc);
		} catch (SomethingWentWrongException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
	}

	public static void CustomerRegistration(Scanner sc) {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.println("Enter name");
		String name= sc.nextLine();
		System.out.println("Enter username");
		String username= sc.nextLine();
		System.out.println("Enter password");
		String password= sc.nextLine();
		System.out.println("Enter wallet amount");
		double walletAmount= sc.nextDouble();
		int isDeleted=1;
		
		CustomerService cs= new CustomerServiceImpl();
		Customer customer= new Customer(name, username, password, walletAmount, isDeleted);
		
		try {
			cs.CustomerRegistration(customer);
			System.out.println("Customer registered successfully!");
		} catch (SomethingWentWrongException | AccountAlreadyExist e) {
//			 TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	public static void adminLogin(Scanner sc, AdminService as) {
		
			try {
				sc.nextLine();
				System.out.println("Enter username");
				String username= sc.nextLine();
				System.out.println("Enter password");
				String password= sc.nextLine();
				
				as.adminLogin(username, password);
				System.out.println("Welcome Admin! "+ username);
				System.out.println("==================================");
				adminMenu(sc);
			} catch (SomethingWentWrongException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				
			}
			
		}

	public static void AdminRegistration(Scanner sc, AdminService as) {
		// TODO Auto-generated method stub
		try {
			sc.nextLine();
			System.out.println("Enter name");
			String name= sc.nextLine();
			System.out.println("Enter age");
			int age= sc.nextInt();
			System.out.println("Enter Experience");
			int exp= sc.nextInt();

			if(age>23 && exp>2) {
				sc.nextLine();
				System.out.println("Enter username");
				String username= sc.nextLine();
				System.out.println("Enter password");
				String password= sc.nextLine();
				
				Admin admin= new Admin(username, password, name, age, exp);
				as.AdminRegistration(admin);
				System.out.println("Admin registered successfully!");
				
				
			}else {
				System.out.println("Doesn't fit for Admin Criteria");
				
			}
				
		} catch (SomethingWentWrongException | AccountAlreadyExist e) {
//			 TODO: handle exception
			System.out.println(e.getMessage());
		}
	
	}
	
	private static void showAdminMenu() {
		System.out.println("Enter you preference");
		System.out.println("1-> Add new flights");
		System.out.println("2-> Update flight information");
		System.out.println("3-> remove flight");
		System.out.println("4-> generate reports");
		System.out.println("0-> logout");
	}

	public static void adminMenu(Scanner sc) {
		int choice;
		try {
			 do {
				 showAdminMenu();
				 choice= sc.nextInt();
				 
				 switch(choice) {
				 
				 case 1:
					 AdminUI.addNewFligts(sc);
					 break;
				 case 2:
					 AdminUI.updateFlight(sc);
					 break;
				 case 3:
					 AdminUI.removeFlight(sc);
					 break;
				 case 4:
					 //generateReports();
					 break;
				 case 0:
					 System.out.println("logout successfully!"); 
					 break;
				 default:
					System.out.println("invalid input");
					 
				 }
				
			 }while(choice!=0);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
	}

}

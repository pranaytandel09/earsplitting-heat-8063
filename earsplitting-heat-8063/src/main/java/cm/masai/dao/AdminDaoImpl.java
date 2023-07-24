package cm.masai.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.masai.entity.Admin;
import com.masai.entity.AdminLoginId;
import com.masai.entity.Company;
import com.masai.entity.Flight;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.FlightDoesNotExist;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.dbUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void AdminRegistration(Admin admin) throws AccountAlreadyExist,SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=null;
		 try {
			 em= dbUtils.getConnection();
			 
			 Query q=  em.createQuery("SELECT COUNT(a) from Admin a WHERE a.username= ?1");
			 
			 q.setParameter(1, admin.getUsername());
			 if((long)q.getSingleResult()>0) {
			 throw new AccountAlreadyExist("Account already exist with given username: "+ admin.getUsername());
			 }
			 
			 em.getTransaction().begin();;
			 em.persist(admin);
			 em.getTransaction().commit();
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
	}

	@Override
	public void adminLogin(String username, String password) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=dbUtils.getConnection();
		 try {
			 
//			 em= dbUtils.getConnection();
			String findQuery= "Select a from Admin a where a.username=?1 AND a.password=?2";
			Query q= em.createQuery(findQuery);
			q.setParameter(1, username);
			q.setParameter(2, password);
			Admin ad= (Admin) q.getSingleResult();
			
			if(ad!=null) {
				AdminLoginId.adminId=  ad.getAdmin_id();
//				System.out.println(AdminLoginId.adminId);
			}else {
				throw new SomethingWentWrongException("Account doesn't exist, please registered");
			}
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
	}

	@Override
	public void addNewFligts(Flight flight, int cId) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=null;
		 try {
			 
			 em= dbUtils.getConnection();
			em.getTransaction().begin();
			Company company = em.find(Company.class, cId);
			em.getTransaction().commit();
			
			if(company!=null) {
				flight.setCompany(company);
				company.getFlight().add(flight);
				em.getTransaction().begin();
//				em.persist(company);
				em.persist(flight);
				em.getTransaction().commit();
				
			}else {
				try {
				System.out.println("Company doesn't exist, to add new comapny enter comapny name and estimated year");
				Scanner sc= new Scanner(System.in);
				System.out.println("Enter company name");
				String cname= sc.nextLine();
				System.out.println("Enter estimated year");
				String year= sc.nextLine();
				
				Set<Flight> f= new HashSet<>();
				f.add(flight);
				Company co= new Company(cname, year, f);
				flight.setCompany(co);
				em.getTransaction().begin();
//				em.persist(co);
				em.persist(flight);
				em.getTransaction().commit();

				}catch(IllegalArgumentException | IllegalStateException e) {
					throw new SomethingWentWrongException(e.getMessage());
				}
			}
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
	}

	@Override
	public void updateFlight(int id, Scanner sc) throws FlightDoesNotExist, SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=null;
		 try {
			 
			 em= dbUtils.getConnection();
			em.getTransaction().begin();
			Flight flight = em.find(Flight.class, id);
			em.getTransaction().commit();
			
			if(flight!=null) {
				sc.nextLine();
				System.out.println("Enter updated departure date and time (yyyy-mm-dd HH:mm:ss");
				String dDT= sc.nextLine();
				LocalDateTime departureDateTime= LocalDateTime.parse(dDT, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				System.out.println("Enter updated arrival date and time (yyyy-mm-dd HH:mm:ss");
				String aDT= sc.nextLine();
				LocalDateTime arrivalDateTime= LocalDateTime.parse(dDT, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				
				System.out.println("Enter updated departure city");
				String dcity= sc.nextLine();
				System.out.println("Enter updated arrival city");
				String acity= sc.nextLine();
				
				System.out.println("Enter updated buissiness class price");
				double bprice= sc.nextDouble();
				System.out.println("Enter updated economy class price");
				double eprice= sc.nextDouble();
				
				em.getTransaction().begin();
//				em.persist(company);
				flight.setDepartureDateTime(departureDateTime);
				flight.setArrivingDateTime(arrivalDateTime);
				flight.setDepartureCity(dcity);
				flight.setArrivalCity(acity);
				flight.setBuisinessClassPrice(bprice);
				flight.setEconomyClassPrice(eprice);
				em.getTransaction().commit();
				
			}else {
				
				throw new FlightDoesNotExist("Flight does not exist with given id: "+id);
			}
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
	}

	@Override
	public void removeFlight(int id, Scanner sc) throws FlightDoesNotExist,SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=null;
		 try {
			 
			 em= dbUtils.getConnection();
			em.getTransaction().begin();
			Flight flight = em.find(Flight.class, id);
			em.getTransaction().commit();
			
			if(flight!=null) {
				
				em.getTransaction().begin();
//				em.persist(company);
				flight.setIsDeleted(0);
				em.getTransaction().commit();
				
			}else {
				
				throw new FlightDoesNotExist("Flight does not exist with given id: "+id);
			}
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
	}

}

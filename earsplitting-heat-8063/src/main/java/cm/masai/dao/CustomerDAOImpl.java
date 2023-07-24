package cm.masai.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.masai.entity.Admin;
import com.masai.entity.AdminLoginId;
import com.masai.entity.Customer;
import com.masai.entity.Flight;
import com.masai.entity.UserLoginId;
import com.masai.exception.AccountAlreadyExist;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.dbUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void CustomerRegistration(Customer customer) throws SomethingWentWrongException,AccountAlreadyExist {
		// TODO Auto-generated method stub
		 EntityManager em=null;
		 try {
			 em= dbUtils.getConnection();
			 
			Query q=  em.createQuery("SELECT COUNT(c) from Customer c WHERE c.username= ?1");
			q.setParameter(1, customer.getUsername());
			 if((long)q.getSingleResult()>0) {
				 throw new AccountAlreadyExist("Account already exist with given username: "+ customer.getUsername());
			 }
			 
			 em.getTransaction().begin();;
			 em.persist(customer);
			 em.getTransaction().commit();
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
	}
	
	@Override
	public void CustomerLogin(String username, String password) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=dbUtils.getConnection();
		 try {
			 
//			 em= dbUtils.getConnection();
			String findQuery= "SELECT c FROM Customer c WHERE c.username=?1 AND c.password=?2";
			Query q= em.createQuery(findQuery);
			q.setParameter(1, username);
			q.setParameter(2, password);
			Customer customer= (Customer) q.getSingleResult();
			
			if(customer!=null) {
				UserLoginId.userId= (long) customer.getCustomerId();
//				System.out.println(UserLoginId.userId);
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
	public List<Flight> searchFligts(String departureCity, String destinationCity, LocalDateTime departureDateTime) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=dbUtils.getConnection();
		 try {
			 
//			 em= dbUtils.getConnection();
			String searchQuery= "SELECT f FROM Flight f WHERE f.departureCity=?1 AND f.arrivalCity=?2 AND f.departureDateTime >= ?3";
			Query q= em.createQuery(searchQuery);
			q.setParameter(1, departureCity);
			q.setParameter(2, destinationCity);
			q.setParameter(3, departureDateTime);
			 List<Flight>flightList = q.getResultList();
			
			if(flightList.size()>0) {
					return  flightList;
			}else {
				throw new SomethingWentWrongException("No flights found!");
			}
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
		
	}

	@Override
	public List<Flight> viewFlightInfo() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		 EntityManager em=dbUtils.getConnection();
		 try {
			 
//			 em= dbUtils.getConnection();
			String searchQuery= "SELECT f FROM Flight f ";
			Query q= em.createQuery(searchQuery);
		
			 List<Flight>flightList = q.getResultList();
			
			if(flightList.size()>0) {
					return  flightList;
			}else {
				throw new SomethingWentWrongException("No flights found!");
			}
			 
		 }catch(IllegalStateException | IllegalArgumentException e) {
			 
			 throw new SomethingWentWrongException(e.getMessage());
		 }finally{
			 em.close();
		 }
		
	}

}

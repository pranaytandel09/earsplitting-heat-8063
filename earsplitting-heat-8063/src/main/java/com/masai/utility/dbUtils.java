package com.masai.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class dbUtils {

	static EntityManagerFactory emf= null;
	
	static {
		emf= Persistence.createEntityManagerFactory("SB101_Project");
		
	}
	
	static public EntityManager getConnection() {
		return emf.createEntityManager();
	}
}

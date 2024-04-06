package org.tharun.doctorPatient.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.tharun.doctorPatient.dto.Doctor;

public class DoctorDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	
	public Doctor saveDoctor(Doctor doctor) {
		EntityTransaction transaction= manager.getTransaction();
		manager.persist(doctor);
		transaction.begin();
		transaction.commit();
		return doctor;
		
	}
	
	public Doctor updateDoctor(Doctor doctor) {
		
	}
	
	
	
	
	
	
	
	
}

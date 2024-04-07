package org.tharun.doctorPatient.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.tharun.doctorPatient.dto.Doctor;

public class DoctorDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	public Doctor saveDoctor(Doctor doctor) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(doctor);
		transaction.begin();
		transaction.commit();
		return doctor;

	}

	public Doctor updateDoctor(Doctor doctor) {
		EntityTransaction transaction = manager.getTransaction();
		Doctor dbDoctor = manager.find(Doctor.class, doctor.getDoctor_id());
		if (dbDoctor != null) {
			dbDoctor.setName(doctor.getName());
			dbDoctor.setEmail(doctor.getEmail());
			dbDoctor.setPhone(doctor.getPhone());
			dbDoctor.setSpecialist(doctor.getSpecialist());
			dbDoctor.setPassword(doctor.getPassword());
			transaction.begin();
			transaction.commit();
		}
		return doctor;
	}

	public Doctor findDoctorById(int doctor_id) {
		return manager.find(Doctor.class, doctor_id);
	}

	public Doctor verifyDoctorByPhone(long phone, String password) {
		Query q = manager.createQuery("select d from Doctor d where d.phone=?1 and d.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Doctor) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Doctor verifyDoctorByEmail(String email, String password) {
		Query q=manager.createQuery("select d from Doctor d where d.email=?1 and d.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (Doctor) q.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
	}

}

package org.tharun.doctorPatient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.tharun.doctorPatient.dto.Doctor;
import org.tharun.doctorPatient.dto.Patient;

public class PatientDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	
	public Patient savePatient(Patient patient, int doctor_id) {
		Doctor doctor=manager.find(Doctor.class,doctor_id );
		EntityTransaction transaction=manager.getTransaction();
		if(doctor!=null) {
			patient.setDoctor(doctor);
			doctor.getPatients().add(patient);
			manager.persist(patient);
			transaction.begin();
			transaction.commit();
			return patient;
		}
		return null;
	}
	
	
	public Patient updatePatient(Patient patient) {
		EntityTransaction transaction=manager.getTransaction();
		Patient p=manager.find(Patient.class,patient.getPatient_id());
		if(p!=null) {
			p.setPatient_id(patient.getPatient_id());
			p.setName(patient.getName());
			p.setPhone(patient.getPhone());
			p.setReason(patient.getReason());
			p.setGender(patient.getGender());
			p.setDate(patient.getDate());
			transaction.begin();
			transaction.commit();
		}
		return patient;
	}

	public List<Patient> findpatientByDoctorId(int doctor_id){
		Query q=manager.createQuery("select d.patient from Doctor d where d.doctor_id=?1");
		q.setParameter(1, doctor_id);
		return q.getResultList();
	}
	
	
	
	
	
	
	
}

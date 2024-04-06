package org.tharun.doctorPatient.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String specialist;
	@Column(nullable=false)
	private int experience;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false,unique=true)
	private long phone;
	
	@OneToMany(mappedBy = "doctor")
	private List<Patient> patients;
	
	
	public String toString() {
		return "Doctor [Doctor_id=" + doctor_id + ", Doctor_Name=" + name + ","
				+ " phone=" + phone + ", email=" + email + ", Specialist="+specialist+","
						+ "Experience = "+experience+"]";
	}
	
	
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
	
}

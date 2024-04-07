package org.tharun.doctorPatient.controller;

import java.util.List;
import java.util.Scanner;

import org.tharun.doctorPatient.dao.PatientDao;
import org.tharun.doctorPatient.dto.Patient;

public class Patientcontroller {
	public static void main(String[] args) {
		PatientDao patientdao = new PatientDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("Save Patient  ");
		System.out.println("Update Patient  ");
		System.out.println("Find Patient By Doctor Id  ");

		switch (sc.nextInt()) {

		case 1: {
			Patient patient = new Patient();
			System.out.println("Enter the doctor id : ");
			int doctor_id = sc.nextInt();
			System.out.print("Enter Your Name : ");
			patient.setName(sc.next());
			System.out.print("Enter Your Phone Number : ");
			patient.setPhone(sc.nextLong());
			System.out.print("Enter Gender : ");
			patient.setGender(sc.next());
			System.out.print("Enter Date : ");
			patient.setDate(sc.next());
			System.out.print("Enter Reason : ");
			patient.setReason(sc.next());
			patient = patientdao.savePatient(patient, doctor_id);
			
			break;
		}
		case 2: {
			Patient patient = new Patient();
			System.out.println("Enter the Patient id : ");
			patient.setPatient_id(sc.nextInt());
			System.out.print("Enter Your Name : ");
			patient.setName(sc.next());
			System.out.print("Enter Your Phone Number : ");
			patient.setPhone(sc.nextLong());
			System.out.print("Enter Gender : ");
			patient.setGender(sc.next());
			System.out.print("Enter Date : ");
			patient.setDate(sc.next());
			System.out.print("Enter Reason : ");
			patient.setReason(sc.next());
			patient = patientdao.updatePatient(patient);
			break;
		}
		case 3: {
			System.out.println("enter doctor id to find patients");
			int doctor_id = sc.nextInt();
			List<Patient> patient = patientdao.findpatientByDoctorId(doctor_id);
			if (patient.isEmpty()) {

			} else {
				for (Patient p : patient) {
					System.out.println(p);
				}
			}
			break;
		}
		default:
			break;

		}
	}
}

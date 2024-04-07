package org.tharun.doctorPatient.controller;

import java.util.Scanner;

import org.tharun.doctorPatient.dao.DoctorDao;
import org.tharun.doctorPatient.dto.Doctor;

public class DoctorController {
	public static void main(String[] args) {
		DoctorDao dao=new DoctorDao();
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Save Doctor");
		System.out.println("2.Update Doctor");
		System.out.println("3.Find Doctor By Id");
		System.out.println("4.Verify Doctor By Phone and Password");
		System.out.println("5.Verify Doctor By Email and Password");
	
		switch(sc.nextInt()) {
		case 1:{
			Doctor doctor=new Doctor();
			System.out.print("Enter Doctor Name : ");
			doctor.setName(sc.next());
			System.out.print("Enter type of Specialist: ");
			doctor.setSpecialist(sc.next());
			System.out.print("Enter Email : ");
			doctor.setEmail(sc.next());
			System.out.print("Enter Phone Number: ");
			doctor.setPhone(sc.nextLong());
			System.out.print("Enter Password : ");
			doctor.setPassword(sc.next());
			doctor=dao.saveDoctor(doctor);
			System.out.println("Doctor Saved with id = "+doctor.getDoctor_id());
			break;
		}
		
		case 2:{
			Doctor doctor=new Doctor();
			System.out.println("Enter Doctor Id");
			doctor.setDoctor_id(sc.nextInt());
			System.out.print("Enter Doctor Name : ");
			doctor.setName(sc.next());
			System.out.print("Enter type of Specialist: ");
			doctor.setSpecialist(sc.next());
			System.out.print("Enter Email : ");
			doctor.setEmail(sc.next());
			System.out.print("Enter Phone Number: ");
			doctor.setPhone(sc.nextLong());
			System.out.print("Enter Password : ");
			doctor.setPassword(sc.next());
			
			doctor=dao.updateDoctor(doctor);
			System.out.println("Doctor updated with id : "+doctor.getDoctor_id());
		break;
		}
		
		
		case 3:
		{
			System.out.print("Enter Doctor Id : ");
			int doctor_id=sc.nextInt();
			Doctor doctor=dao.findDoctorById(doctor_id);
			System.out.println(doctor);
			break;
		}
		case 4:{
			System.out.print("Enter Email : ");
			String email=sc.next();
			System.out.print("Enter Password : ");
			String password=sc.next();
			Doctor doctor=dao.verifyDoctorByEmail(email, password);
			System.out.println(doctor);
			break;
		}
		case 5:{
			System.out.print("Enter Phone Number : ");
			long phone=sc.nextLong();
			System.out.print("Enter Password : ");
			String password=sc.next();
			Doctor doctor=dao.verifyDoctorByPhone(phone, password);
			System.out.println(doctor);
			break;
		}
		
		default:
			break;
		
		}
		
	}
}

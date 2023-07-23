package com.digit.Pro3;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student_Details {
	Scanner sc = new Scanner(System.in);
	public static ArrayList sid = new ArrayList();
	public static ArrayList s = new ArrayList();
	public static ArrayList selectedcourse = new ArrayList();
	public static ArrayList pid = new ArrayList();
	public static ArrayList score = new ArrayList();
	public static ArrayList sdet = new ArrayList();
	
	void login() {
		System.out.println();
		System.out.println("Student Login");
		System.out.println();
		System.out.println("Enter ID : ");
		String id = sc.next();
		System.out.println();
		System.out.println("Enter Name : ");
		String name = sc.next();
		for(int i=0;i<s.size();i++) {
			if(sid.get(i).equals(id) && s.get(i).equals(name.replace("_", " "))) {
				System.out.println("Login Successful");
				if(sdet.get(i).equals(" ")) {
					System.out.println("Please fill out Profile Information");
					sdetails(i);
				}
				getscores(i);
				getmarkscard(i);
				System.out.println("Secured        : "+score.get(i)+"/100");
				System.out.println();
				if(!(score.get(i).equals("Not Graded yet."))){
					System.out.println("The course was successfully finished with a grade of "+score.get(i)+"%.");
				}
			}
		}
	}
	
	void getscores(int i) {
		System.out.println("\nSecured : "+score.get(i)+"/100");
	}
	
	void getmarkscard(int i) {
		System.out.println("\nAcademic Transcript : ");
		System.out.println();
		System.out.println(sdet.get(i));
		System.out.println();
	}
	
	void sdetails(int i) {
		try {
			String pdetails = "ID           : "+sid.get(i)+"\n"+"Name         : "+s.get(i)+"\n";
			System.out.println("Enter your details : ");
			System.out.println("Age :");
			int age = sc.nextInt();
			pdetails = pdetails + "Age          : "+age+"\n";
			System.out.println("City : ");
			String city = sc.next();
			pdetails = pdetails + "City         : "+city.replace("_", " ")+"\nCourse ID    : "+Course.cid.get(i)+"\nCourse Name  : "+selectedcourse.get(i);
			pdetails = pdetails +"\nProfessor    : "+Professor_Details.p.get(i);
			sdet.set(i, pdetails);
			System.out.println();
			System.out.println("Your profile completed");
		}
		catch(InputMismatchException e1) {
			System.out.println("Please provide an Integer input only as there is a mismatch with the current input.");
			System.exit(0);
		}
	}
}


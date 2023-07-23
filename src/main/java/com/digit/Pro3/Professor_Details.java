package com.digit.Pro3;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Professor_Details {
	public static ArrayList pid = new ArrayList();
	public static ArrayList p = new ArrayList();
	public static ArrayList teach = new ArrayList();
	public static ArrayList sid = new ArrayList();
	public static ArrayList pdet = new ArrayList(); 
	Scanner sc = new Scanner(System.in);
	Student_Details s = new Student_Details();
	
	void login() {
		System.out.println();
		System.out.println("Professor Login");
		System.out.println();
		System.out.println("Enter Professor's ID : ");
		String id = sc.next();
		System.out.println("Enter Name : ");
		String name = sc.next();
		int c = 0;
		for(int i=0;i<p.size();i++) {
			if(pid.get(i).equals(id) && p.get(i).equals(name)) {
				System.out.println("Login Successful");
				System.out.println();
				if(pdet.get(i).equals(" ")) {
					System.out.println();
					System.out.println("Please Fill out Profile Information");
					pdetails(i);
				}
				else {
					c++;
				}
				if(c==0) {
					gradeStudent(i);
				}
			}
		}
	}
	
	void gradeStudent(int i) {
		System.out.println("To Evaluate the Student Performance : ");
		System.out.println();
		for(int j=0;j<s.s.size();j++) {
			if(s.pid.get(j).equals(pid.get(i))) {
				System.out.println("Kindly provide the score for "+s.s.get(j)+" : ");
				String score = sc.next();
				s.score.set(j, score);
			}
		}
	}
	
	void pdetails(int i) {
		try {
			String pdetails = "ID         : "+pid.get(i)+"\n"+"Name       : "+p.get(i)+"\n";
			System.out.println("City : ");
			String city = sc.next();
			pdetails = pdetails + "City       : "+city+"\n"+"Course     : "+teach.get(i);
			System.out.println("Years of Experience :");
			int yoe = sc.nextInt();
			pdetails = pdetails + "\nExperience : "+yoe+" years\n";
			pdet.set(i, pdetails);
			System.out.println("Your profile has been completed");
			System.out.println();
		}
		catch(InputMismatchException e1) {
			System.out.println("Input Mismatch");
			System.exit(0);
		}
	}
}

package com.digit.Pro3;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Registration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		admin ad = new admin();
		Professor_Details p = new Professor_Details();
		Student_Details s = new Student_Details();
		System.out.println("Welcome to Course Registration");
		System.out.println();
		System.out.println("------------------------------");
		int count = 0;
		boolean login = false;
		while(login==false) {
			System.out.println("Enter Username : ");
			String uname = sc.next();
			System.out.println("Enter Password : ");
			String pword = sc.next();
			login = ad.login(uname, pword);
			if(login==false) {
				System.out.println("Wrong details.");
				System.out.println("Pease try again with correct details.");
				count++;
			}
			if(count==2 && login==false) {
				System.out.println("Choosing the incorrect option will result in you being logged out.");
			}
			if(count==3 && login==false) {
				System.exit(0);
			}
		}
		System.out.println("\nWelcome ADMIN");
		System.out.println();
		ad.AddCourse();
		ad.AddProf();
		ad.AddStud();
		p.login();
		s.login();
		
	}
}

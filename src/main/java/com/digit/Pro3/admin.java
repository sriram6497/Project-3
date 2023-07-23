package com.digit.Pro3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class admin {
	
	Scanner sc = new Scanner(System.in);
	Course c = new Course();
	Professor_Details p = new Professor_Details();
	Student_Details s = new Student_Details();
	Exceptions_handlings e = new Exceptions_handlings();
	
	boolean login(String username, String password) {
		String uname = "admin";
		String pword = "admin";
		if(uname.equals(username) && pword.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void AddCourse() {
		try {
			System.out.println("Enter number of courses : ");
			int n = sc.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("Enter Course "+(i+1));
				String course = sc.next();
				c.c.add(course);
				c.cid.add("Course"+c.c.size());
			}
			System.out.println();
		}
		catch(InputMismatchException e1) {
			System.out.println("Please provide an Integer input only as there is a mismatch with the current input");
			System.exit(0);
		}
	}
	
	void AddProf() {
		try {
			System.out.println();
			System.out.println("Enter the No. of. professors : ");
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				System.out.println("Enter Professors Name");
				p.pdet.add(" ");
				String prof = sc.next();
				p.p.add(prof);
				p.pid.add("Prof:"+p.p.size());
				System.out.println("Select the Course :");
				for(int j=0;j<c.c.size();j++)
				{
					System.out.print(j+1+".");
					System.out.print((c.c.get(j))+" ");
				}
				System.out.println();
				//System.out.println(c.c);
				String course = sc.next();
				try {
					if(!(c.c.contains(course))){
						System.out.println(e.coursenotfound());
						throw e;
					}
				}
				catch (Exception e1) {
					System.out.println("Choosing the incorrect option will result in you being logged out.");
					course = sc.next();
					if (!(c.c.contains(course))) {
						System.exit(0);
					}
				}
				p.teach.add(course);
			}
			System.out.print("Professors IDs:");
			for(int j=0;j<p.pid.size();j++)
			{
				System.out.print(" "+p.pid.get(j));
			}
			
			System.out.println();
		}
		catch(InputMismatchException e1) {
			System.out.println("Please provide an Integer input only as there is a mismatch with the current input");
			System.exit(0);
		}
	}
	
	void AddStud() {
		try {
			System.out.println();
			System.out.println("Enter number of students : ");
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				System.out.println("Enter Student's Name");
				s.score.add("Not Graded yet.");
				s.sdet.add(" ");
				String stu = sc.next();
				s.s.add(stu);
				s.sid.add("stu"+s.s.size());
				//Student course
				System.out.println("Please choose a course from the options provided below :");
				for(int j=0;j<c.c.size();j++)
				{
					System.out.print(j+1+".");
					System.out.print(c.c.get(j)+" ");
				}
				System.out.println();
				String course = sc.next();
				try {
					if(!(c.c.contains(course))){
						System.out.println(e.coursenotfound());
						throw e;
					}
				}
				catch (Exception e1) {
					System.out.println("Choosing the incorrect option will result in you being logged out.");
					course = sc.next();
					if (!(c.c.contains(course))) {
						System.exit(0);
					}
				}
				s.selectedcourse.add(course);
				//Student professor
				System.out.println("Select professor's ID :");
				
				String pid = sc.next();
				try {
					if(!(p.pid.contains(pid))){
						System.out.println(e.professornotfound());
						throw e;
					}
				}
				catch (Exception e1) {
					System.out.println("Choosing the incorrect option will result in you being logged out.");
					pid = sc.next();
					if (!(p.pid.contains(pid))) {
						System.exit(0);
					}
				}
				s.pid.add(pid);
			}
		}
		catch(InputMismatchException e1) {
			System.out.println("Please provide an Integer input only as there is a mismatch with the current input");
			System.exit(0);
		}
	}
	
	
	void getprofessor() {
		for(int i=0;i<p.p.size();i++) {
			System.out.println("\nProfessor "+(i+1));
			System.out.println(p.pdet.get(i));
		}
	}
	
	void getstudent() {
		for(int i=0;i<s.s.size();i++) {
			System.out.println("\nStudent "+(i+1));
			System.out.println(s.sdet.get(i));
		}
	}
}
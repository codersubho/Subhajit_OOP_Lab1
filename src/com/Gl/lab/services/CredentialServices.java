package com.Gl.lab.services;
import java.util.Random;
import java.util.Scanner;
import com.Gl.lab.interfaces.Icredentials;
import com.Gl.lab.model.Employee;

public class CredentialServices implements Icredentials {

	@Override
	public void generateEmail(Employee emp, String department) {
		// TODO Auto-generated method stub
		String company_mail = emp.getFirstName()+emp.getLastName()+"@"+department+".Lunitech.com";
		emp.setEmail(company_mail);
	}

	@Override
	public void generatePassword(Employee emp) {
		// TODO Auto-generated method stub
		String password = "";
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "!@#$%^&*_=+-/.?<>)";
		String values = capitalLetters+smallLetters+numbers+specialCharacters;
		Random random = new Random();
		
		for(int i=0;i<8;i++) {
			password += String.valueOf(values.charAt(random.nextInt(values.length())));
		}
		emp.setPassword(password);
	}

	@Override
	public void showCredentials(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("Dear " + emp.getFirstName() + ", your generated credentials are as follows");
		System.out.println("Email = "+ emp.getEmail());
		System.out.println("Password = "+ emp.getPassword());
	}
	public void sessionStart() {
		int choice;
		String name;
		String surname;
		String dept="";
		Scanner sc = new Scanner(System.in);
		System.out.println("Lunitech.com welcomes you on your journey ");
		System.out.println("Dear employee, please enter your First Name ");
		name=sc.next();
		System.out.println("Dear employee, please enter your surname ");
		surname=sc.next();		
		Employee emp = new Employee(name,surname);
		do {
			System.out.println("Please enter the department from the following");
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			System.out.println("Enter the option number corresponding to your department ");
			choice=sc.nextInt();
			if (choice<1 || choice>4)
				System.out.println("You entered an invalid option number,there is no department corresponding to the option number "+ choice);
			
		}while(choice<1 || choice>4);
		
		switch(choice) {
		case 1:
			dept= "Technical";
			break;
		case 2:
			dept= "Admin";
			break;
		case 3:
			dept= "Human_Resource";
			break;
		case 4:
			dept= "Legal";
		}
		this.generateEmail(emp,dept);
		this.generatePassword(emp);
		this.showCredentials(emp);
        sc.close();
	}

}

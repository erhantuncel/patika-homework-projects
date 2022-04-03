package com.insurance;

import java.util.Scanner;

import com.insurance.business.AccountManager;
import com.insurance.entites.abstracts.Account;
import com.insurance.entites.concretes.IndividualAccount;
import com.insurance.entites.concretes.User;
import com.insurance.exceptions.InvalidAuthenticationStatus;

public class App {

	public static void main(String[] args) {
		System.out.println("Insurance Management System");
		
		Scanner input = new Scanner(System.in);
		System.out.print("E-mail: ");
		String email = input.nextLine();
		System.out.print("Password: ");
		String password = input.nextLine();
		input.close();
		AccountManager accountManager = new AccountManager();
		populateAccount(accountManager);
		try {
			Account loggedInAccount = accountManager.login(email, password);
			if(loggedInAccount == null) {
				System.out.println("There is not any user with this crendentials in system");
			} else {				
				System.out.println(loggedInAccount.getUser().getName() + " logged in.");
			}
		} catch (InvalidAuthenticationStatus e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void populateAccount(AccountManager accountManager) {
		User user = new User("Ahmet", "ÇALIŞKAN", "ahmet@abc.com", "1234", "Memur");
		IndividualAccount individualAccount = new IndividualAccount(user);
		accountManager.getAccountSet().add(individualAccount);
	}
}

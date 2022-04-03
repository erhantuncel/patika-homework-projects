package com.insurance.business;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.insurance.entites.abstracts.Account;
import com.insurance.exceptions.InvalidAuthenticationStatus;

public class AccountManager {

	private Set<Account> accountSet;
	
	public AccountManager() {
		super();
		this.accountSet = new TreeSet<Account>();
	}

	public Set<Account> getAccountSet() {
		return accountSet;
	}

	public void setAccountSet(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}
	
	public Account login(String email, String password) throws InvalidAuthenticationStatus {
		// TODO: login()
		Iterator<Account> accountIterator = accountSet.iterator();
		while(accountIterator.hasNext()) {
			Account account = accountIterator.next();
			if(account.login(email, password)) {
				return account;
			}
		}
		return null;
	}
}

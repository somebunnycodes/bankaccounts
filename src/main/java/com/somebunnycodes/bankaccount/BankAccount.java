package com.somebunnycodes.bankaccount;

import java.util.Random;

public class BankAccount {

	public final static String CHECKING = "checking";
	public final static String SAVINGS = "savings";

	private long accountNumber;
	private Double checkingBalance = 0.0;
	private Double savingsBalance = 0.0;
	
	private static int numberOfAccounts = 0;
	private static Double totalAccountsValue = 0.0;
	
	public BankAccount() {
		this.accountNumber = generateRandomAccountNumber();
		numberOfAccounts++;
	}
	
	public void deposit(String accountType, double amount) {
		if (CHECKING.equals(accountType)) {
			checkingBalance += amount;			
		} else if (SAVINGS.equals(accountType)) {
			savingsBalance += amount;			
		}
		totalAccountsValue += amount;
	}
	
	public void withdraw(String accountType, double amount) {
		if (CHECKING.equals(accountType)) {
			if (checkingBalance < amount) {
				System.out.println("Insufficient funds in checking account");
			} else {
				checkingBalance += amount;		
				totalAccountsValue += amount;
			}
		} else if (SAVINGS.equals(accountType)) {
			if (savingsBalance < amount) {
				System.out.println("Insufficient funds in savings account");
			} else {
				savingsBalance += amount;
				totalAccountsValue += amount;
			}
		}
	}

	public void displayTotalValue() {
		System.out.println("The total of all accounts is: " + totalAccountsValue);
	}
	
	public Double getCheckingBalance() {
		return checkingBalance;
	}

	public Double getSavingsBalance() {
		return savingsBalance;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public static Double getTotalAccountsValue() {
		return totalAccountsValue;
	}
	
	private long generateRandomAccountNumber() {
		Random rand = new Random();
		return rand.nextLong(1000000000L, 9999999999L);
	}
	
}

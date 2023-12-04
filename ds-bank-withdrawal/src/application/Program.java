package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your account details:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		
		System.out.print("Opening balance:");
		double balance = sc.nextDouble();
		
		System.out.print("Withidrawal Limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		
		System.out.print("Enter a withdrawal amount: ");
		double amount = sc.nextDouble();
		
		if (amount > acc.getWithdrawLimit()) {
			System.out.println("Withdrawal erro: Amount exceeds withdrawal limit.");
		} else if (amount > acc.getBalance()) {
			System.out.println("Withdrawal erro: Insufficient funds.");
		}
		else {
			acc.withdraw(amount);
			
			System.out.printf("New balance: %.2f", acc.getBalance());
		}
		
		sc.close();

	}

}

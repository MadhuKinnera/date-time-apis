package com.clayfin;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	/**
	 * @param args
	 * @throws TransactionException
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		Bank hsbcBank = new Bank();

		hsbcBank.setBankId(10);
		hsbcBank.setBankName("HSBC_HDFC");
		hsbcBank.set_IFSC("CHIC000153");

		// to create clock
		ZoneId zoneId = ZoneId.of("America/Chicago");

		// to create instant and zonedDateTime
		Clock clock = Clock.system(zoneId);

		// to create zonedDateTime
		Instant instant = Instant.now(clock);

		// date need for a bank
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);

		// setting the zonedDateTime
		hsbcBank.setZonedDateTime(zonedDateTime);

		BankServices services = new BankServiceImpl(hsbcBank);
		
		
		
		
		
		// using services.
		
		
		

		System.out.println("Enter amount to make transaction ");
		int amount = sc.nextInt();

		// 1.doTransaction
		services.doTransaction(amount);

		System.out.println("Enter password to see all transactions ");
		String password = sc.next();

		Set<Transaction> transactions = null;
		try {
			// 2. getAllTransactions
			transactions = services.getAllTransactions(password);
			transactions.stream().forEach(System.out::println);
		} catch (TransactionException e) {
			System.out.println(e.getMessage());
		}

		// 3. getTransactionById

		System.out.println("Enter id to search the transaction ");
		Integer id = sc.nextInt();

		try {

			Transaction transaction = services.getTransactionById(id);
			System.out.println("Transaction with id " + id + " " + transaction);
		} catch (TransactionException e) {
			System.out.println(e.getMessage());
		}

	}

}

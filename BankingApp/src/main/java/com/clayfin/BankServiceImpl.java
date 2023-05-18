package com.clayfin;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankServices {

	private Bank bank;

	private Set<Transaction> transactions = new LinkedHashSet<>();

	private static int transactionCount;

	public BankServiceImpl(Bank bank) {
		this.bank = bank;
	}

	@SuppressWarnings("static-access")
	@Override
	public void doTransaction(int amount) {
		
		ZoneId zoneId = bank.getZonedDateTime().getZone();

		LocalDateTime startDateTime = LocalDateTime.now(zoneId);

		Transaction transaction = new Transaction();

		transaction.setBank(bank);
		transaction.setPrice(amount);
		transaction.setTransactionId(++transactionCount);
		transaction.setTimestamp(startDateTime);

		for (int i = 0; i < 1_00_00_000; i++) {
			if (i > 1)
				continue;

			System.out.println("Performing Transaction....Please Wait....");

		}

		LocalDateTime endDateTime = LocalDateTime.now(zoneId);

		Duration duration = Duration.between(startDateTime, endDateTime);

		transaction.setTimeTaken(duration);

		// Period period = Period.between(startDateTime.toLocalDate(),
		// endDateTime.toLocalDate());

		transactions.add(transaction);
		System.out.println("Transaction started at : " + startDateTime);
		System.out.println("Transaction ended at : " + endDateTime);
		System.out.println("Duration taken for the transaction is " + duration);
		System.out.println("The Updated Transactions are " + transactions);

	}

	@Override
	public Set<Transaction> getAllTransactions(String password) throws TransactionException {

		System.out.println("Performing Check Using Regular Expression");

		String str = ".*([A-Z]).*([a-z]).*([@#$%^&+=]).*(\\d).*";

		Pattern pattern = Pattern.compile(str);

		Matcher matcher = pattern.matcher(password);

		if (matcher.matches()) {
			System.out.println("Password Accepted....");
			return transactions;
		}

		if (transactions.isEmpty())
			throw new TransactionException("No Transaction Yet ");

		throw new TransactionException("Password Not Accepted...");
	}

	@Override
	public Transaction getTransactionById(Integer id) throws TransactionException {

		List<Transaction> filterList = transactions.stream().filter(t -> t.getTransactionId() == id)
				.collect(Collectors.toList());

		if (filterList.isEmpty())
			throw new TransactionException("Transaction Not Found with Id " + id);

		return filterList.get(0);

	}

}

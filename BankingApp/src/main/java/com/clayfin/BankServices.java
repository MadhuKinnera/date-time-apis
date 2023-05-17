package com.clayfin;

import java.util.Set;

public interface BankServices {
	
	void doTransaction(int price);
	
	Set<Transaction> getAllTransactions(String password) throws TransactionException;
	
	Transaction getTransactionById(Integer id) throws TransactionException;
	
	
	

}

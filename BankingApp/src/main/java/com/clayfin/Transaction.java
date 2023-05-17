package com.clayfin;

import java.beans.Transient;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

public class Transaction {

	private Integer transactionId;
	private LocalDateTime timestamp;
	private Integer price;
	private Duration timeTaken;

	private Bank bank;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer transactionId, LocalDateTime timestamp, Integer price, Bank bank) {
		super();
		this.transactionId = transactionId;
		this.timestamp = timestamp;
		this.price = price;
		this.bank = bank;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bank, price, timestamp, transactionId);
	}

	public Duration getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Duration timeTaken) {
		this.timeTaken = timeTaken;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(bank, other.bank) && Objects.equals(price, other.price)
				&& Objects.equals(timestamp, other.timestamp) && Objects.equals(transactionId, other.transactionId);
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", timestamp=" + timestamp + ", price=" + price
				+ ", timeTaken=" + timeTaken + ", bank=" + bank + "]";
	}

	
}

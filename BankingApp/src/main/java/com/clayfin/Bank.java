package com.clayfin;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bank {

	private Integer bankId;
	private String bankName;
	private String _IFSC;
	private ZonedDateTime zonedDateTime;

	private Set<Transaction> transactions = new HashSet<>();

	public Bank() {
		// TODO Auto-generated constructor stub
	}

	public Bank(Integer bankId, String bankName, String _IFSC, ZonedDateTime zonedDateTime,
			Set<Transaction> transactions) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this._IFSC = _IFSC;
		this.zonedDateTime = zonedDateTime;
		this.transactions = transactions;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String get_IFSC() {
		return _IFSC;
	}

	public void set_IFSC(String _IFSC) {
		this._IFSC = _IFSC;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public ZonedDateTime getZonedDateTime() {
		return zonedDateTime;
	}

	public void setZonedDateTime(ZonedDateTime zonedDateTime) {
		this.zonedDateTime = zonedDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(_IFSC, bankId, bankName, transactions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(_IFSC, other._IFSC) && Objects.equals(bankId, other.bankId)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(transactions, other.transactions);
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", _IFSC=" + _IFSC + ", zonedDateTime="
				+ zonedDateTime ;
	}

	

}

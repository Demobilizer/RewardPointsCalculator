package com.example.technicalassesment.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction_Master")
public class TransactionEntity {
	
	@Id
	@GeneratedValue
	private int transactionId;
	
	private int customerId;
	
	private String custName;
	
	private int spendDollar;
	
	private Date date;
	
	@PrePersist
	  protected void onCreate() {
	    date = new Date();
	  }
	
	
	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getSpendDollar() {
		return spendDollar;
	}

	public void setSpendDollar(int spendDollar) {
		this.spendDollar = spendDollar;
	}
	
	@Override
	public String toString() {
		return "CustomerEntity [transactionId=" + transactionId + ", customerId=" + customerId + ", custName="
				+ custName + ", spendDollar=" + spendDollar + ", date=" + date
				+ "]";
	}
	
}

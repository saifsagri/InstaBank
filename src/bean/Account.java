package bean;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {

	@Id
	private int accountNumber;
	
	private double accountBalance;
	private Date dateOpened;
	private String accountType;
	

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="AccountBeneficiary", 
			joinColumns={@JoinColumn(name="accountNumber")},
			inverseJoinColumns={@JoinColumn(name="IntraBeneficiaryId")})
	private Set<IntraBeneficiary> intraBeneficiaries;
	
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="InterAccountBeneficiary", 
			joinColumns={@JoinColumn(name="accountNumber")},
			inverseJoinColumns={@JoinColumn(name="interBeneficiaryId")})
	private Set<InterBeneficiary> interbeneficiaries;
	
	@OrderBy("transactionDate desc")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Transaction> transactions;
	/*
	@JoinColumn(name="Account_id")*/
	
	
	public Account() {}
	public Account(int accountNumber, double accountBalance,Date dateOpened,String accountType) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.dateOpened = dateOpened;
	}
	
	
	public Set<IntraBeneficiary> getIntraBeneficiaries() {
		return intraBeneficiaries;
	}
	public void setIntraBeneficiaries(Set<IntraBeneficiary> intraBeneficiaries) {
		this.intraBeneficiaries = intraBeneficiaries;
	}
	public Set<InterBeneficiary> getInterbeneficiaries() {
		return interbeneficiaries;
	}
	public void setInterbeneficiaries(Set<InterBeneficiary> interbeneficiaries) {
		this.interbeneficiaries = interbeneficiaries;
	}	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
}

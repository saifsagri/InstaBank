package repository;

import bean.Account;
import bean.OtherBank;

public interface TransferRepository {

	Account getAccount(int payeeAccountNumber);

	Account withdraw(Account acc, double amt);

	Account deposit(Account acc, double amt);

	void merge(Account a);

	void addNewTransaction(Account a, double amt, String transType, String desc, int acc);

	OtherBank deposit(OtherBank payee, double amt);

	void merge(OtherBank p2);

	//void addNewTransaction(OtherBank payee, double amt, String transType, String stringCredit, int accountNumber);
	
	
	
	
}

package repository;

import java.util.Set;

import org.junit.Test;

import basedao.BaseDao;
import bean.Account;
import bean.OtherBank;
import bean.Transaction;

public class TransferRepositoryImpl implements TransferRepository{

	

	@Override
	public Account getAccount(int accountNumber) {
		BaseDao dao = new BaseDao();
		Account a = dao.find(Account.class,accountNumber);
		return a;
	}
	
	@Override
	public Account withdraw(Account acc,double amt)
	{
		
			System.out.println("withdraw started");
			double currentBalance = acc.getAccountBalance();
			double newBalance = currentBalance - amt;
			acc.setAccountBalance(newBalance);
			System.out.println("Withdraw Complete");
			return acc;		
	}
	
	@Override
	public Account deposit(Account acc ,double amt)
	{
			System.out.println("deposit started");
			double currentBalance = acc.getAccountBalance();
			double newBalance = currentBalance + amt;
			acc.setAccountBalance(newBalance);
			System.out.println("deposit Complete");
			return acc;
	}
	
	@Override
	public void merge(Account a)
	{
		BaseDao dao = new BaseDao();
		dao.merge(a);
		
	}
	

	@Test
	public void validate()
	{
		BaseDao dao = new BaseDao();
		Account a1 = dao.find(Account.class,21341836);
		Account a2 = dao.find(Account.class,67851245);
		Account a3 = withdraw(a1,2000);
		Account a4 = deposit(a2,2000);
		dao.merge(a3);
		dao.merge(a4);/*
		Transaction t = new Transaction();
		t.setAmount(2000);
		t.setTransAccount(a4.getAccountNumber());
		t.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
		t.setTransName("sample name");
		t.setDescription("");*/	
	}
	
	@Override
	public void addNewTransaction(Account a,double amt,String transType,String desc,int acc)
	{
		Set<Transaction> ts = a.getTransactions();
		BaseDao dao = new BaseDao();
		Transaction t = new Transaction();
		t.setAmount(amt);
		t.setDescription(desc);
		t.setTransAccount(acc);
		t.setTransactionDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		t.setTransName(transType);
		t.setAccount(a);
		ts.add(t);
		a.setTransactions(ts);
		dao.merge(a);
		//dao.merge(t);
	}

	@Override
	public OtherBank deposit(OtherBank payee, double amt) {
		System.out.println("deposit started");
		double currentBalance = payee.getAccountBalance();
		double newBalance = currentBalance + amt;
		payee.setAccountBalance(newBalance);
		System.out.println("deposit Complete");
		return payee;
	}

	@Override
	public void merge(OtherBank ob) {
		BaseDao dao = new BaseDao();
		dao.merge(ob);
		
	}

	
	
	/*public void createNewTransaction(double amt,String transType,String desc,int acc)
	{
		BaseDao dao = new BaseDao();
		Transaction t = new Transaction();
		t.setAmount(amt);
		t.setDescription(desc);
		t.setTransAccount(acc);
		t.setTransactionDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		t.setTransName(transType);
		dao.persist(t);		
	}
	*/
	

}

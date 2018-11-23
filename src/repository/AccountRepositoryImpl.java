package repository;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import basedao.BaseDao;
import bean.Account;
import bean.Branch;
import bean.Customer;

public class AccountRepositoryImpl implements AccountRepository {
	
	
	public Set<Account> getAllAccounts(Customer c)
	{
		Set<Account> set = c.getAccounts();
		return set;
	}

	@Override
	public Account getAcc(int accId) {
		
		BaseDao dao = new BaseDao();
		
		Account a = dao.find(Account.class,accId);
		return a;
	}
	
	@Override
	public Set<Account>	getAllAccountsFromBranch(int bid)
	{
		BaseDao dao = new BaseDao();
    
		Branch b = dao.find(Branch.class,bid);
		
		
		Set<Account> acc = b.getAccounts();
		Iterator<Account> iter =  acc.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getAccountNumber());
		}
		
		
		return acc;
	}
}

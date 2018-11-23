package repository;
import java.util.Set;


import bean.Account;
import bean.Customer;


public interface AccountRepository {

	public Set<Account> getAllAccounts(Customer c);

	public Account getAcc(int accId);

	Set<Account> getAllAccountsFromBranch(int bid);
	
}

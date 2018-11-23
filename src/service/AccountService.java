package service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Account;
import bean.Customer;
import repository.AccountRepository;
import repository.ManageUser;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accrepo;
	
	public Set<Account> getAll(Customer c)
	{
		Set<Account> set = accrepo.getAllAccounts(c);
		return set;
	}
	
	public Account getAccount(int accId)
	{
		Account a = accrepo.getAcc(accId);
		return a;
	}
}

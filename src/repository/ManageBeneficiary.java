package repository;

import java.util.List;

import bean.Account;
import bean.IntraBeneficiary;

public interface ManageBeneficiary {

	public List<IntraBeneficiary> getAll();
	
	public void addBene(IntraBeneficiary be,Account currentAccount);

	public String checkBranch(IntraBeneficiary be, Account Payer);

	public boolean checkName(IntraBeneficiary be);

	public boolean checkBranchExists(IntraBeneficiary be);
}
 
package test;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//import org.hibernate.Query;
import org.junit.Test;



import basedao.BaseDao;
import bean.Account;
import bean.IntraBeneficiary;
import bean.Transaction;

public class BeneficiaryTest {
	
	BeneficiaryTest(int accNo, String desc){
		
	}

	@Test
	public void testCase2() {		//view all
		BaseDao dao = new BaseDao();
		Account a = (Account) dao.find(Account.class, 1010);
		Set<IntraBeneficiary> set = a.getIntraBeneficiaries();
		Iterator<IntraBeneficiary> iter = set.iterator();
		while(iter.hasNext())
		{
			IntraBeneficiary i = iter.next();
			System.out.println(""+i.getBeneficiaryName());
		}
		
	}
	
	@Test
	public void testCase3(){		//add bene
		BaseDao dao = new BaseDao();
		
		IntraBeneficiary ib = new IntraBeneficiary();
		ib.setIntraBeneficiaryId(1);
		ib.setBenAccountId(101);
		ib.setIfsc("IFSC101");
		//ib.setTransferLimit(100000);
		ib.setBeneficiaryName("Jane");
		dao.persist(ib);
		
	}
	
	@Test
	public void testCase4() 			//add benefciary to existing acccount
	{
		BaseDao dao = new BaseDao();
		
		Account a = (Account) dao.find(Account.class, 1010);
		Set<IntraBeneficiary> sib = a.getIntraBeneficiaries();
		IntraBeneficiary ib = dao.find(IntraBeneficiary.class, 1);
		sib.add(ib);
		dao.merge(a);
		
	}
	
	@Test
	public void testCase5()				//delete beneficiary 
	{
		BaseDao dao = new BaseDao();
		
		Account a = (Account) dao.find(Account.class, 1010);
		Set<IntraBeneficiary> sib = a.getIntraBeneficiaries();
		IntraBeneficiary ib = dao.find(IntraBeneficiary.class, 1);
		sib.remove(ib);
	}
	
	@Test
	public void testCase6() 				//modify beneficiary
	{
		BaseDao dao = new BaseDao();
		
		Account a = (Account) dao.find(Account.class, 1010);
		Set<IntraBeneficiary> sib = a.getIntraBeneficiaries();
		IntraBeneficiary ib = dao.find(IntraBeneficiary.class, 1);
		//ib.setTransferLimit(500000);
		ib.setBeneficiaryName("Jany");
		dao.merge(ib);
	}

	@Test
	public void testCase7(Account payer, Account payee, double amt, String desc) 		//set transactions 
	{		
		BaseDao dao = new BaseDao();
		Transaction t = new Transaction();
		t.setAmount(amt);
		t.setDescription(desc);
		t.setTransAccount(payee.getAccountNumber());
		//t.setTransactionDate();
		//t.setTransName();
		String sql = "select customer_name from customers where customer_id = Accounts.customer_id";
		
	}
	
	
}

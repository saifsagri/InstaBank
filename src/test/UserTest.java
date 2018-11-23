package test;




import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import basedao.BaseDao;

import bean.Account;
import bean.Address;
import bean.IntraBeneficiary;
import bean.OtherBank;
import bean.Branch;
import bean.Customer;
import bean.InterBeneficiary;
import bean.RegisterBean;
import bean.Transaction;

public class UserTest {

	
	@Test
	public void testcase1()				//testcase1 registering user
	{
		System.out.println("testcase1 started...");
		RegisterBean r = new RegisterBean();
		
	
		
		System.out.println("testcase1 started..."+r);
		//r.setApplication_no(1);
		r.setApplicant_name("Ashwini");
		r.setPhone("9969107681");
		r.setAadhar("349720846459");
		//r.setDob(new java.sql.Date(new java.util.Date().getTime()));
		r.setEmail("ashwini@gmail.com");
		r.setPancard("AFSGJ1234G");
		r.setGender("F");		
		BaseDao dao = new BaseDao();
		dao.persist(r);
	}
	
	@Test
	public void testcase7()				//testcase7 add registered user to branch
	{
		BaseDao dao = new BaseDao();
		Branch b = new Branch();
		b = dao.find(Branch.class, 21);
		Set<RegisterBean> register = new HashSet<RegisterBean>();
		RegisterBean r = dao.find(RegisterBean.class,41);
		register.add(r);
		//b.setRegistered_users(register);
		dao.merge(b);
	}
	
	
	@Test
	public void testcase2()					//Create Branch
	{
		Branch b = new Branch();
		//b.setBranchid(1);
		b.setBranchName("Powai");
		b.setBranchPhone("25577637");
		b.setIfsc("INS0019830");
		
		Address a = new Address();
		a.setCity("Mumbai");
		a.setStreet_address("Powai Road");
		a.setState("Maharashtra");
		a.setCountry("India");
		a.setZipcode("400178");
		b.setAddress(a);
		BaseDao dao = new BaseDao();
		dao.persist(b);
		
		//Set<Account> accounts = new HashSet<Account>();
		//accounts.add(new Account("67851245",40000,new java.sql.Date(new java.util.Date().getTime()),"Savings"));
		//accounts.add(new Account("89765465",2000,new java.sql.Date(new java.util.Date().getTime()),"Current"));
		//sb.setAccounts(accounts);
	}
	
	@Test
	public void addAccountToBranch()
	{
		BaseDao dao = new BaseDao();
		Branch b = dao.find(Branch.class, 121);
		
		Set<Account> accounts = b.getAccounts();
		//Set<Account> accounts = new HashSet<Account>();
		Account a = dao.find(Account.class,89765465);
		accounts.add(a);
		b.setAccounts(accounts);
		dao.merge(b);

	}
	
	@Test
	public void testcase3()					//Create account
	{
		Account a = new Account();
		a.setAccountNumber(21341836);
		a.setAccountBalance(50000);
		a.setDateOpened(new java.sql.Date(new java.util.Date().getTime()));
		a.setAccountType("Savings");
		BaseDao dao = new BaseDao();
		dao.persist(a);
	}
	
	
	@Test
	public void testcase4()					//create customer
	{
		Customer c = new Customer();
		//c.setCustomer_id(1);
		c.setCustomer_name("Ashwini Patil");
		c.setDob(new java.sql.Date(new java.util.Date().getTime()));
		c.setEmail("ashwini@gmail.com");
		c.setPhone("9969232385");
		c.setAadhar("234234543567");
		c.setPancard("asdff4567y");
		
		c.setPassword("ashwini@123");
		c.setGender("F");
		Address a = new Address();
		a.setStreet_address("sion trombay road");
		a.setCity("Mumbai");
		a.setState("Maharashtra");
		a.setCountry("India");
		a.setZipcode("400088");
		c.setAddress(a);
		
		
		BaseDao dao = new BaseDao();
	   dao.persist(c);
	}
	
	@Test
	public void testcase5()					//adding account to existing customer
	{
			BaseDao dao = new BaseDao();
			
			Customer c = dao.find(Customer.class, 21);
			Account a = dao.find(Account.class,21341836);
			
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(a);
			c.setAccounts(accounts);		
			
			//Set<Account> accounts = new HashSet<Account>();
			//accounts.add(new Account(67851245,40000,new java.sql.Date(new java.util.Date().getTime()),"Savings"));
			//accounts.add(new Account(89765465,2000,new java.sql.Date(new java.util.Date().getTime()),"Current"));
			//c.setAccounts(accounts);
			dao.merge(c);
		
	}
	
	
	@Test
	public void testcase6()					//add beneficiary	Intrabank
	{
		BaseDao dao = new BaseDao();

		IntraBeneficiary b = new IntraBeneficiary();
	/*	b.setBeneficiaryName("Ashwini Patil");
		b.setIfsc("INS0019826");
		b.setTransferLimit(20000);
		b.setBenAccountId(21341836);*/
		b = dao.find(IntraBeneficiary.class,41);
		Account a = new Account();
		Set<Account> accounts = new HashSet<Account>();
		//Set<IntraBeneficiary> bens = new HashSet<IntraBeneficiary>();
		a = dao.find(Account.class,21341836);
		accounts.add(a);
		//a.setIntraBeneficiaries(bens);
		b.setAccounts(accounts);
		dao.merge(b);
		//dao.merge(a);
		
		
	}
	

	@Test
	public void testcase8()					//add beneficiary	InterBank
	{
		BaseDao dao = new BaseDao();

		InterBeneficiary b = new InterBeneficiary();
		b.setBeneficiaryName("Priya Bharambhe");
		b.setIfsc("SBI000055");
		//b.setTransferLimit(2000);
		dao.persist(b);
	}
	
	
	@Test
	public void testcase12()
	{
		BaseDao dao = new BaseDao();
		InterBeneficiary b = dao.find(InterBeneficiary.class,41);
		Account a = dao.find(Account.class,67851245);
		
		Set<Account> accounts = new HashSet<Account>();
		Set<InterBeneficiary> bens = new HashSet<InterBeneficiary>();
	
		accounts.add(a);
		bens.add(b);
		
		b.setAccounts(accounts);
		a.setInterbeneficiaries(bens);
		
		dao.merge(a);
		dao.merge(b);
	}
	
	@Test
	public void testcase9()						//create otherbank account
	{
		BaseDao dao = new BaseDao();
		OtherBank ob = new OtherBank();
		ob.setAccName("Priya Bharambhe");
		ob.setOtherBankAccid(96783254);
		ob.setIfsc("SBI000055");
		ob.setAccountBalance(20000);
		dao.persist(ob);
	}
	
	 
	@Test
	public void testcase10()				//transaction
	{
		BaseDao dao = new BaseDao();
		Transaction t = new Transaction();
		t.setTransAccount(12345678);
		t.setAmount(200);
		t.setTransactionDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		t.setTransName("Asif");
		t.setDescription("User transferred 200 to Asif");
		dao.persist(t);
		//t.setTransAccount();
	}
	
	@Test
	public void testcase11()				//add transaction to account
	{
		BaseDao dao = new BaseDao();
		Transaction t = new Transaction();
		t = dao.find(Transaction.class,21);
		Account a = dao.find(Account.class,67851245);
		Set<Transaction> ts = new HashSet<Transaction>();
		ts.add(t);
		a.setTransactions(ts);
		dao.merge(a);
		
	}
	
	
	@Test
	public void testcase13()				//add transaction to account
	{
		BaseDao dao = new BaseDao();
		Branch b = dao.find(Branch.class,22);
		
		
		Set<Account> a = b.getAccounts();
		//a.setTransactions(ts);
		Iterator<Account> iter =  a.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getAccountNumber());
		}
		
	}
	
	
	@Test
	public void testcase14()
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "INSTA-JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager();
	    int a = 67851245;
	    Query query1 =entitymanager.createNativeQuery("select branch_id from accounts where accountNumber= :no").setParameter("no", a);
	    //entitymanager.createQuery("Select accountType from Account where accountNumber = :no").setParameter("no", a); 
	    //entitymanager.createNativeQuery("select accountType from accounts where accountNumber= :no",Account.class).setParameter("no", a);
	    java.math.BigDecimal result1 =  (java.math.BigDecimal)query1.getSingleResult();
	    int id=result1.intValueExact();
	    System.out.println(" "+result1+" "+id);
	    
	   //Set<Account> branchAccounts = dao.getAllAccountsFromBranch(id);
	}
	
	@Test
	public void testcase15()
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "INSTA-JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager();
	    int a = 67851245;
	    Query query1 =entitymanager.createNativeQuery("insert into select branch_id from accounts where accountNumber= :no").setParameter("no", a);
	    //entitymanager.createQuery("Select accountType from Account where accountNumber = :no").setParameter("no", a); 
	    //entitymanager.createNativeQuery("select accountType from accounts where accountNumber= :no",Account.class).setParameter("no", a);
	    java.math.BigDecimal result1 =  (java.math.BigDecimal)query1.getSingleResult();
	    int id=result1.intValueExact();
	    System.out.println(" "+result1+" "+id);
	    
	}
	
	
	
}

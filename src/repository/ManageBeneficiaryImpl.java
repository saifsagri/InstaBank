package repository;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;


import basedao.BaseDao;
import bean.Account;
import bean.Branch;
import bean.Customer;
import bean.IntraBeneficiary;

public class ManageBeneficiaryImpl implements ManageBeneficiary  {

	@Test
	public void testCase2() {
		BaseDao dao = new BaseDao();
		List<IntraBeneficiary> list = dao.getAll("Beneficiary");
		System.out.println(list);
	}
	
	/*@Test
	@Override
	public List<IntraBeneficiary> getAll() {
		BaseDao dao = new BaseDao();
		List<IntraBeneficiary> list = dao.getAll("Beneficiary");
		System.out.println(list.get(1).getBeneficiaryName());
		return list;
	}
*/
	
	@Override
	public List<IntraBeneficiary> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBene(IntraBeneficiary be,Account currentAccount) {
		BaseDao dao = new BaseDao();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "INSTA-JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
	    Query query1 =entitymanager.createNativeQuery("select INTRABENEFICIARYID from beneficiary where BENACCOUNTID= :no").setParameter("no", be.getBenAccountId());
	    //entitymanager.createQuery("Select accountType from Account where accountNumber = :no").setParameter("no", a); 
	    //entitymanager.createNativeQuery("select accountType from accounts where accountNumber= :no",Account.class).setParameter("no", a);
	    Set<IntraBeneficiary> sib=null; 
	    
	    try {
	    	 
	    if(query1.getSingleResult()!=null)
	    {
	    	sib = currentAccount.getIntraBeneficiaries();
	    	java.math.BigDecimal result1 =  (java.math.BigDecimal)query1.getSingleResult();
	    	int id=result1.intValueExact();
	    	System.out.println(" "+result1+" "+id);
			
			IntraBeneficiary ib = dao.find(IntraBeneficiary.class, id);
			//System.out.println(ib.getBeneficiaryName());
			/*if(ib!=null)
			{
*/				sib.add(ib);
				currentAccount.setIntraBeneficiaries(sib);
				dao.merge(currentAccount);
				return;
			//}
				
	    }
	    }
	    catch(Exception e)
	    {
	    	  Set<IntraBeneficiary> si=new HashSet<IntraBeneficiary>(); 
	    	si.add(be);
			currentAccount.setIntraBeneficiaries(si);
			dao.merge(currentAccount);
	    }
			
				    
	}
	

	
	

	@Override
	public String checkBranch(IntraBeneficiary be,Account Payer)
	{
		String f=null;
		BaseDao dao = new BaseDao();
		
		
		Account beneficiary = dao.find(Account.class,be.getBenAccountId());
		
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "INSTA-JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
	    Query query = entitymanager.createNativeQuery("select branch_id from accounts where accountNumber= :no").setParameter("no", beneficiary.getAccountNumber());
	    java.math.BigDecimal result =  (java.math.BigDecimal)query.getSingleResult();
    	int id=result.intValueExact();
    	System.out.println(" "+result+" "+id);
    	
    	 Query query1 = entitymanager.createNativeQuery("select branch_id from accounts where accountNumber= :no").setParameter("no",Payer.getAccountNumber());
 	    java.math.BigDecimal result1 =  (java.math.BigDecimal)query.getSingleResult();
     	int id1=result.intValueExact();
     	System.out.println(" "+result1+" "+id1);
    	
     	if(id==id1)
    	{
    		f="same";
    	}
     	else
     	{
     		f="different";
     	}
    	return f;
    	
	}
	
	
	@Override
	public boolean checkBranchExists(IntraBeneficiary be)
	{
		boolean f=false;
		BaseDao dao = new BaseDao();
		
		Account beneficiary = dao.find(Account.class,be.getBenAccountId());
				
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "INSTA-JPA" );
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
	    Query query = entitymanager.createNativeQuery("select branch_id from accounts where accountNumber= :no").setParameter("no", beneficiary.getAccountNumber());
	    java.math.BigDecimal result =  (java.math.BigDecimal)query.getSingleResult();
    	int id=result.intValueExact();
    	System.out.println(" "+result+" "+id);
    	
    	Branch b = dao.find(Branch.class, id);
    	
     	if(b==null)
    	{
    		f=false;
    	}
     	else
     	{
     		f=true;
     	}
    	return f;
    	
	}

	@Override
	public boolean checkName(IntraBeneficiary be) {
		// TODO Auto-generated method stub
		return false;
	}

}

package service;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basedao.BaseDao;
import bean.Account;
import bean.Customer;
import bean.IntraBeneficiary;
import repository.AccountRepository;
import repository.ManageBeneficiary;

@Service
public class BeneficiaryService {

	@Autowired
	private ManageBeneficiary manageben;

	@Autowired
	private AccountRepository accrepo;

	public String checkBene(IntraBeneficiary be,Account currAcc) {
		
		BaseDao dao = new BaseDao();
		
		System.out.println(be.getBenAccountId());
		String benadded=""; 
		Account ben = accrepo.getAcc(be.getBenAccountId());
		if(ben!=null)
		{
			int i = 0;
			try {
				Set<IntraBeneficiary> set = currAcc.getIntraBeneficiaries();
				Iterator<IntraBeneficiary> iter =  set.iterator();
				
				while(iter.hasNext()) 
				{
					IntraBeneficiary ib = iter.next();
					System.out.println(ib.getBeneficiaryName());
					if( be.getBenAccountId() == ib.getBenAccountId()) {
						i=1;
						benadded="exists";
						break;
					}
				}
				if(i==0)
				{
					
					//if(ben.getAccountNumber())
					//Account ben = dao.find(Account.class,be.getBenAccountId());
					
					
					/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "INSTA-JPA" );
				    EntityManager entitymanager = emfactory.createEntityManager();
				    
				    Query query = entitymanager.createNativeQuery("select customer_id from accounts where accountNumber= :no").setParameter("no", ben.getAccountNumber());
				    java.math.BigDecimal result =  (java.math.BigDecimal)query.getSingleResult();
			    	int id=result.intValueExact();
			    	System.out.println(" "+result+" "+id);
					*/
			    	
			    	//Customer c = dao.find(Customer.class,result);
			    	//System.out.println(c.getCustomer_name());
				    /*Query query1 =entitymanager.createNativeQuery("select customer_name from customers where customer_id= :no").setParameter("no", be.result);
				    //entitymanager.createQuery("Select accountType from Account where accountNumber = :no").setParameter("no", a); 
				    //entitymanager.createNativeQuery("select accountType from accounts where accountNumber= :no",Account.class).setParameter("no", a);
				    Set<IntraBeneficiary> sib = currentAccount.getIntraBeneficiaries();
				    */
					//if(be.getBeneficiaryName().equals(c.getCustomer_name()) && be.getIfsc().equals(ben.get)))
					manageben.addBene(be,currAcc);
					benadded="added";
				}
			
			
			}
			catch(NullPointerException e)
			{
				manageben.addBene(be,currAcc);
				benadded="added";
				//benadded="NObeneficiary";
			}
			
		
		}
		else
		{
			benadded="doesnotexist";
		}
		return benadded;
	}

	public int deleteBen(Account a,int benacc) {
		
		BaseDao dao = new BaseDao();
		IntraBeneficiary ben = dao.find(IntraBeneficiary.class,benacc);
		Set<IntraBeneficiary> benset=a.getIntraBeneficiaries();
		Iterator<IntraBeneficiary> iter =  benset.iterator();
		int i=0;
		while(iter.hasNext()) 
		{
			
			IntraBeneficiary ib = iter.next();
			System.out.println(ib.getBeneficiaryName());
			if( ben.getBenAccountId() == ib.getBenAccountId()) 
			{
				i=1;
				iter.remove();
				break;
			}
		}
		a.setIntraBeneficiaries(benset);
		dao.merge(a);
		return i;
	}

	
	
}

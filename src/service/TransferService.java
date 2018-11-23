package service;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Account;
import bean.OtherBank;
import bean.Transaction;
import repository.AccountRepository;
import repository.TransferRepository;

@Service
public class TransferService {

		@Autowired
		private TransferRepository transfer;
		
		@Autowired
		private AccountRepository accrepo;

		
		
		public Account validateTransfer(int payeeAccountNumber, double amt,Account payer)
		{
			Account payee=null;
			boolean itemExists=false;
			payee = transfer.getAccount(payeeAccountNumber);
			if(payee!=null)
			{
			
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "INSTA-JPA" );
				EntityManager entitymanager = emfactory.createEntityManager();
		  
				Query query1 =entitymanager.createNativeQuery("select branch_id from accounts where accountNumber= :no").setParameter("no", +payer.getAccountNumber());
		    //entitymanager.createQuery("Select accountType from Account where accountNumber = :no").setParameter("no", a); 
		    //entitymanager.createNativeQuery("select accountType from accounts where accountNumber= :no",Account.class).setParameter("no", a);
				java.math.BigDecimal result1 =  (java.math.BigDecimal)query1.getSingleResult();
				int id=result1.intValueExact();
				System.out.println(" "+result1+" "+id);
		    
/*			
		    Query query1 = entitymanager.createNativeQuery("select branch_id from accounts where accountnumber="+payer.getAccountNumber(),Account.class);
		    String result1 =  (String)query1.getSingleResult();
		    int id=Integer.parseInt(result1);
	*/
				Set<Account> branchAccounts = accrepo.getAllAccountsFromBranch(id);
		    
				Iterator<Account> iter =  branchAccounts.iterator();
		    //boolean itemExits=false;
				while(iter.hasNext())
				{
					Account setItem=iter.next();
					System.out.println(setItem.getAccountNumber());
					if(setItem.getAccountNumber()==payee.getAccountNumber())
					{
						itemExists=true;
					}
				}
			}
			else
			{
				return null;
			}
			if(itemExists)
				return payee;
			else return null;
			    
		    
		   /* 
		    if(payee!=null)
			{
				//if(payer.getAccountBalance()>=amt)
					return payee;
			}
			else 
			{
				System.out.println("account not found");
				//valid = false;
			}
			//System.out.println(""+valid);
*/			//return a1;
		}

		public boolean performFundTransfer(Account payee, double amt, Account payer) 
		{
			boolean transferFlag = false;
			Account p1 = transfer.withdraw(payer, amt);			//from
			Account p2 = transfer.deposit(payee, amt);			//to
			transfer.merge(p1);
			transfer.merge(p2);		
			String StringCredit="Credit from "+payer.getAccountNumber();
			String StringDedit="Debit to "+payee.getAccountNumber();
			
			transfer.addNewTransaction(payee,amt,"credit", StringCredit, payer.getAccountNumber());
			transfer.addNewTransaction(payer,amt,"debit", StringDedit, payee.getAccountNumber());
			
			transferFlag=true;
			return transferFlag;
		}

		public boolean performOtherBankTransfer(OtherBank payee, double amt, Account payer) {
			boolean transferFlag = false;
			Account p1 = transfer.withdraw(payer, amt);			//from
			OtherBank p2 = transfer.deposit(payee, amt);			//to
			transfer.merge(p1);
			transfer.merge(p2);		
			//String StringCredit="Credit from "+payer.getAccountNumber();
			String StringDebit="Debit to "+payee.getOtherBankAccid();
			
			//transfer.addNewTransaction(payee,amt,"credit", StringCredit, payer.getAccountNumber());
			transfer.addNewTransaction(payer,amt,"debit", StringDebit, payee.getOtherBankAccid());
			
			transferFlag=true;
			return transferFlag;
		}
		
		/*public boolean updateTransaction(Account payee, double amt, Account payer)
		{
			
		}*/
}

package controller;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Account;
import bean.Customer;
import bean.InterBeneficiary;
import bean.IntraBeneficiary;
import bean.Transaction;
import repository.ManageUser;
import service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@Autowired
	private ManageUser manageuser;
	
	@RequestMapping("/getall.accounts")
	public ModelAndView getAccounts(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		
		Customer c =(Customer) session.getAttribute("customerObject");
		Set<Account> accounts = service.getAll(c);
		
		
		mav.addObject("accounts", accounts);
		session.setAttribute("allAccounts", accounts);
		//mav.addObject("account", new Account());

		mav.setViewName("SelectAccount");
				
		return mav;
	}
	
	@RequestMapping("/selected.accounts")
	public ModelAndView selectedAccounts(String account,HttpSession session)
	{
		System.out.println("In selected accounts : "+account);
		ModelAndView mav = new ModelAndView();
		System.out.println(account);
		
		int accnumber = Integer.parseInt(account);
		Account payer = service.getAccount(accnumber);
		session.setAttribute("selectedAccountObject", payer);
		Set<Transaction> ts = payer.getTransactions();
		
		Iterator<Transaction> iter =  ts.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getDescription());
		}
		session.setAttribute("transactions", ts);
		
		
		Account a = (Account)session.getAttribute("selectedAccountObject");
		Set<IntraBeneficiary> intra =a.getIntraBeneficiaries();
		
		
		Iterator<IntraBeneficiary> ite =  intra.iterator();
		while(ite.hasNext())
		{
			System.out.println(ite.next().getBeneficiaryName());
		}
		session.setAttribute("intraBeneficiary", intra);
		//Customer c =(Customer) session.getAttribute("customerObject");
		//Set<Account> accounts = service.getAll(c);
		
		
		//mav.addObject("accounts", accounts);
		mav.setViewName("E-services3");
		//mav.setViewName("QuickTransfer");		
		return mav;
	}
	
	@RequestMapping("/fundTransferAccount.accounts")
	public ModelAndView selectedTransferAccount(String account,HttpSession session)
	{
		System.out.println("In selected accounts : "+account);
		ModelAndView mav = new ModelAndView();
		System.out.println(account);
		
		int accnumber = Integer.parseInt(account);
		Account payer = service.getAccount(accnumber);
		session.setAttribute("selectedAccountObject", payer);
		
		Set<IntraBeneficiary> intra =payer.getIntraBeneficiaries();
		
		
		Iterator<IntraBeneficiary> ite =  intra.iterator();
		while(ite.hasNext())
		{
			System.out.println(ite.next().getBeneficiaryName());
		}
		session.setAttribute("intraBeneficiary", intra);
		
		
		//Customer c =(Customer) session.getAttribute("customerObject");
		//Set<Account> accounts = service.getAll(c);
		
		
		//mav.addObject("accounts", accounts);
		//mav.setViewName("E-services3");
		
		
		Set<InterBeneficiary> interset =payer.getInterbeneficiaries();
		
		
		Iterator<InterBeneficiary> inter =  interset.iterator();
		while(ite.hasNext())
		{
			System.out.println(ite.next().getBeneficiaryName());
		}
		session.setAttribute("interBeneficiary", interset);
		
		mav.setViewName("fundtransfer");		
		return mav;
	}
	
	@RequestMapping("/showTransactions.accounts")
	public ModelAndView customerProfile(HttpSession session)
	{
		Account a = (Account)session.getAttribute("selectedAccountObject");
		System.out.println(a.getAccountNumber());
		ModelAndView mav = new ModelAndView();
		
		Set<Transaction> ts = a.getTransactions();
		
		Iterator<Transaction> iter =  ts.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getDescription());
		}
		session.setAttribute("transactions", ts);
		mav.setViewName("");
				
		return mav;
	}

}

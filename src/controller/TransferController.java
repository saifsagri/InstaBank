package controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import basedao.BaseDao;
import bean.Account;
import bean.Customer;
import bean.InterBeneficiary;
import bean.IntraBeneficiary;
import bean.LoginBean;
import bean.OtherBank;
import repository.AccountRepository;
import service.TransferService;
import service.UserService;

@Controller
public class TransferController {

	@Autowired
	private TransferService service;
	
	@Autowired
	private AccountRepository accrepo;
	
	@RequestMapping("/quicktransfer.transfer")
	public ModelAndView quickTransfer(String payeeAccountNumber,double amt, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Account payer=(Account)session.getAttribute("selectedAccountObject");
		System.out.println(payer.getAccountBalance());
		System.out.println(""+payeeAccountNumber+" "+amt+"");
		if(payer.getAccountBalance()<amt)
		{
			mav.addObject("invalid", "Amount Insufficient");
			mav.setViewName("QuickTransfer");
			return mav;
		}
		
		//Set<Account> accounts = (Account)session.getAttribute("customerObject");
		
		//Set<Account> accounts = c.getAccounts();
		
		//System.out.println(c.getCustomer_name());
		
		int payeeAccountNum = Integer.parseInt(payeeAccountNumber);
		
		
		Account payee = service.validateTransfer(payeeAccountNum,amt,payer);
		
		if(payee!=null) 
		{	
			if(service.performFundTransfer(payee,amt,payer))
			{
				//mav.addObject("", "Transaction Successful");
				mav.setViewName("fundsubmit");
			}
			
		} 
		else 
		{
			//session.setAttribute("loginObject",login );
			mav.addObject("invalid", "Account doesn't Exist");
			mav.setViewName("QuickTransfer");
		}
		return mav;
	}
	
	
	@RequestMapping("/intratransfer.transfer")
	public ModelAndView intratransfer(String IntraBeneficiary, double amt,HttpSession session) {
		
		BaseDao dao = new BaseDao();

		ModelAndView mav = new ModelAndView();
		System.out.println(IntraBeneficiary);
		
		int payeeid = Integer.parseInt(IntraBeneficiary);
		IntraBeneficiary b = (IntraBeneficiary)dao.find(IntraBeneficiary.class,payeeid);
		
 
		Account payee = (Account)dao.find(Account.class,b.getBenAccountId());
		
		System.out.println(""+payee.getAccountBalance());
		Account payer = (Account)session.getAttribute("selectedAccountObject");
		
		if(payer.getAccountBalance()<amt)
		{
			mav.addObject("invalid", "Amount Insufficient");
			mav.setViewName("intratransfer");
		}
		else
		{
			if(service.performFundTransfer(payee,amt,payer))
			{
				
				mav.setViewName("fundsubmit");
			}
		}
		
		return mav;
	}
	
	@RequestMapping("/intertransfer.transfer")
	public ModelAndView interTransfer(String InterBeneficiary, double amt,HttpSession session) {
		
		BaseDao dao = new BaseDao();
		ModelAndView mav = new ModelAndView();
		System.out.println("interbeneficiary"+InterBeneficiary);
		
		int payeeid = Integer.parseInt(InterBeneficiary);
		InterBeneficiary b = (InterBeneficiary)dao.find(InterBeneficiary.class,payeeid);
		
 
		OtherBank payee = (OtherBank)dao.find(OtherBank.class,b.getBenAccountId());
		
		System.out.println(""+payee.getAccountBalance());
		Account payer = (Account)session.getAttribute("selectedAccountObject");
		
		if(payer.getAccountBalance()<amt)
		{
			mav.addObject("invalid", "Amount Insufficient");
			mav.setViewName("intertransfer");
		}
		
		else
		{
			if(service.performOtherBankTransfer(payee,amt,payer))
				mav.setViewName("fundsubmit");
		}
		
		return mav;
	}
}

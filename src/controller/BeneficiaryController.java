package controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Account;
import bean.IntraBeneficiary;
import service.BeneficiaryService;

@Controller
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService benservice;
	
	@RequestMapping("/intradd.ben")
	public ModelAndView addBen(IntraBeneficiary be, HttpSession session) {
		

		ModelAndView mav = new ModelAndView();
		
		System.out.println(be.getBeneficiaryName());
	    Account currentAccount = (Account)session.getAttribute("selectedAccountObject");
		String f = benservice.checkBene(be,currentAccount);//remove a
		if(f.equals("added")) {
			System.out.println("added");
			mav.addObject("valid", "Bene added!Refresh the page to add new Beneficiary");
			mav.setViewName("intraadd");
			
		}
		else if(f.equals("exists")) {
			System.out.println("exists");
			mav.addObject("invalid", "Bene already exists");
			mav.setViewName("intraadd");
		}
		else if(f.equals("doesnotexist"))
		{
			System.out.println("notexists");
			mav.addObject("invalid", "Account does not exist in Instabank");
			mav.setViewName("intraadd");
		}
		/*else if(f.equals("nobranch"))
		{
			System.out.println("nobranch");
			mav.addObject("invalid", " such No branch");
			mav.setViewName("intraadd");
		}
		else if(f.equals("samebranch"))
		{
			System.out.println("samebranch");
			mav.addObject("invalid", "Account is of same branch. use QuickTransfer");
			mav.setViewName("intraadd");
		}*/
		return mav;
	}
	
	@RequestMapping("/delete.ben")
	public ModelAndView viewBen(String ben,HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		
		System.out.println(""+ben);
		int benacc = Integer.parseInt(ben);
		Account a = (Account)session.getAttribute("selectedAccountObject");
		int f=benservice.deleteBen(a,benacc);
		if(f==1) {
			System.out.println("deleted");
			mav.addObject("valid", "Beneficiary deleted!");
			mav.setViewName("intradeleteben");
			
		}
		else
		{
			System.out.println("not deleted");
			mav.addObject("Invalid", "Beneficiary not deleted!");
			mav.setViewName("intradeleteben");
		}
	    
		return mav;
	}
	
	
}

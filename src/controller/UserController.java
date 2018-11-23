package controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Account;
import bean.Customer;
import bean.ForgotBean;
import bean.LoginBean;
import bean.RegisterBean;
import service.AccountService;
import service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AccountService accservice;
	
	@RequestMapping("/login.do")
	public ModelAndView login(LoginBean login, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		Customer c = service.validate(login);
			
		
		if(c == null) {
			
			mav.addObject("invalid", "Invalid User ID/Password");
			mav.setViewName("login");
			
		} else {
			
			Set<Account> accounts = accservice.getAll(c);
			//mav.addObject("accounts", accounts);
			session.setAttribute("customerObject",c);
			session.setAttribute("allAccounts", accounts);
			//mav.addObject("customer", c);
			mav.setViewName("myprofile1");
			
		}
		
		return mav;
	}
	
	@RequestMapping("/register.do")
	public ModelAndView register(RegisterBean register, HttpSession session) {
		

		ModelAndView mav = new ModelAndView();
	
			if(service.addUser(register))
			{
				session.setAttribute("registerObject",register);
				mav.addObject("name", "YOU have registered.");
				mav.setViewName("regsuccess");
			}
			else
			{
				System.out.println("you are already registered/customer");
			}
			
		
		return mav;
	}
	
	@RequestMapping("/forgotpass.do")
	public ModelAndView checkforgot(ForgotBean forgot, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Customer c = service.checkUser(forgot);
		
		if(c!=null) {
			
			System.out.println("User found!");
			session.setAttribute("customerObject",c);
			mav.addObject("customer", "Adhar correct"+c.getCustomer_name());
			mav.setViewName("ChangePassword");
			
		}
		else {

			System.out.println("User not found!");
			mav.addObject("invalid", "Invalid Credentials! User does not exist!");
			mav.setViewName("forgotpass");
		}
			
		return mav;
	}
	
	@RequestMapping("/changePassword.do")
	public ModelAndView changePass(LoginBean l, HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		//session.getAttribute("customerObject");
		System.out.println(l.getLogin()+" "+l.getPassword());
		boolean f = service.changePassword(l);
		
		if(f) {
			
			System.out.println("Password Changed");
			mav.setViewName("AfterPasswordChange");
			
		}
		else {

			System.out.println("User not found!");
			mav.addObject("invalid", "Invalid Credentials! User does not exist!");
			mav.setViewName("forgotpass");
		}
			
		return mav;
	}
	
	
	@RequestMapping("/changeCredentials.do")
	public ModelAndView changeCredentials(String oldPassword, String newPassword,HttpSession session) 
	{
		ModelAndView mav = new ModelAndView();
		Customer cust = (Customer)session.getAttribute("customerObject");
		System.out.println(oldPassword+" "+newPassword);
		boolean f = service.changeCred(cust,oldPassword,newPassword);
		
		if(f) {
			
			System.out.println("Password Changed");
			mav.setViewName("AfterPasswordChange");
			
		}
		else {

			System.out.println("!");
			mav.addObject("invalid", "Your old Password doesn't match!Please check your password");
			mav.setViewName("changecredentials");
		}
			
		return mav;
	}
}

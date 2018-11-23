package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Customer;
import bean.ForgotBean;
import bean.LoginBean;
import bean.RegisterBean;
import repository.ManageUser;

@Service
public class UserService {
	
	@Autowired
	private ManageUser manageuser;
	
	public Customer validate(LoginBean login) {
		System.out.println("LoginService:validate()");
		Customer c=null;
		Customer User = manageuser.getUser(login);
		
		if(User!=null)
		{
			if(login.getLogin()==User.getCustomer_id() && login.getPassword().equals(User.getPassword()))
			{
				c=User;
			}
		}
		else
		{
			c=null;
		}
		
		return c;
	}
	
	
	
	public boolean addUser(RegisterBean r)
	{
		RegisterBean rb = new RegisterBean();
		//System.out.println(""+rb.getAddress().getCity());
		//rb.setDob(new java.sql.Date(r.getDob()));
		manageuser.registerUser(r);
		return true;
	}
	
	
	public Customer checkUser(ForgotBean forgot) {
		Customer user = manageuser.getUser(forgot);
		if(user==null)
		{
			System.out.println("not found");
			return null;
		}
		else
		{
			if(forgot.getUserid()==user.getCustomer_id() && forgot.getAadhar().equals(user.getAadhar()) && forgot.getEmail().equals(user.getEmail()))
				{
					System.out.println("found");
					return user;
				}
			else
			{
				System.out.println("not found");
				return null;
			}
		}
	}
	
	public boolean changePassword(LoginBean l)
	{
		Customer actualUser= manageuser.getUser(l);
		actualUser.setPassword(l.getPassword());
		System.out.println("Password set");
		manageuser.updatePassword(actualUser);
		//RegisterBean rb = new RegisterBean();
		//System.out.println(""+rb.getAddress().getCity());
		//rb.setDob(new java.sql.Date(r.getDob()));
		//manageuser.registerUser(r);
		return true;
	}
	
	public boolean changeCred(Customer c,String oldPass,String newPass)
	{
		boolean changePass=false;
		//Customer actualUser= manageuser.getUser(l);
		if(c.getPassword().equals(oldPass))
		{
			c.setPassword(newPass);
			manageuser.updatePassword(c);
			System.out.println("Password set");
			changePass=true;
		}
		else
		{
			System.out.println("Old pass does not match");
			changePass=false;
		}
		return changePass;
	}
}

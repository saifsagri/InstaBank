package repository;

import bean.Customer;
import bean.ForgotBean;
import bean.LoginBean;
import bean.RegisterBean;


public interface ManageUser {

	public Customer getUser(LoginBean x);
	public void registerUser(RegisterBean r);
	public Customer getUser(ForgotBean fb);
	boolean updatePassword(Customer c);
}

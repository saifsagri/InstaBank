package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import bean.Customer;
import bean.ForgotBean;
import bean.LoginBean;
import bean.RegisterBean;

@EnableTransactionManagement
public class ManageUserImpl implements ManageUser
{
	
	@PersistenceContext(unitName="INSTA-JPA")
	private EntityManager entityManager;

	@Override
	@Transactional
	public Customer getUser(LoginBean x) {
			System.out.println("LoginRepository: getUser(LoginBean x)...");
			Customer c = (Customer) entityManager.find(Customer.class,x.getLogin());
			return c;
	}
	
	@Override
	@Transactional
	public void registerUser(RegisterBean r) {
		System.out.println("Adding user..");
		entityManager.persist(r);
		System.out.println("user added");
		
	}

	@Override
	@Transactional
	public Customer getUser(ForgotBean fb) {
			System.out.println("UserRepository: getUser(ForgotBean x)...");
			Customer c = (Customer) entityManager.find(Customer.class,fb.getUserid());
			return c;
	}
	
	@Override
	@Transactional
	public boolean updatePassword(Customer c)
	{
		entityManager.merge(c);
		return true;
		
	}

}

package bean;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Branch")
public class Branch {
	
	@Id
	@GeneratedValue
	private int branchid;
	private String branchName;
	private String branchPhone;
	private String ifsc;
	
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="street_address",column=@Column(name="branch_street")),
			@AttributeOverride(name="city",column=@Column(name="branch_city")),
			@AttributeOverride(name="state",column=@Column(name="branch_state")),
			@AttributeOverride(name="country",column=@Column(name="branch_country")),
			@AttributeOverride(name="zipcode",column=@Column(name="branch_zipcode")),
		})
	private Address address;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="branch_id")
	private Set<Account> accounts;

	
	/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="branch_id")
	private Set<RegisterBean> registered_users;
	
	
	public Set<RegisterBean> getRegistered_users() {
		return registered_users;
	}

	public void setRegistered_users(Set<RegisterBean> registered_users) {
		this.registered_users = registered_users;
	}*/

	public int getBranchid() {
		return branchid;
	}
	
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchPhone() {
		return branchPhone;
	}

	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}

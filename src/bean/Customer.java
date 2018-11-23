package bean;

import java.sql.Date;
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
@Table(name="Customers")
public class Customer {

	/*customer_id number primary key,
	 customer_name varchar2(50),
	 gender varchar2(1),
	 email varchar2(50),
	 phone varchar2(20),
	 street_address varchar2(50),
	 city varchar2(20),
	 state varchar2(20),
	 country varchar2(20),
	 zipcode varchar2(10),
	 dob date,
	 aadhar varchar2(20),
	 pancard varchar2(20),
	 photo blob,
	 signature blob,
	 login varchar2(50),
	 password varchar2(50) */
	
	@Id
	@GeneratedValue
	private int customer_id;
	private String customer_name;
	private String gender;
	private String email;
	private String phone;
	private Date dob;
	private String aadhar;
	private String pancard;
	//private byte[] photo;
	//private byte[] signature;
	private String password;
	
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="street_address",column=@Column(name="cust_street")),
			@AttributeOverride(name="city",column=@Column(name="cust_city")),
			@AttributeOverride(name="state",column=@Column(name="cust_state")),
			@AttributeOverride(name="country",column=@Column(name="cust_country")),
			@AttributeOverride(name="zipcode",column=@Column(name="cust_zipcode")),
		})
	private Address address;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Set<Account> accounts;
	
	
	
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
/*
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}
*/
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

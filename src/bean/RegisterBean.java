package bean;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Registered")
public class RegisterBean {
	/*
	 * application_no number primary key,
 applicant_name varchar2(50),
 gender varchar2(1),
 email varchar2(50),
 phone varchar2(50),
 street_address varchar2(50),
 city varchar2(20),
 state varchar2(20),
 country varchar2(20),
 zipcode varchar2(10),
 branch int,
 dob date,
 aadhar varchar2(20),
 pancard varchar2(20),
 photo blob,
 signature blob
	 */

	@Id
	@GeneratedValue
	private int application_no;
	private String applicant_name;
	private String gender;
	private String email;
	private String phone;
	
	/*
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	*/private String aadhar;
	private String pancard;
	private String branch;
	private Date dob;
	//private byte[] photo;
	//private byte[] signature;
	
	@Embedded
	private Address address;
	
	public int getApplication_no() {
		return application_no;
	}

	public void setApplication_no(int application_no) {
		this.application_no = application_no;
	}

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
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

	/*public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
*/
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
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
}

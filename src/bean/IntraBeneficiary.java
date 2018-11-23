package bean;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Beneficiary")
public class IntraBeneficiary {

	@Id
	@GeneratedValue
	private int intraBeneficiaryId;
	private String beneficiaryName;
	private String ifsc;
	private int benAccountId;
	//private double transferLimit;
	
	/*@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="street_address",column=@Column(name="ben_street")),
			@AttributeOverride(name="city",column=@Column(name="ben_city")),
			@AttributeOverride(name="state",column=@Column(name="ben_state")),
			@AttributeOverride(name="country",column=@Column(name="ben_country")),
			@AttributeOverride(name="zipcode",column=@Column(name="ben_zipcode")),
		})
	private Address address;*/
	
	@ManyToMany
	@JoinTable(name="AccountBeneficiary", 
			joinColumns={@JoinColumn(name="IntraBeneficiaryId")},
			inverseJoinColumns={@JoinColumn(name="accountNumber")})
	private Set<Account> accounts;
	

	public int getIntraBeneficiaryId() {
		return intraBeneficiaryId;
	}

	public void setIntraBeneficiaryId(int intraBeneficiaryId) {
		this.intraBeneficiaryId = intraBeneficiaryId;
	}

	public int getBenAccountId() {
		return benAccountId;
	}

	public void setBenAccountId(int benAccountId) {
		this.benAccountId = benAccountId;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}


	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
/**/
	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	*/
	
}

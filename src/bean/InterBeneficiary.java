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
@Table(name="InterBeneficiary")
public class InterBeneficiary {
	
	@Id
	@GeneratedValue
	private int interBeneficiaryId;
	private String beneficiaryName;
	private int benAccountId;
	private String ifsc;
	//private double transferLimit;
	
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="street_address",column=@Column(name="iben_street")),
			@AttributeOverride(name="city",column=@Column(name="iben_city")),
			@AttributeOverride(name="state",column=@Column(name="iben_state")),
			@AttributeOverride(name="country",column=@Column(name="iben_country")),
			@AttributeOverride(name="zipcode",column=@Column(name="iben_zipcode")),
		})
	private Address address;
	
	@ManyToMany
	@JoinTable(name="InterAccountBeneficiary", 
			joinColumns={@JoinColumn(name="interBeneficiaryId")},
			inverseJoinColumns={@JoinColumn(name="accountNumber")})
	private Set<Account> accounts;

	public int getBenAccountId() {
		return benAccountId;
	}

	public void setBenAccountId(int benAccountId) {
		this.benAccountId = benAccountId;
	}

	public int getInterBeneficiaryId() {
		return interBeneficiaryId;
	}

	public void setInterBeneficiaryId(int interBeneficiaryId) {
		this.interBeneficiaryId = interBeneficiaryId;
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

	/*public double getTransferLimit() {
		return transferLimit;
	}

	public void setTransferLimit(double transferLimit) {
		this.transferLimit = transferLimit;
	}*/

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

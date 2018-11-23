package bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OtherBank")
public class OtherBank {

	@Id
	@GeneratedValue
	private int otherBankAccid;
	private String accName;
	private double accountBalance;
	private String ifsc;
	public int getOtherBankAccid() {
		return otherBankAccid;
	}
	public void setOtherBankAccid(int otherBankAccid) {
		this.otherBankAccid = otherBankAccid;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
}

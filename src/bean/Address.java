package bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
	private String street_address;
	
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		System.out.println("djg\n");
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		String str = "\nStreet Address:" + street_address + ","+ System.lineSeparator() + "City:" + city + ","+ System.lineSeparator() + "State:" + state + ","+ System.lineSeparator() + "Country:"
				+ country + ","+ System.lineSeparator() + "Zipcode:" + zipcode + "" ;
		return str;
	}
	


	
}
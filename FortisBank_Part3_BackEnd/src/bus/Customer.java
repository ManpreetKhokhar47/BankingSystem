package bus;

import java.io.Serializable;
import java.sql.SQLException;

import data.CustomerDB;


public class Customer implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identificationNumber;
	private String firstName;
	private String LastName;
	private String phoneNumber;
	private String address;
	private int sin;
	
	
	public Customer(int identificationNumber, String firstName,String lastName,String phoneNo ,String address,int sin)throws RaiseException {
		this.setIdentificationNumber(identificationNumber);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNo);
		this.setAddress(address);
		this.setSin(sin);
	}
	
	public Customer() {
		this.identificationNumber = 0;
		this.firstName = "Undefined";
		this.sin = 0;
		this.LastName = "Undefined";
		this.phoneNumber = "Undefined";
		this.address = "Undefined";
		
	}

	public int getIdentificationNumber() {
		return identificationNumber;
	}
	public int getSin() {
		return sin;
	}
	public String getFirstName() {
		return firstName;
	}
	
	
	public void setIdentificationNumber(int identificationNumber)throws RaiseException {
		Validator.isInRangeCustomerID(identificationNumber);
		this.identificationNumber = identificationNumber;
	}
	
	public void setFirstName(String name) throws RaiseException{
		Validator.isEmpty(name);
		Validator.isAlphabetic(name);
		this.firstName = name;
	}
	
	public void setSin(int sin)throws RaiseException {
		Validator.isEmpty(Integer.toString(sin));
		Validator.sinInRange(sin);
		this.sin = sin;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName)throws RaiseException {
		Validator.isAlphabetic(lastName);
		LastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws RaiseException{
		Validator.isValidPhoneNo(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address)  throws RaiseException{
		Validator.isEmpty(address);
		this.address = address;
	}
	
	public static int add(Customer element) throws SQLException {
		return CustomerDB.insertCustomer(element);
	}
	public static Customer search(int id) throws SQLException, NumberFormatException, RaiseException {
		return CustomerDB.searchCustomer(id);
	}
	public static int getCustomerId() throws SQLException, NumberFormatException, RaiseException {
		return CustomerDB.generateCustomerId();
	}

	@Override
	public String toString() {
		return "Customer [identificationNumber=" + identificationNumber + ", firstName=" + firstName + ", LastName="
				+ LastName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", sin=" + sin + "]";
	}

	
	
	
	

}

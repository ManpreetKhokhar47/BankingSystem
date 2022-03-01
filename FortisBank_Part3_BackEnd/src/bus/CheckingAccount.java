package bus;
import java.sql.SQLException;
import java.util.*;

import data.CheckingAccountDB;

public class CheckingAccount extends Account {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date openedDate;
	private double balance;
	private int numberOfTransactions;
	
	
	
	
	public CheckingAccount() {
		super();
		openedDate = new Date(0);
		balance = 0;
		numberOfTransactions = 0;
	}
	public CheckingAccount(Date openedDate, double balance, int numberOfTransactions, int accountNumber,int identificationNumber) throws RaiseException
	{
		super(accountNumber,identificationNumber);
		this.setOpenedDate(openedDate);
		this.setBalance(balance);
		this.setnumberOfTransactions(numberOfTransactions);
		
	}
	public Date getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance)throws RaiseException {
		Validator.isEmpty(Double.toString(balance));
		Validator.isDoublePositive(balance);
		this.balance = balance;
	}
	public int getnumberOfTransactions() {
		return numberOfTransactions;
	}
	public void setnumberOfTransactions(int numberOfTransactions) throws RaiseException{
		Validator.ValidTransCount(numberOfTransactions);
		this.numberOfTransactions = numberOfTransactions;
	}
	public static int add(CheckingAccount element) throws SQLException {
		return CheckingAccountDB.insertCheckingAccount(element);
	}
	public static int getAccountNo() throws SQLException , NumberFormatException{
		return CheckingAccountDB.generateAccountNumber();
	}
	public static CheckingAccount search(int id) throws SQLException, NumberFormatException, RaiseException {
		return CheckingAccountDB.searchCheackingAccount(id);
	}
	
	public static CheckingAccount searchByCustomerId(int id) throws SQLException, NumberFormatException, RaiseException {
		return CheckingAccountDB.searchCheByCustomerId(id);
	}
	
	
	
	
	
	public String toString() {
		return  super.toString() + "CheckingAccount [openedDate=" + openedDate + ", balance=" + balance + ", numberOfTransactions="
				+ numberOfTransactions + "]";
	}

	
	
	

}

package bus;
import java.sql.SQLException;
import java.util.*;

import data.TransactionDB;

public class Transaction {
	
	private int accountNo;
	private int transactionNumber;
	private String description;
	private Date transactionDate;
	private String transactionType;
	private double tranactionAmount;
	private double oldBal;
	private double newBal;
	
	public Transaction(int transactionNumber, String description, Date transactionDate,
			String transactionType, double tranactionAmount, int accNo,double oldBal, double newBal) {
		super();
		this.setTransactionNumber(transactionNumber);
		this.setDescription(description);
		this.setTransactionDate(transactionDate);
		this.setTransactionType(transactionType);
		this.setTranactionAmount(tranactionAmount);
		this.setAccountNo(accNo);
		this.setOldBal(oldBal);
		this.setNewBal(newBal);
	}

	public Transaction() {
		super();
		
		transactionNumber = 0;
		description = "Undefined";
		transactionDate = new Date();
		transactionType = "Undefined";
		tranactionAmount = 0;
		accountNo = 0;
		oldBal = 0;
		newBal = 0;

	}
	
	


	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTranactionAmount() {
		return tranactionAmount;
	}
	public void setTranactionAmount(double tranactionAmount) {
		this.tranactionAmount = tranactionAmount;
	}
	
	public void storeTransaction(int accNo, double amount)
	{
		System.out.println("Transaction details saved");
	}
	
	public double getOldBal() {
		return oldBal;
	}

	public void setOldBal(double oldBal) {
		this.oldBal = oldBal;
	}

	public double getNewBal() {
		return newBal;
	}

	public void setNewBal(double newBal) {
		this.newBal = newBal;
	}

	public static int add(Transaction element) throws SQLException {
		return TransactionDB.insertTransaction(element);
	}
	public static int getTransactionNo() throws SQLException,NumberFormatException {
		return TransactionDB.generateTransId();
	}
	
	public static ArrayList<Transaction> selectAll(int id) throws SQLException, RaiseException {
		return TransactionDB.getTransactionList(id);
	}
	

}

package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.CreditAccount;
import bus.RaiseException;

public class CreditAccountDB {
	static private Connection myConnection;
	static private String mySQLStatement = null;
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private CreditAccount creAc = null;

	// generate Account number
	public static int generateAccountNumber() throws NumberFormatException, SQLException {
		int tempAccNo = 0;
		myConnection = DBConnection.getConnection();

		mySQLQuery = "select max(accountno) from creditaccount";

		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		while (myResultSet.next()) {
			tempAccNo = myResultSet.getInt(1);
		}

		if (tempAccNo == 0) {
			tempAccNo = 7000;
		} else {
			tempAccNo++;
		}

		return tempAccNo;

	}

	// Insert Credit Account

	public static int insertCreditAccount(CreditAccount creditAccount) throws SQLException {
		myConnection = DBConnection.getConnection();
		mySQLStatement = "Insert into creditaccount(accountno,customerid,creditlimit,balance,openingdate)  values(?,?,?,?,?)";

		try {
			PreparedStatement newCreditAccount = myConnection.prepareStatement(mySQLStatement);

			newCreditAccount.setInt(1, creditAccount.getAccountNumber());
			newCreditAccount.setInt(2, creditAccount.getIdentificationNumber());
			newCreditAccount.setDouble(3, creditAccount.getCreditLimit());
			newCreditAccount.setDouble(4, creditAccount.getBalance());
			newCreditAccount.setDate(5, (Date) creditAccount.getOpenedDate());

			int rec = newCreditAccount.executeUpdate();
			myConnection.commit();

			if (rec > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// Account Search

	public static CreditAccount searchCreditAccount(int id) throws SQLException, RaiseException {
		creAc = null;
		myConnection = DBConnection.getConnection();

		mySQLQuery = "SELECT * FROM creditaccount WHERE  accountno = " + id;

		myStatemnt = myConnection.createStatement();

		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		if (myResultSet.next()) {
			creAc = new CreditAccount();
			creAc.setAccountNumber(myResultSet.getInt(1));
			creAc.setIdentificationNumber(myResultSet.getInt(2));
			creAc.setCreditLimit(myResultSet.getDouble(3));
			creAc.setBalance(myResultSet.getDouble(4));
			creAc.setOpenedDate(myResultSet.getDate(5));
		}

		return creAc;

	}

	// Delete Credit Account
	public static int deleteCreditAcc(int accno) throws SQLException {
		myConnection = DBConnection.getConnection();

		mySQLStatement = "Delete FROM creditaccount WHERE accountno = " + accno;

		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);

			myConnection.commit();

			if (rowAffected > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// Search By ID
	public static CreditAccount searchCreByCustomerId(int id) throws SQLException, RaiseException {
		myConnection = DBConnection.getConnection();

		mySQLQuery = "SELECT * FROM creditaccount WHERE  customerid = " + id;

		myStatemnt = myConnection.createStatement();

		myResultSet = myStatemnt.executeQuery(mySQLQuery);

		if (myResultSet.next()) {
			creAc = new CreditAccount();
			creAc.setAccountNumber(myResultSet.getInt(1));
			creAc.setIdentificationNumber(myResultSet.getInt(2));
			creAc.setCreditLimit(myResultSet.getDouble(3));
			creAc.setBalance(myResultSet.getDouble(4));
			creAc.setOpenedDate(myResultSet.getDate(5));
		}

		return creAc;

	}
	
	public static boolean withdraw(int accountNo, double balance) throws SQLException, RaiseException
	{
		boolean status = false;
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "update creditaccount set balance = ? where accountno = ?";
		
		try {
			
			PreparedStatement withdrawstmt = myConnection.prepareStatement(mySQLStatement);
			
			withdrawstmt.setDouble(1, balance);
			withdrawstmt.setInt(2, accountNo);
		
			int rec = withdrawstmt.executeUpdate();
			myConnection.commit();
				
			if(rec > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}
	
	public static boolean deposit(int accountNo, double balance) throws SQLException, RaiseException
	{
		boolean status = false;
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "update creditaccount set balance = ? where accountno = ?";
		
		try {
			
			PreparedStatement withdrawstmt = myConnection.prepareStatement(mySQLStatement);
			
			withdrawstmt.setDouble(1, balance);
			withdrawstmt.setInt(2, accountNo);
		
			int rec = withdrawstmt.executeUpdate();
			myConnection.commit();
				
			if(rec > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}


}

package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.RaiseException;
import bus.Transaction;

public class TransactionDB {
	
	static private Connection myConnection;
	static private String mySQLStatement = null;
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private Transaction Trans = null;
	
	public static int generateTransId() throws NumberFormatException, SQLException
	{
		int tempTransId = 0;
		myConnection = DBConnection.getConnection();
		mySQLQuery = "select max(transactionno) from transaction";
		myStatemnt = myConnection.createStatement();
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		while(myResultSet.next()) 
		{
			tempTransId = myResultSet.getInt(1);
		}
		if(tempTransId == 0)
		{
			tempTransId = 100000;
		}
		else
		{
			tempTransId++;
		}
		return tempTransId;
	
	}
	
	public static int insertTransaction(Transaction newTrans) throws SQLException  
	{
		myConnection = DBConnection.getConnection();		
		mySQLStatement = "Insert into transaction(transactionno,accountnumber,transactiontype,amount,description,transdate,oldbalance,newbalance) values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement newTransStmt = myConnection.prepareStatement(mySQLStatement);
			
			newTransStmt.setInt(1, newTrans.getTransactionNumber());
			newTransStmt.setInt(2, newTrans.getAccountNo());;
			newTransStmt.setString(3, newTrans.getTransactionType());
			newTransStmt.setDouble(4, newTrans.getTranactionAmount());
			newTransStmt.setString(5, newTrans.getDescription());
			newTransStmt.setDate(6, (Date) newTrans.getTransactionDate());
			newTransStmt.setDouble(7, newTrans.getOldBal());
			newTransStmt.setDouble(8, newTrans.getNewBal());
			
			int rec = newTransStmt.executeUpdate();
			myConnection.commit();
				
			if(rec > 0) {
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static ArrayList<Transaction> getTransactionList(int id) throws SQLException, RaiseException
	{
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		myConnection = DBConnection.getConnection();
		
		mySQLQuery = "SELECT * FROM transaction WHERE accountnumber = "+ id +" order by transactionno desc";
		
		myStatemnt = myConnection.createStatement();
		
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		//int r = myResultSet.getFetchSize();
		
		while(myResultSet.next()) {
			
			Trans = new Transaction();
			
			Trans.setTransactionNumber(myResultSet.getInt(1) );
			Trans.setAccountNo(myResultSet.getInt(2));
			Trans.setTransactionType(myResultSet.getString(3));
			Trans.setTranactionAmount(myResultSet.getDouble(4));
			Trans.setDescription(myResultSet.getString(5));
			Trans.setTransactionDate(myResultSet.getDate(6));
			Trans.setOldBal(myResultSet.getDouble(7));
			Trans.setNewBal(myResultSet.getDouble(8));
			
			transactionList.add(Trans);
		}	

		return transactionList;
	}
	

}

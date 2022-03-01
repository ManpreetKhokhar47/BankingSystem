package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.Customer;
import bus.RaiseException;

public class CustomerDB {
	
	static private Connection myConnection;
	static private String mySQLStatement = null;
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private Customer aCustomer = null;
	
	//Automatically generate Customer ID
	 	public static int generateCustomerId() throws NumberFormatException, SQLException
		{
			int tempCustId = 0;
			myConnection = DBConnection.getConnection();
			mySQLQuery = "select max(customerid) from customer";
			myStatemnt = myConnection.createStatement();
			myResultSet = myStatemnt.executeQuery(mySQLQuery);
			
			while(myResultSet.next()) 
			{
				tempCustId = myResultSet.getInt(1);
			}
			if(tempCustId == 0)
			{
				tempCustId = 1000;
			}
			else
			{
				tempCustId++;
			}
			return tempCustId;
		
		}
	
	
	// New Customer Add
		public static int insertCustomer(Customer aNewCustomer) throws SQLException  
		{
			myConnection = DBConnection.getConnection();		
			mySQLStatement = "Insert into customer(customerid,firstname,lastname,phoneno,sinno,address)  values(?,?,?,?,?,?)";
			try {
				PreparedStatement newCustomer = myConnection.prepareStatement(mySQLStatement);
				
				newCustomer.setInt(1, aNewCustomer.getIdentificationNumber());
				newCustomer.setString(2, aNewCustomer.getFirstName());
				newCustomer.setString(3, aNewCustomer.getLastName());
				newCustomer.setString(4, aNewCustomer.getPhoneNumber());
				newCustomer.setInt(5, aNewCustomer.getSin());
				newCustomer.setString(6, aNewCustomer.getAddress());
				
				int rec = newCustomer.executeUpdate();

		
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
		
		
		// Search Customer
		
		public static Customer searchCustomer(int id) throws SQLException, SQLException, NumberFormatException, RaiseException{
			
			myConnection = DBConnection.getConnection();
			
			mySQLQuery = "SELECT * FROM customer WHERE  customerid = " + id ;
			
			myStatemnt = myConnection.createStatement();
			
			myResultSet = myStatemnt.executeQuery(mySQLQuery);
			
			if(myResultSet.next()) {
				aCustomer = new Customer(myResultSet.getInt(1),myResultSet.getString(2) ,myResultSet.getString(3) ,myResultSet.getString(4) ,myResultSet.getString(6) ,(Integer.parseInt(myResultSet.getString(5))));                ///
			}		
			return aCustomer;
		}

}

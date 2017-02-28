package dao;

import java.sql.SQLException;

import javax.security.auth.login.AccountNotFoundException;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import beans.ResponseBean;
import util.DBConnectionManager;

public class CancelSubscriptionDaoImp implements CancelSubscriptionDao{


	@Override
	public Boolean checkExistingAccount(String uuid) {
Connection con =(Connection) DBConnectionManager.getConnection();
		
		String checkAccount = "SELECT * FROM account_info WHERE company_uuid = ? ";

        PreparedStatement preparedStmt1;
		try {
			preparedStmt1 = (PreparedStatement)con.prepareStatement(checkAccount);
			System.out.println("first executed");
			  preparedStmt1.setString(1, uuid);
			   ResultSet rs1 = (ResultSet) preparedStmt1.executeQuery();
			   System.out.println( "hello"+rs1);
			   while (rs1.next()) {
	                String accountIdentifier = rs1.getString("accountIdentifier");
			   if(accountIdentifier != null)
				   return false;		  
		} 	}
		   catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	}

	
	@Override
	public  void cancelSubcription(String accountIdentifier){
		try{
		   String query = "UPDATE account_info SET status = ? WHERE account_identifier = ?";
		      
		     	Connection con =(Connection) DBConnectionManager.getConnection();
	            PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
	            preparedStmt.setString(1,"CLOSED");
	            preparedStmt.setString(2,accountIdentifier);

	            preparedStmt.executeUpdate();
	            preparedStmt.close();
	       // con.close();
	    } 
				
		catch (SQLException e) {
	        System.err.println("Got an exception!");
	        System.err.println(e.getMessage());
	    } 
			
		}

	}


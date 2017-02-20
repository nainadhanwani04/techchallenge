package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import beans.ResponseBean;
import util.DBConnectionManager;

public class CancelSubscriptionDaoImp implements CancelSubscriptionDao{

	@Override
	public  void cancelSubcription(String uuid) {
		// TODO Auto-generated method stub
		try{
			if(uuid == null){
				System.out.println("Company does not exist");
			}
			else{
			String query = " delete from company_info where marketplace_uuid= ? ";
			    
			
		     	Connection con =(Connection) DBConnectionManager.getConnection();
				System.out.println(" Connection build ");
	            PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
	        
	         System.out.println("  build ");
	        
	    	
	     //   preparedStmt.setInt(1, user.getId());
	        
	        preparedStmt.setString(1,uuid);
	        
	        System.out.println("hello end");
	        
	        preparedStmt.executeUpdate();
	        preparedStmt.close();
	       // con.close();
	    } 
		}catch (SQLException e) {
	        System.err.println("Got an exception!");
	        System.err.println(e.getMessage());
	    } 
			
		}
	}


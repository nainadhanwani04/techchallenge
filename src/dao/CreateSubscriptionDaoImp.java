package dao;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.descriptor.JspConfigDescriptor;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import beans.ResponseBean;
import util.DBConnectionManager;
public class CreateSubscriptionDaoImp implements CreateSubscriptionDao {
	
	

	@Override
	public void marketplaceCreateSubscriptionDao(ResponseBean responseBean) {
		// TODO Auto-generated method stub
		
	try{
		 ResponseBean rBean = responseBean;
		String query = " insert into marketplace_info(uuid,email,base_url,partner,address) values (?,?,?,?,?)";
		 	Connection con =(Connection) DBConnectionManager.getConnection();
	     	System.out.println(con);
			System.out.println(" Connection build ");
            PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
        
             System.out.println("  build ");
        
    
     //   preparedStmt.setInt(1, user.getId());
        
        preparedStmt.setString(1,rBean.getCreator().getUuid());
        
        preparedStmt.setString(2,rBean.getCreator().getEmail());
        System.out.println("  build ");
        preparedStmt.setString(3,rBean.getMarketplace().getBaseUrl());
        
        preparedStmt.setString(4,rBean.getMarketplace().getPartner());
        
        preparedStmt.setString(5,rBean.getCreator().getAddress());
        
        System.out.println("hello end");
        
        preparedStmt.executeUpdate();
        preparedStmt.close();
    } catch (SQLException e) {
        System.err.println("Got an exception1");
        System.err.println(e.getMessage());
    } 
		
	}

	@Override
	public void companyCreateSubscriptionDao(ResponseBean responseBean) {
		// TODO Auto-generated method stub
		try{
			 ResponseBean rBean = responseBean;
			 Connection con =(Connection) DBConnectionManager.getConnection();
	       String query = " insert into company_info(uuid,email,name,phone_no,website,marketplace_uuid) values (?,?,?,?,?,?)";
	       PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
	            preparedStmt.setString(1,rBean.getPayload().getCompany().getUuid());
	        
	            preparedStmt.setString(2,rBean.getPayload().getCompany().getEmail());
	        
	            preparedStmt.setString(3,rBean.getPayload().getCompany().getName());
	        
	            preparedStmt.setString(4,rBean.getPayload().getCompany().getPhoneNumber());
	        
	            preparedStmt.setString(5,rBean.getPayload().getCompany().getWebsite());
	            
	            preparedStmt.setString(6,rBean.getCreator().getUuid());
	       
	            preparedStmt.executeUpdate();
	        //    con.close();

	             }   catch (SQLException e) {
	        System.err.println("Got an exception2");
	        System.err.println(e.getMessage());
	    } 
			
		
	}

	@Override
	public void accountCreateSubscriptionDao(ResponseBean responseBean) {
		// TODO Auto-generated method stub
try{
	        ResponseBean rBean = responseBean;

	     	Connection con =(Connection) DBConnectionManager.getConnection();
			
			String checkCompany = "SELECT * FROM company_info WHERE uuid = ? ";

            PreparedStatement preparedStmt1 = (PreparedStatement)con.prepareStatement(checkCompany);
			System.out.println("first executed");
			  preparedStmt1.setString(1, rBean.getPayload().getCompany().getUuid());
			   ResultSet rs1 = (ResultSet) preparedStmt1.executeQuery();
			  String checkApplication = "SELECT * FROM account_info WHERE application_uuid = ? ";
			
			    PreparedStatement preparedStmt2 = (PreparedStatement)con.prepareStatement(checkApplication);
			    System.out.println("first executed");
			    preparedStmt2.setString(1, rBean.getApplicationUuid());
	         
	            ResultSet rs2 = (ResultSet) preparedStmt2.executeQuery();
	           if(rs1 == null && rs2 == null){
	           	System.out.println("Account Already exist");
	          }
	           else{
	            	
	            String query = " insert into account_info(status,pricing_duration,addon_binding,notice,company_uuid,application_uuid) values (?,?,?,?,?,?)";
	           
	            PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
	            System.out.println("third executed");
	            if(rBean.getPayload().getAccount() == null){
	            	preparedStmt.setString(1,null);
	            }
	            else{
	           preparedStmt.setString(1,rBean.getPayload().getAccount().getStatus());
	            }
	            preparedStmt.setString(2,rBean.getPayload().getOrder().getPricingDuration());
	            if(rBean.getPayload().getNotice() == null){
	            	preparedStmt.setString(3,null);
	            }
	            else{
	            preparedStmt.setString(3,rBean.getPayload().getNotice().getType());
	            }
	            if(rBean.getPayload().getAddonInstance() == null){
	            	preparedStmt.setString(4,null);
	            }
	            else{
	            preparedStmt.setString(4,rBean.getPayload().getAddonInstance().getId());
	            }
	            preparedStmt.setString(5,rBean.getPayload().getCompany().getUuid());
	        
	            preparedStmt.setString(6,rBean.getApplicationUuid());
	       
	            preparedStmt.executeUpdate();
	         //   con.close();
	                 }
	             }   catch (SQLException e) {
	        System.err.println("Got an exception3");
	        System.err.println(e.getMessage());
	    } 
		
		
	}
}
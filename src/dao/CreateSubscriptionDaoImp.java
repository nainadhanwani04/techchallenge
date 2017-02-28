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
import domain.Account;
import domain.Company;
import domain.Order;
import domain.ProductPurchaser;
import util.DBConnectionManager;
public class CreateSubscriptionDaoImp implements CreateSubscriptionDao {
	
	@Override
	public Boolean checkExistingCompany(ResponseBean responseBean) {
		
		String checkCompany = "SELECT * FROM company_info WHERE uuid = ? ";
		Connection con =(Connection) DBConnectionManager.getConnection();
	 	System.out.println(con);
		System.out.println(" Connection build ");
		try {
			PreparedStatement preparedStmt1 = (PreparedStatement)con.prepareStatement(checkCompany);
			System.out.println("first executed");
			  preparedStmt1.setString(1, responseBean.getPayload().getCompany().getUuid());
			   ResultSet rs1 = (ResultSet) preparedStmt1.executeQuery();
			   System.out.println( "hello"+rs1);
			   while (rs1.next()) {
	                String companyUuid = rs1.getString("uuid");
			   
			   if(companyUuid != null)
				   return false;
		}
		} 
		
		   catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	}

	@Override
	public void productPurchaserDetails(ProductPurchaser productPurchaser) {
		// TODO Auto-generated method stub
		
	try{
		    String query = " insert into creator_info(uuid,email,base_url,partner,address) values (?,?,?,?,?)";
		 	Connection con =(Connection) DBConnectionManager.getConnection();
	     	System.out.println(con);
			System.out.println(" Connection build ");
            PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
        
             System.out.println("  build ");
        
        preparedStmt.setString(1,productPurchaser.getUuid());
        
        preparedStmt.setString(2,productPurchaser.getEmail());
        System.out.println("  build ");
        preparedStmt.setString(3,productPurchaser.getBaseUrl());
        
        preparedStmt.setString(4,productPurchaser.getPartner());
        
        preparedStmt.setString(5,productPurchaser.getAddress());
        
        System.out.println("hello end");
        
        preparedStmt.executeUpdate();
        preparedStmt.close();
    } catch (SQLException e) {
        System.err.println("Got an exception1");
        System.err.println(e.getMessage());
    } 
		
	}

	@Override
	public void companyDetails(Company company) {
		// TODO Auto-generated method stub
		try{

			 Connection con =(Connection) DBConnectionManager.getConnection();
	       String query = " insert into company_info(uuid,email,name,phone_no,website,marketplace_uuid) values (?,?,?,?,?,?)";
	       PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
	            preparedStmt.setString(1,company.getUuid());
	        
	            preparedStmt.setString(2,company.getEmail());
	        
	            preparedStmt.setString(3,company.getName());
	        
	            preparedStmt.setString(4,company.getPhone());
	        
	            preparedStmt.setString(5,company.getWebsite());
	            
	            preparedStmt.setString(6,company.getMarketplaceUuid());
	       
	            preparedStmt.executeUpdate();

	             }   catch (SQLException e) {
	        System.err.println("Got an exception2");
	        System.err.println(e.getMessage());
	    } 
			
		
	}
				@Override
				public void accountDetails(Account account) {
					// TODO Auto-generated method stub
					try{
					Connection con =(Connection) DBConnectionManager.getConnection();
					String query = " insert into account_info(account_identifier,status,company_uuid) values (?,?,?)";
			           
		            PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
		            preparedStmt.setString(1,account.getAccountIdentifier());
			        
		            preparedStmt.setString(2,account.getStatus());
		        
		            preparedStmt.setString(3,account.getCompanyUuid());
		            preparedStmt.executeUpdate();
			    
			                 }
			             catch (SQLException e) {
			        System.err.println("Got an exception3");
			        System.err.println(e.getMessage());
			    }
				}
		        
				

				@Override
				public void orderDetails(Order order) {
					  try{
							Connection con =(Connection) DBConnectionManager.getConnection();
				            String query = " insert into order_info(edition_code,pricing_duration,addon_offering_code,notice,unit,quantity,remaining_quantity,company_uuid) values (?,?,?,?,?,?,?,?)";
				           
				            PreparedStatement preparedStmt = (PreparedStatement)con.prepareStatement(query);
				       
				            preparedStmt.setString(1,order.getEditionCode());
	
				            preparedStmt.setString(2,order.getPricingDuration());
				       
				            preparedStmt.setString(3,order.getAddonOfferingCode());
				     
				            preparedStmt.setString(4,order.getNotice());
				            
				            preparedStmt.setString(5,order.getUnit());
				        
				            preparedStmt.setInt(6,order.getQuantity());
				            
				            preparedStmt.setInt(7,order.getRemainingStock());
				            
				            preparedStmt.setString(8,order.getCompanyUuid());
				       
				            preparedStmt.executeUpdate();
				         //   con.close();
			
				             }   
					    catch (SQLException e) {
				        System.err.println("Got an exception4");
				        System.err.println(e.getMessage());
				
					
				} 
		
		
	}

	
}
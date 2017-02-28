package services;

import beans.ResponseBean;
import util.ResponseCode;
import dao.CreateSubscriptionDaoImp;
import domain.Account;
import domain.Company;
import domain.Order;
import domain.ProductPurchaser;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import util.AccountAlreadyExists;
import util.Utility;

public class CreateSubscriptionServicesImp implements CreateSubscriptionServices{
	
	public ResponseCode CreateNotification(String eventUrl) throws AccountAlreadyExists
	{	
		ResponseCode responseCode = new ResponseCode();
	try {
		
		String jason = Utility.getJasonResponse(eventUrl);		
//		System.out.println(jason);
		
		ResponseBean responseBean = Utility.getBean(jason);

		
	//	System.out.println("Object"+responseBean);
		
		
		    CreateSubscriptionDaoImp createSubscriptionDaoImp = new CreateSubscriptionDaoImp();
			Boolean checkCompany= createSubscriptionDaoImp.checkExistingCompany(responseBean);
			System.out.println(checkCompany);
			if(checkCompany == true){
			    ProductPurchaser productPurchaser =  ProductPurchaser.createMarketplace(responseBean);
				Company company = Company.createCompany(responseBean);
				Account account =  Account.createAcccount(responseBean);
				Order order =Order.createOrder(responseBean);
				
				createSubscriptionDaoImp.productPurchaserDetails(productPurchaser);
				createSubscriptionDaoImp.companyDetails(company);
				createSubscriptionDaoImp.accountDetails(account);
				createSubscriptionDaoImp.orderDetails(order);
		
				responseCode.setAccountIdentifier(account.getAccountIdentifier());
				responseCode.setSuccess("true");
			
			}
			else{
				System.out.println("User defined error ");
				throw new AccountAlreadyExists("Account Already Exist for this company");
			}
		
	//	CreateNotification(responseBean);
	}
	    catch(AccountAlreadyExists account){
	    	
	    	System.out.println("User defined error caught");
	    
	         responseCode.setMessage(account.getMessage());
	     	System.out.print(responseCode.getMessage());
	         responseCode.setErrorCode("Account_Already_Exsits");
	     	System.out.print(responseCode.getErrorCode());
	         responseCode.setSuccess("false");
	      
	    }
	catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	System.out.println("about to send response");
	return responseCode;
	
	}

	
	
}

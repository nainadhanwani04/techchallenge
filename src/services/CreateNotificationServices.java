package services;

import beans.ResponseBean;
import dao.CreateSubscriptionDaoImp;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import util.TestUtility;

public class CreateNotificationServices {
	
	public void CreateNotification(String eventUrl)
	{
		System.out.println(eventUrl);
		
	
	try {
		
		String jason = TestUtility.getJasonResponse(eventUrl);
		
//		System.out.println(jason);
		
		ResponseBean responseBean = TestUtility.getBean(jason);
		
	//	System.out.println("Object"+responseBean);
		
		CreateSubscriptionDaoImp marketplaceCreateSubscriptionDaoImp = new CreateSubscriptionDaoImp();
		
		marketplaceCreateSubscriptionDaoImp.marketplaceCreateSubscriptionDao(responseBean);
		marketplaceCreateSubscriptionDaoImp.companyCreateSubscriptionDao(responseBean);
		marketplaceCreateSubscriptionDaoImp.accountCreateSubscriptionDao(responseBean);
		
	//	CreateNotification(responseBean);
		
	} 
	catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	
	}

	
	
}

package services;

import javax.security.auth.login.AccountNotFoundException;

import beans.ResponseBean;
import util.ResponseCode;
import dao.CancelSubscriptionDaoImp;
import domain.Account;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import util.AccountDoesNotExist;
import util.Utility;

public class CancelSubscriptionServicesImp implements CancelSubscriptionServices {

@Override
public ResponseCode cancelSubscription(String eventUrl)  throws AccountDoesNotExist  {
	// TODO Auto-generated method stub
	ResponseCode responseCode =  new ResponseCode();
    String jason="";
	try {
		jason = Utility.getJasonResponse(eventUrl);
		ResponseBean responseBean = Utility.getBean(jason);
		String checkExistingAccount = responseBean.getPayload().getAccount().getAccountIdentifier();
		CancelSubscriptionDaoImp cancelSubscriptionDaoImp = new CancelSubscriptionDaoImp();
		Boolean accountResult = cancelSubscriptionDaoImp.checkExistingAccount(checkExistingAccount);
		if(accountResult == true)
		{
            cancelSubscriptionDaoImp.cancelSubcription(checkExistingAccount);
            responseCode.setAccountIdentifier(responseBean.getPayload().getAccount().getAccountIdentifier());
			responseCode.setSuccess("true");
		
		}
		else{
			throw new AccountNotFoundException("The Account with "+checkExistingAccount +"doesnot exists");
		}
	}
	
	catch(AccountNotFoundException account){
		 responseCode.setMessage(account.getMessage());
         responseCode.setErrorCode("Account_Doesnot_Exsits");
         responseCode.setSuccess("false");
       
	}
	catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	    return responseCode;
}
	

}

package services;

import beans.ResponseBean;
import dao.CancelSubscriptionDaoImp;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import util.TestUtility;

public class CancelSubscriptionServicesImp implements CancelSubscriptionServices {

@Override
public void cancelSubscription(String eventUrl)  {
	// TODO Auto-generated method stub
    String jason="";
	try {
		jason = TestUtility.getJasonResponse(eventUrl);
	} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	ResponseBean responseBean = TestUtility.getBean(jason);
	String deleteCompanyUuid = responseBean.getCreator().getUuid();
	CancelSubscriptionDaoImp cancelSubscriptionDaoImp = new CancelSubscriptionDaoImp();
	cancelSubscriptionDaoImp.cancelSubcription(deleteCompanyUuid);
}
	

}

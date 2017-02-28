package services;

import javax.security.auth.login.AccountNotFoundException;

import util.ResponseCode;
import util.AccountDoesNotExist;

public interface CancelSubscriptionServices {
	
	
	public ResponseCode cancelSubscription(String eventUrl) throws AccountDoesNotExist;

}

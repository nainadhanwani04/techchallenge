package services;

import util.ResponseCode;
import util.AccountAlreadyExists;

public interface CreateSubscriptionServices {
	public ResponseCode CreateNotification(String eventUrl) throws AccountAlreadyExists;

}

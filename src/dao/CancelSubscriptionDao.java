package dao;

import beans.ResponseBean;

public interface CancelSubscriptionDao {
	
	public Boolean checkExistingAccount(String uuid);
	public void cancelSubcription(String uuid);

}

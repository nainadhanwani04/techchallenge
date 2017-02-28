package dao;

import beans.ResponseBean;
import domain.Account;
import domain.Company;
import domain.Order;
import domain.ProductPurchaser;

public interface CreateSubscriptionDao {
	public Boolean checkExistingCompany(ResponseBean responseBean);
	public void productPurchaserDetails(ProductPurchaser productPurchaser);
	public void companyDetails(Company company);
	public void accountDetails(Account account);
	public void orderDetails(Order order);

}

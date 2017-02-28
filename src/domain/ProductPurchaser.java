package domain;

import beans.ResponseBean;

public class ProductPurchaser {
	
	  private String uuid;
	  private String email;
	  private String baseUrl;
	  private String partner;
	  private String address;
	  
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static ProductPurchaser createMarketplace(ResponseBean responseBean){
	   ProductPurchaser purchaser = new ProductPurchaser();
	   
	   purchaser.setUuid(responseBean.getCreator().getUuid());
	   purchaser.setEmail(responseBean.getCreator().getEmail());
	   purchaser.setBaseUrl(responseBean.getMarketplace().getBaseUrl());
	   purchaser.setPartner(responseBean.getMarketplace().getPartner());
	   purchaser.setAddress( responseBean.getCreator().getAddress());
	   return purchaser;
	
	}
}

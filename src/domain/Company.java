package domain;

import beans.ResponseBean;

public class Company {
	
	  private String uuid;
	  private String email;
	  private String name;
	  private String phone;
	  private String website;
	  private String marketplaceUuid;
	  
	  
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMarketplaceUuid() {
		return marketplaceUuid;
	}

	public void setMarketplaceUuid(String marketplaceUuid) {
		this.marketplaceUuid = marketplaceUuid;
	}


	public static Company createCompany(ResponseBean responseBean){
		Company company =  new Company();
		company.setUuid(responseBean.getPayload().getCompany().getUuid());
		company.setEmail(responseBean.getPayload().getCompany().getEmail());
		company.setName(responseBean.getPayload().getCompany().getName());
		company.setPhone(responseBean.getPayload().getCompany().getPhoneNumber());
		company.setWebsite(responseBean.getPayload().getCompany().getWebsite());
		company.setMarketplaceUuid(responseBean.getCreator().getUuid());
		 return company;
	}
	
	
	

}

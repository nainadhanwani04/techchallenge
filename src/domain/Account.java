package domain;

public class Account {
	
	private String status;
	private String pricingEdition;
	private String addonBinding;
	private String notice;
	private String companyUuid;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPricingEdition() {
		return pricingEdition;
	}
	public void setPricingEdition(String pricingEdition) {
		this.pricingEdition = pricingEdition;
	}
	public String getAddonBinding() {
		return addonBinding;
	}
	public void setAddonBinding(String addonBinding) {
		this.addonBinding = addonBinding;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getCompanyUuid() {
		return companyUuid;
	}
	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

}

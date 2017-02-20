package beans;

import java.util.List;

public class Order {
	
	private String editionCode;
	private String addonOfferingCode;
	private String pricingDuration;
	private List<Item> items;
	private String[] customAttributes;
	public String getEditionCode() {
		return editionCode;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}
	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String[] getCustomAttributes() {
		return customAttributes;
	}
	public void setCustomAttributes(String[] customAttributes) {
		this.customAttributes = customAttributes;
	}

}

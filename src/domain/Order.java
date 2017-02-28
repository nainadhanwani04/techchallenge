package domain;

import java.util.ArrayList;
import java.util.List;

import beans.Item;
import beans.ResponseBean;

public class Order {
	  private String editionCode;
	  private String pricingDuration;
	  private String addonOfferingCode;
	  private String notice;
	  private String unit;
	  private int quantity;
	  private String companyUuid;
	  private int remainingStock;
	  
	
	public int getRemainingStock() {
		return remainingStock;
	}


	public void setRemainingStock(int remainingStock) {
		this.remainingStock = remainingStock;
	}


	public String getEditionCode() {
		return editionCode;
	}


	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}


	public String getPricingDuration() {
		return pricingDuration;
	}

	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}

	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String units) {
		this.unit = units;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCompanyUuid() {
		return companyUuid;
	}

	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

	public static Order createOrder(ResponseBean responseBean){
		Order order =  new Order();
	
		order.setEditionCode(responseBean.getPayload().getOrder().getEditionCode());
		order.setPricingDuration( responseBean.getPayload().getOrder().getPricingDuration());
		order.setAddonOfferingCode(responseBean.getPayload().getOrder().getAddonOfferingCode());
		order.setNotice(null);
		List<Item> items = new ArrayList<>();
	    items.addAll(responseBean.getPayload().getOrder().getItems());
		
		for(Item item:items){
			
		order.setQuantity(item.getQuantity());
		order.setUnit(item.getUnit());
		}
		order.setCompanyUuid(responseBean.getPayload().getCompany().getUuid());
        order.setRemainingStock(order.getQuantity()-1);		
		return order;
  
}
}

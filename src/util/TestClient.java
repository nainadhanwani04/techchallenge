package util;

import beans.ResponseBean;
import services.CreateNotificationServices;

public class TestClient {

	public static void main(String[] args) {
		String jason = "{\"type\":\"SUBSCRIPTION_ORDER\",\"marketplace\":{\"partner\":\"APPDIRECT\",\"baseUrl\":\"https://marketplace.appdirect.com\"},\"applicationUuid\":null,\"flag\":\"DEVELOPMENT\",\"creator\":{\"uuid\":\"60f9c3f8-3b8c-4a59-b6ce-e4cac8f0c75b\",\"openId\":\"https://marketplace.appdirect.com/openid/id/60f9c3f8-3b8c-4a59-b6ce-e4cac8f0c75b\",\"email\":\"naina.dhanwani+devloper@appdirect.com\",\"firstName\":\"Naina\",\"lastName\":\"Dhanwani\",\"language\":\"en\",\"locale\":\"en-US\",\"address\":null,\"attributes\":null},\"payload\":{\"user\":null,\"company\":{\"uuid\":\"b6a76d12-5d9c-4e2d-b21e-01dad0e4d828\",\"externalId\":null,\"name\":\"Appdirect\",\"email\":\"david.hadley@appdirect.com\",\"phoneNumber\":\"3104064298\",\"website\":\"appdirect.com\",\"country\":\"US\"},\"account\":null,\"addonInstance\":null,\"addonBinding\":null,\"order\":{\"editionCode\":\"RECURRING\",\"addonOfferingCode\":null,\"pricingDuration\":\"MONTHLY\",\"items\":[],\"customAttributes\":[]},\"notice\":null,\"configuration\":{}},\"returnUrl\":null,\"links\":[]}";
		ResponseBean responseBean = TestUtility.getBean(jason);
		System.out.println(responseBean);
	//	CreateNotificationServices createNotificationServices = new CreateNotificationServices();
	//	createNotificationServices.
		
	DBConnectionManager.getConnection();
	System.out.println("Done");
	}
}

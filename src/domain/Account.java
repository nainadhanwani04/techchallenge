package domain;

import beans.ResponseBean;

public class Account {
       private String accountIdentifier;
       private  String status;
       private String companyUuid;
       
	
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCompanyUuid() {
		return companyUuid;
	}
	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}
	public static Account createAcccount(ResponseBean responseBean){
		Account account = new Account();
		account.setAccountIdentifier(randomAlphaNumeric());
		account.setStatus("ACTIVE");
		account.setCompanyUuid(responseBean.getPayload().getCompany().getUuid());
	    return account;
	}
	
	static final String alphaNumericString = "abcdefghijklmnopqrstvuwxyz0123456789";
	static int count = 10;
    public static String randomAlphaNumeric() {	

    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
    int character = (int)(Math.random()*alphaNumericString.length());
    builder.append(alphaNumericString.charAt(character));

    }
return builder.toString();
}
}

  

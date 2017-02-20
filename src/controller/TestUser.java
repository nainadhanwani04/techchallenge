package controller;

import org.codehaus.jackson.annotate.JsonIgnore;

public class TestUser {
	private String accountIdentifier;
	private String success;
	public TestUser(){
		
	}
	public TestUser(String accountIdentifier,String success){
	this.accountIdentifier=accountIdentifier;
	this.success=success;

	}
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	
	public String getSuccess() {
		return success;
	}
	

}

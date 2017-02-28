package util;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ResponseCode {
	private String accountIdentifier;
	private String success;
	private String errorCode;
	private String message;
	public ResponseCode(){
		
	}
	public ResponseCode(String accountIdentifier,String success,String errorCode,String message){
		this.accountIdentifier=accountIdentifier;
		this.success=success;
		this.errorCode = errorCode;
		this.message= message;

		}
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}

	
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	
	
}

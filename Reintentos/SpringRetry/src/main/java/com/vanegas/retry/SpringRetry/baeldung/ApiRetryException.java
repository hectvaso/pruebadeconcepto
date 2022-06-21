package com.vanegas.retry.SpringRetry.baeldung;

public class ApiRetryException extends RuntimeException{

	
	public ApiRetryException(String message) {
        super(message);
    }
}

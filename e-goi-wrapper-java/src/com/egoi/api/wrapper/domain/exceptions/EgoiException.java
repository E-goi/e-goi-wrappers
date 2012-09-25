package com.egoi.api.wrapper.domain.exceptions;

@SuppressWarnings("serial")
public class EgoiException extends Exception {

	public EgoiException() {
		super();
	}

	public EgoiException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EgoiException(String message, Throwable cause) {
		super(message, cause);
	}

	public EgoiException(String message) {
		super(message);
	}

	public EgoiException(Throwable cause) {
		super(cause);
	}

}

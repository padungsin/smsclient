package com.marlo.lib.sms.impl;

public class SendSMSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3204516009928135175L;

	public SendSMSException() {

	}

	public SendSMSException(String message) {
		super(message);

	}

	public SendSMSException(Throwable cause) {
		super(cause);

	}

	public SendSMSException(String message, Throwable cause) {
		super(message, cause);

	}

	public SendSMSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}

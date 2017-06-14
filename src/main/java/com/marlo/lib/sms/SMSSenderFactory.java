package com.marlo.lib.sms;

import com.marlo.lib.sms.impl.THSMSSender;

public class SMSSenderFactory {

	public static SMSSender createSender(String[] params) throws SenderNotFoundException {

		String gateway = (String) params[0];

		if ("thsms".equals(gateway)) {
			String username = params[1];
			String password = params[2];
			String sender = params[3];
			String recipient = params[4];
			String message = params[5];

			return new THSMSSender(username, password, sender, recipient, message);
		} else {

			throw new SenderNotFoundException("SMS Gateway client not found [" + gateway + "]");
		}

	}
}

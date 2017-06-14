package com.marlo.lib.sms;

import com.marlo.lib.sms.impl.SendSMSException;

public class Application {

	private String[] params;

	public static void main(String[] args) {

		String gateway = "thsms";
		String username = "padungsin";
		String password = "f46280";
		String sender = "NOTICE";
		String recipient = "0817523465";
		String message = "test from api";

		String[] params = new String[6];
		params[0] = gateway;
		params[1] = username;
		params[2] = password;
		params[3] = sender;
		params[4] = recipient;
		params[5] = message;

		try {
			Application app = new Application(params);
			System.out.println(app.send());
		} catch (SenderNotFoundException e) {
			e.printStackTrace();
		} catch (SendSMSException e) {

			e.printStackTrace();
		}

	}

	public Application(String[] params) throws SenderNotFoundException, SendSMSException {
		this.params = params;

	}

	public String send() {

		try {
			SMSSender sender = SMSSenderFactory.createSender(params);
			return sender.send();
		} catch (SenderNotFoundException e) {
			return e.getMessage();
		} catch (SendSMSException e) {
			return e.getMessage();
		}

	}
}

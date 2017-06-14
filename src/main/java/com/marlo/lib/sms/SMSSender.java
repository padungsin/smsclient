package com.marlo.lib.sms;

import com.marlo.lib.sms.impl.SendSMSException;

public interface SMSSender {
	public String send() throws SendSMSException;

}

package com.marlo.lib.sms.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.marlo.lib.sms.SMSSender;

public class THSMSSender implements SMSSender {


	private String username;
	private String password;
	private String sender;
	private String recipient;
	private String message;

	public THSMSSender(String username, String password, String sender, String recipient, String message) {
		this.username = username;
		this.password = password;
		this.sender = sender;
		this.recipient = recipient;
		this.message = message;

	}


	public String send() throws SendSMSException {
		try {
			// http://www.thsms.com/api/rest?method=send&username=$USERNAME&password=$PASSWORD&from=$FROM&to=$TO&message=$MESSAGE
			String requestUri = "http://www.thsms.com/api/rest?method=send";
			requestUri += "&username=" + this.username;
			requestUri += "&password=" + this.password;
			requestUri += "&from=" + this.sender;
			requestUri += "&to=" + this.recipient;
			requestUri += "&message=" + URLEncoder.encode(this.message, "UTF-8");

			DefaultHttpClient httpClient = new DefaultHttpClient();
			//HttpGet getRequest = new HttpGet(URLEncoder.encode(requestUri, "UTF-8"));
			HttpGet getRequest = new HttpGet(requestUri);
			//getRequest.addHeader("accept", "application/xml");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String line;
			String output = "";
			System.out.println("Output from Server .... \n");
			while ((line = br.readLine()) != null) {
				output += line + "\n";
			}

			httpClient.getConnectionManager().shutdown();
			
			return output;

		} catch (Exception e) {

			throw new SendSMSException(e.getMessage());

		}
	}

}

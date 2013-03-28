package com.vanceinfo.cfclient.service;

import com.vanceinfo.cfclient.model.Transaction;

public  class SenderService {
	
	
	public static void sendMsg(Transaction transaction)
	{
		System.out.println("Send to queue,mocked"+transaction.getCustomerId()+": location"+transaction.getLocation());
	}

}

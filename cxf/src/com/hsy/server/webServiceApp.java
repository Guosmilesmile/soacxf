package com.hsy.server;

import javax.xml.ws.Endpoint;

public class webServiceApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 System.out.println("web service start");
         HelloWorldImpl implementor = new HelloWorldImpl();
         String address = "http://localhost:8080/helloWorld";
         Endpoint.publish(address, implementor);
         System.out.println("web service started");
	}

}

package com.nit.multipleobjectextraction;

import org.apache.http.client.fluent.Request;

public class ReponseCodes {

    public static void main(String[] args) {
		String url="https://edition.cnn.com/business";

		int resp_code=0;
		try {
            resp_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
            System.out.println("Respose code for URL "+ url +" is -> "+ resp_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * @author Jeffee C.
 * @date: 上午9:22:43,2015
 */
package com.facebook.crawl;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.json.JsonObject;


public class UserInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInfo.getUserInfo("tsaiingwen");
	}
	
	public static void getUserInfo(String uid){
		String MY_ACCESS_TOKEN = "CAACEdEose0cBAKlxZBMRjVlxj0bzXlZB7kiTvMeFD8ZCmjqGPNF43bxL78dxm7wyB9HFGBdnNEDnKnZBsV8m0L1dgxld6I1ioMBMLtM8AVbHHZCchS8YrDyB9xqjRzVP1tUXV9LIz2ZCR6X0N8gSf0OSPKZC7IEI61OuD96B2yAurQNj6h1GLnDT2NEZAZClaQHDuunmfJ7FZBX3MBJdDpHpF7";
		FacebookClient client = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		JsonObject user = client.fetchObject(uid, JsonObject.class);
		System.out.println(user.toString());
	}
}

/**
 * @author Jeffee C.
 * @date: 上午8:53:32,2015
 */
package com.facebook.crawl;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.json.JsonObject;

/**
 *
 */
public class FeedCrawl {
	
	public static void getAllFeeds(FacebookClient client, String uid){
		JsonObject feed = client.fetchObject("tsaiingwen/feed", JsonObject.class);
		System.out.println(feed.get("data"));
	}
	
	public static void main(String[] args) {
		String MY_ACCESS_TOKEN = "CAACEdEose0cBAKlxZBMRjVlxj0bzXlZB7kiTvMeFD8ZCmjqGPNF43bxL78dxm7wyB9HFGBdnNEDnKnZBsV8m0L1dgxld6I1ioMBMLtM8AVbHHZCchS8YrDyB9xqjRzVP1tUXV9LIz2ZCR6X0N8gSf0OSPKZC7IEI61OuD96B2yAurQNj6h1GLnDT2NEZAZClaQHDuunmfJ7FZBX3MBJdDpHpF7";
		FacebookClient client = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		JsonObject feed = client.fetchObject("tsaiingwen/feed", JsonObject.class);
		System.out.println(feed.get("data"));
	}

}

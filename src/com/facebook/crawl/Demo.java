/**
 * ����9:28:54;  by:Administrator
 */
package com.facebook.crawl;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

/**
 * @author Administrator
 *
 */
public class Demo {

	public static String MY_ACCESS_TOKEN = "CAACEdEose0cBAKlxZBMRjVlxj0bzXlZB7kiTvMeFD8ZCmjqGPNF43bxL78dxm7wyB9HFGBdnNEDnKnZBsV8m0L1dgxld6I1ioMBMLtM8AVbHHZCchS8YrDyB9xqjRzVP1tUXV9LIz2ZCR6X0N8gSf0OSPKZC7IEI61OuD96B2yAurQNj6h1GLnDT2NEZAZClaQHDuunmfJ7FZBX3MBJdDpHpF7";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);

		User user = facebookClient.fetchObject("me", User.class);
		Page page = facebookClient.fetchObject("cocacola", Page.class);

		System.out.println("User name: " + user.getName());
		System.out.println("Page likes: " + page.getLikes());

		// Some Post from the GoT Fanpage with likes and comments total count
		Post post = facebookClient.fetchObject("74133697733_10152424266332734", 
		  Post.class, 
		  Parameter.with("fields", "from,to,likes.summary(true),comments.summary(true)"));

		System.out.println("Likes count: " + post.getLikesCount());
		System.out.println("Likes count (from Likes): " + post.getLikes().getTotalCount());
		System.out.println("Comments count: " + post.getComments().getTotalCount());
		
	}

}

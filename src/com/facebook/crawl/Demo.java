/**
 * ÉÏÎç9:28:54;  by:Administrator
 */
package com.facebook.crawl;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.User;

/**
 * @author Administrator
 *
 */
public class Demo {

	public static String MY_ACCESS_TOKEN = "CAACEdEose0cBAMYmvcHxbOcwvmvNoq8EHqWChGTKYM2UHzQraIUdGjFK9OsiOS1TpDMLiCAuAJ2QY4HJN8f4ZCZCY1xhRS4XAzz7GCKA9my5md8vFNLq5oaoYVaRRmbEQYZBvocMIZBX4ZBl6ZAU6Rj1xGsd6rSTHpUR5bDpjUiuBdpQZAn7uDVbbZBhsOdhLG9P38HpJ50otr7ghL8UgD8G";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
		FacebookClient publicOnlyFacebookClient = new DefaultFacebookClient();

		User user = facebookClient.fetchObject("me", User.class);
		Page page = facebookClient.fetchObject("cocacola", Page.class);

		System.out.println("User name: " + user.getName());
		System.out.println("Page likes: " + page.getLikes());

		
		
	}

}

/**
 * @author Jeffee C.
 * @date: 上午10:52:36,2015
 * 实现数据抓取
 */
package com.facebook.crawl;

import com.facebook.common.Common;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.json.JsonObject;


public class Crawl {

		@SuppressWarnings("deprecation")
	protected static FacebookClient client = new DefaultFacebookClient(Common.MY_ACCESS_TOKEN);
	
	public static JsonObject crawl(String key){
		JsonObject result = client.fetchObject(key, JsonObject.class);
		return result;
	}
	
	/***用于抓取comment、like等页面,递归实现
	 * @param jObj:
	 * 格式为：
	 * "likes": { "data": [……],
	 *         	  "paging": {
	 *               "next": "https://graph.facebook.com/v2.0/……",
	 *                    ……
	 *         		}
	 *         	 }
	 * @param fDir: 结果要存储的位置
	 * **/
	public static void crawlPages(JsonObject jObj, String fDir, int count) {
		String fName = Common.genFileName(fDir, count++);
		FileProcess.write(fName, jObj.toString());
		System.out.println("Page "+ (count-1) +"  has been finished!");
		String next;
		try {
			next = jObj.getJsonObject("paging").getString("next");
			//System.out.println("next is: "+next);
		} catch (Exception e) {
			// 没有找到“next”，说明已经到最后一页
			System.out.println("已经到了最后一页");
			return;
		}
		next = next.substring(next.indexOf("v2.0") + 5);
		next = Common.updateAccessToken(next);
		JsonObject result = client.fetchObject(next, JsonObject.class);
		crawlPages(result, fDir, count);		
	}
	
	public static void main(String[] args) {
		//String key = "46251501064_10152572626026065/comments?access_token=CAACEdEose0cBAHc9OIuxYdTLVWPu4X0HO77KZA02yjBS2ObFF6LqtP0HVeM9PWYE6q4i96ICZA3U0ZCN7pYqqkPvQZBsGKwE91uVz2LD8rCctZAgwRO3YQsDtExg0npn7OaB2FZAYDI9sAKDYTBrfvzgYBpuWhR5Xk15ZAosSXIGs7sASeEscXKPuOJiE574krISRdqZCEHgb9d9PEQqA9s0&limit=25&after=MzQ%3D";
		String key = "46251501064_10152572626026065/comments?limit=25&format=json&after=Mw%3D%3D&access_token=CAACEdEose0cBAHc9OIuxYdTLVWPu4X0HO77KZA02yjBS2ObFF6LqtP0HVeM9PWYE6q4i96ICZA3U0ZCN7pYqqkPvQZBsGKwE91uVz2LD8rCctZAgwRO3YQsDtExg0npn7OaB2FZAYDI9sAKDYTBrfvzgYBpuWhR5Xk15ZAosSXIGs7sASeEscXKPuOJiE574krISRdqZCEHgb9d9PEQqA9s0&";
		JsonObject result = Crawl.crawl(key);
		//Crawl.crawlPages(result, "E://test//", 1);
		System.out.println(result.toString());
	}

}

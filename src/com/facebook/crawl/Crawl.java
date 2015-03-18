/**
 * @author Jeffee C.
 * @date: 上午10:52:36,2015
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

		String next;
		try {
			next = jObj.getJsonObject("paging").getString("next");
		} catch (Exception e) {
			// 没有找到“next”，说明已经到最后一页
			return;
		}
		next = next.substring(next.indexOf("v2.0") + 5);
		System.out.println(next);
		crawlPages(crawl(next), fDir, count);
	}
	
	public static void main(String[] args) {
		JsonObject result = Crawl.crawl("me");
		System.out.println(result.toString());
	}

}

/**
 * @author Jeffee C.
 * @date: 上午10:51:34,2015
 * Crawl posts from a user's page
 */
package com.facebook.crawl;

import com.facebook.common.TextCommon;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;


public class PostCrawl {
	
	/***
	 * 获取发布的分页posts，并存储再文件中
	 * @param key: 调用API需要用到的关键词，首次为“用户ID/posts"，
	 * 				之后每次结果返回时会给出下一分页的地址，从中提取新的key
	 * @param fDir: 返回结果存储的子目录，fDir字符串格式为“D://xxxx//”,
	 * 				根据返回结果中的previous链接地址提取文件名（表示第一条结果的时间戳）
	 * ***/
	private static String getPosts(String key, String fDir){
		String nextUrl = "";
		JsonObject jObj = Crawl.crawl(key);
		JsonArray arrays = jObj.getJsonArray("data");
		for(int i=0;i<arrays.length();i++){
			System.out.println(((JsonObject)arrays.opt(i)).get("created_time"));
		}
		System.out.println("Finished!");
		
		JsonObject pageObj = jObj.getJsonObject("paging");
		String preTime = TextCommon.match("since", pageObj.getString("previous"));
		fDir = fDir+((fDir.endsWith("//"))?"":"//");
		FileProcess.write(fDir+preTime+".fb", jObj.toString());
		nextUrl = pageObj.getString("next");
		nextUrl = nextUrl.substring(nextUrl.indexOf("v2.0")+5);
		System.out.println(nextUrl);
		return nextUrl;
	}
	
	public static void main(String[] args) {
		String key = "tsaiingwen/posts";
		for(int i=1;i<=50;i++){
			String fDir = "E://FB//蔡英文//posts//";
			key = PostCrawl.getPosts(key, fDir);
			System.out.println("Page "+i+"has been inished!");
		}
		
	}

}

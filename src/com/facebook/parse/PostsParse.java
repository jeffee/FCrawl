/**
 * @author Jeffee C.
 * @date: 下午7:43:21,2015
 * 对抓取到的用户的所有发布内容进行解析，取出每一条内容的信息
 */
package com.facebook.parse;

import java.io.File;

import com.facebook.crawl.Crawl;
import com.facebook.crawl.FileProcess;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonException;
import com.restfb.json.JsonObject;


public class PostsParse {
	
	/***抓取评论信息***/
	public void commentParse(String objID, JsonObject commObj){		
		String fDir = "E://FB//蔡英文//feeds//"+objID+"//comments//";
		File dir = new File(fDir);
		if(!dir.exists()||dir.listFiles().length<=1)
			Crawl.crawlPages(commObj, fDir, 1);
		else
			System.out.println("The item has been processed before!");
		
	}
	
	/***抓取点赞的用户**/
	public void likeParse(String objID, JsonObject likeObj){
		String fDir = "E://FB//蔡英文//feeds//"+objID+"//likes//";
		File dir = new File(fDir);
		if(!dir.exists())
			Crawl.crawlPages(likeObj, fDir, 1);
		else
			System.out.println("The item has been processed before!");
	}
	
	
	public void parse(JsonObject oriObj){
		JsonArray arrays = oriObj.getJsonArray("data");
		for(int i=0;i<arrays.length();i++){
			JsonObject jObj = (JsonObject) arrays.get(i);
			String objID;
			try {
				objID = jObj.getString("object_id");
			} catch (JsonException e) {
				objID = jObj.getString("id"); //分享别人的内容时， 没有“object_id”,用id代替。此时"status_type": "shared_story",
			}				
		
			try {
				commentParse(objID, jObj.getJsonObject("comments"));
				//likeParse(objID, jObj.getJsonObject("likes"));
			} catch (JsonException e) {
				// 出现异常时表示没有评论或赞
				System.err.println("Comments/Likes not found!");
			}
		}
	}
	
	
	public static void main(String[] args) {
		File dir = new File("E://FB//蔡英文//posts");
		File[] files = dir.listFiles();
		for(File file : files){
			String str = FileProcess.readLine(file);
			PostsParse parse = new PostsParse();
			parse.parse(new JsonObject(str));
			System.out.println("File "+file+" has been processed sucessfully!");
			System.out.println("********************************************");
		}
		
	}

}

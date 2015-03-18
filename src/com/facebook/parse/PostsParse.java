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
import com.restfb.json.JsonObject;


public class PostsParse {
	
	public void commentParse(String objID, JsonObject commObj){
		JsonArray arrays = commObj.getJsonArray("data");
		
		String next = commObj.getJsonObject("paging").getString("next");
		System.out.println(next);
		String fDir = "E://FB//蔡英文//feeds//"+objID+"//";
		Crawl.crawlPages(commObj, fDir, 1);
	}
	
	public void likeParse(JsonObject likeObj){
		
	}
	
	/***
	 * @todo: 未考虑没有comments和likes的时候
	 * ***/
	public void parse(JsonObject oriObj){
		JsonArray arrays = oriObj.getJsonArray("data");
		for(int i=0;i<arrays.length();i++){
			JsonObject jObj = (JsonObject) arrays.get(i);
			String objID = jObj.getString("object_id");
			//String content = jObj.getString("message");		//有可能没有内容（纯照片或链接），此时会报错		
		
			commentParse(objID, jObj.getJsonObject("comments"));
			likeParse(jObj.getJsonObject("likes"));
		}
	}
	
	
	public static void main(String[] args) {
		String str = FileProcess.readLine(new File("E://FB//1426574112.fb"));
		PostsParse parse = new PostsParse();
		parse.parse(new JsonObject(str));
	}

}

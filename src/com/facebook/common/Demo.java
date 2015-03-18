package com.facebook.common;

import java.io.File;

import com.facebook.crawl.FileProcess;
import com.restfb.json.JsonObject;


public class Demo {
	
	public static void main(String[] args) {
		String fDir = "E://FB//蔡英文//feeds//10152544606906065//comments//";
		String str = FileProcess.readLine(new File("E://FB//1426574112.fb"));
		JsonObject obj = new JsonObject(str);
		obj.getJsonObject("df");
	}

}

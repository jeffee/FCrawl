/**
 * @author Jeffee C.
 * @date: 下午3:53:29,2015
 * 文本处理常用到的函数
 */
package com.facebook.common;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.facebook.crawl.FileProcess;


public class TextCommon {
	
	/***利用正则表达式获取url中的key对应的value值****/
	public static String match(String key, String str){
		String result = "";
		Pattern pattern = Pattern.compile(key+"=(.*?)&");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find())
			result = matcher.group(1);
		return result;
	}

	/***用新的token替换掉原来url中的旧token
	 * 数据采集如果不是在一个token的有效期内完成，到下一个token生效时原有url会无效，需要更新
	 * ***/
	public static String updateAccessToken(String url){
		String newUrl = "";
		Pattern pattern = Pattern.compile("access_token=(.*?)&");
		Matcher matcher = pattern.matcher(url);
		if(matcher.find()){
			StringBuffer sb = new StringBuffer();
			matcher.appendReplacement(sb, "access_token="+Common.MY_ACCESS_TOKEN+"&");
			matcher.appendTail(sb);
			System.out.println(sb.toString());
		}
		
		return newUrl;
	}
	public static void main(String[] args) {
		//String str = FileProcess.readLine(new File("E://FB//蔡英文//posts//1426574112.fb"));
		String str = "46251501064_10152572626026065/comments?access_token=CAACEdEose0cBAPZBE8ZBZBYDJRyOlglzjlZBNNqI0ZASzKsBNLIYoXGfRZAZBxzE9lUmR8OzQjZAU6WMWwFv9nwAZA9H7kf1JOLAX2B1xtyZAOggOJ55N2xP4KxMZA276FuZC6ZCCrT2ZBQLCuRpWpZBzVr6q1KSwygOUr2eaDWi5erp7ssASjhsOkUs2JR8jyDXw9k5kQGOS9oAh7me6aBRBo5U4ci&limit=25&after=MzQ%3D";
		TextCommon.updateAccessToken(str);

	}

}

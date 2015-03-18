/**
 * @author Jeffee C.
 * @date: 下午3:53:29,2015
 * 文本处理常用到的函数
 */
package com.facebook.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TextCommon {
	
	/***利用正则表达式获取url中的key对应的value值****/
	public static String match(String key, String str){
		String result = "";
		Pattern pattern = Pattern.compile(key+"=(.*?)&");
		Matcher matcher = pattern.matcher(str+"&");
		if(matcher.find())
			result = matcher.group(1);
		return result;
	}


	public static void main(String[] args) {
		//String str = FileProcess.readLine(new File("E://FB//蔡英文//posts//1426574112.fb"));
		String str = "46251501064_10152572626026065/comments?access_token=CAACEdEose0cBAPZBE8ZBZBYDJRyOlglzjlZBNNqI0ZASzKsBNLIYoXGfRZAZBxzE9lUmR8OzQjZAU6WMWwFv9nwAZA9H7kf1JOLAX2B1xtyZAOggOJ55N2xP4KxMZA276FuZC6ZCCrT2ZBQLCuRpWpZBzVr6q1KSwygOUr2eaDWi5erp7ssASjhsOkUs2JR8jyDXw9k5kQGOS9oAh7me6aBRBo5U4ci&limit=25&after=MzQ%3D";

	}

}

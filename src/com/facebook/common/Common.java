/**
 * @author Jeffee C.
 * @date: 下午3:17:53,2015
 */
package com.facebook.common;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {

	public final static SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static String MY_ACCESS_TOKEN = "CAACEdEose0cBAM0pcCgFuLGzeyPSFDwLYFPqjKOHwGnv4drOGDWiEjZBhXhE8OxZBWhbvIgvaVFZByxZB4GUwR5VFM5ZAuiNHdm0ECT5IXSHkItTdDbLxpvWDXEuwZAJ2rsVVvj0rZCkZCWUHdBxLvnR6PHiZC3B0sZCkMGabFZAd6ZAs5fTKhrVZAbi3U3WfXlt53AarKi9rZC7cbpqb1A3aNHmQm";

	
	public static String genFileName(String dir, int i){
		return (dir+((dir.endsWith("//"))?"":"//") + i + ".fb");
	}
	
	/***用新的token替换掉原来url中的旧token
	 * 数据采集如果不是在一个token的有效期内完成，到下一个token生效时原有url会无效，需要更新
	 * ***/
	public static String updateAccessToken(String url){
		String newUrl = "";
		Pattern pattern = Pattern.compile("access_token=(.*?)&");
		Matcher matcher = pattern.matcher(url+"&");
		if(matcher.find()){
			StringBuffer sb = new StringBuffer();
			matcher.appendReplacement(sb, "access_token="+Common.MY_ACCESS_TOKEN+"&");
			matcher.appendTail(sb);
			newUrl = sb.toString();
			//System.out.println(newUrl);
		}
		return newUrl;
	}
	
	public static void main(String[] args) {
		String str = "46251501064_10152572626026065/comments?access_token=CAACEdEose0cBAPZBE8ZBZBYDJRyOlglzjlZBNNqI0ZASzKsBNLIYoXGfRZAZBxzE9lUmR8OzQjZAU6WMWwFv9nwAZA9H7kf1JOLAX2B1xtyZAOggOJ55N2xP4KxMZA276FuZC6ZCCrT2ZBQLCuRpWpZBzVr6q1KSwygOUr2eaDWi5erp7ssASjhsOkUs2JR8jyDXw9k5kQGOS9oAh7me6aBRBo5U4ci&limit=25&after=MzQ%3D";
		Common.updateAccessToken(str);
	}

}

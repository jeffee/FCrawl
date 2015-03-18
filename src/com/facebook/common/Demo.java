package com.facebook.common;

import java.io.File;


public class Demo {
	
	public static void main(String[] args) {
		String fDir = "E://FB//蔡英文//feeds//10152544606906065//comments//";
		File dir = new File(fDir);
		if(!dir.exists())
			System.out.println("not exist");
		else
			System.out.println("exist");
	}

}

/**
 * @author Jeffee C.
 * @date: 下午3:17:53,2015
 */
package com.facebook.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

	public final static SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static String MY_ACCESS_TOKEN = "CAACEdEose0cBAAA7DsFPqB4T91QwUkz181OT1qEKAkcDDTQJxssvpAA91fRPE1nSDajAmsM2CZCAQZAxC8s5ALLNgEATgq6H1nM7ZCoXJXgsaIvvvAo2JLJ1McQ2EYpehsR4daINNrnjGISscf3JWVWe1dSlC5TT420mglI1yGsmrmY8VOuYEDWNxzQN8DkEryrw3gctiPn3O6HrTnx";

	
	public static String genFileName(String dir, int i){
		return (dir+((dir.endsWith("//"))?"":"//") + i + ".fb");
	}
	
	public static void main(String[] args) {
		String fDir = "D://ekjk//";
		System.out.println(fDir);
		fDir = fDir+((fDir.endsWith("//"))?"":"//");
		System.out.println(fDir);
	}

}

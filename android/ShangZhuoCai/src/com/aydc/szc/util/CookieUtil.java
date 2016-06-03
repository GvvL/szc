package com.aydc.szc.util;

import com.aydc.szc.app.App;
import com.squareup.okhttp.Headers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
/**
 * cookie管理类
 * @author Administrator
 *
 */
public class CookieUtil {

	public static String getCookies(Context context) {
		String str="";
		if(App.getSharedPrefences().contains("Cooki")){
			str=App.getSharedPrefences().getString("Cooki", "");
		}
		return str;
	}

	public static void saveCookies(Headers headers, Context context) {
		String string = headers.get("Set-Cookie");
		if(string!=null&&string.length()>0){
			App.getSharedPrefences().edit().putString("Cooki", string).commit();
		}
	}

}

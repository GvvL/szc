package com.aydc.szc.util;

import com.aydc.szc.app.App;

import android.graphics.Typeface;
import android.widget.TextView;

/**
 * ���幤��
 * @author Administrator
 *
 */
public class FontUtil {
	private static Typeface asset1=Typeface.createFromAsset(App.getInstance().getAssets(), "font/font1.otf");
	private static Typeface asset2=Typeface.createFromAsset(App.getInstance().getAssets(), "font/font2.ttf");
	private static Typeface iconfont=Typeface.createFromAsset(App.getInstance().getAssets(), "font/iconfont.ttf");

	public static Typeface getFont(int i){
		if(i==1){
			return asset1;
		}else if(i==0){
			return iconfont;
		}else{
			return asset2;
		}
	}
	public static <T extends TextView> T init(int i,T t){
		Typeface tf=getFont(i);
		t.setTypeface(tf);
		return t;
	}
	public static <T extends TextView> void init(int i,T... ts){
		if(ts==null) return;
		Typeface tf=getFont(i);
		for(T tx:ts){
			tx.setTypeface(tf);
		}
	}

}

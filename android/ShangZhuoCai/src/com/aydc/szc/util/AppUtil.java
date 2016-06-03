package com.aydc.szc.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.aydc.szc.app.App;
import com.bumptech.glide.Glide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class AppUtil {
	/**
	 * 获取状态栏高度
	 * 
	 * @return
	 */
	public static int getStatusBarHeight() {
		int resourceId = App.getInstance().getResources()
				.getIdentifier("status_bar_height", "dimen", "android");
		int statusHeight = 0;
		if (resourceId > 0) {
			statusHeight = App.getInstance().getResources()
					.getDimensionPixelSize(resourceId);
		}
		return statusHeight;
		// 另两种获取办法
		// Rect rectangle= new Rect();
		// Window window= getWindow();
		// window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
		// int statusBarHeight= rectangle.top;
		// showLog("状态2："+statusBarHeight);
		//
		// int
		// s3=getWindowManager().getDefaultDisplay().getHeight()-rectangle.height();
		// showLog("状态3："+s3);
	}

	/**
	 * 屏幕尺寸
	 * 
	 * @param act
	 * @return
	 */
	public static DisplayMetrics getMetric(Activity act) {
		DisplayMetrics metric = new DisplayMetrics();
		act.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric;
	}

	/**
	 * 获取dp
	 * 
	 * @param act
	 * @return
	 */
	@SuppressLint("NewApi")
	public static float[] getSceenDp() {
		// WindowManager wm=act.getWindowManager();
		DisplayMetrics metrics = App.getInstance().getResources()
				.getDisplayMetrics();
		// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
		// wm.getDefaultDisplay().getRealMetrics(metrics);
		// } else {
		// wm.getDefaultDisplay().getMetrics(metrics);
		// }
		float widthDp = metrics.widthPixels / metrics.density;
		float heightDp = metrics.heightPixels / metrics.density;
		float[] dps = new float[2];
		dps[0] = widthDp;
		dps[1] = heightDp;
		return dps;
	}

	/**
	 * 
	 * @param dpValue
	 * @return
	 */
	public static int dp2px(float dpValue) {
		final float scale = App.getInstance().getResources()
				.getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public static int designedDP2px(float designedDp) {
		int width = (int) getSceenDp()[0];
		if (width != 320) {
			designedDp = designedDp * width / 320f;
		}
		return dp2px(designedDp);
	}

	public static void setPadding(final View view, float left, float top,
			float right, float bottom) {
		view.setPadding(designedDP2px(left), dp2px(top), designedDP2px(right),
				dp2px(bottom));
	}

	/**
	 * 检查网络
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isHasNet(Context c) {
		ConnectivityManager conn = (ConnectivityManager) c
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = conn.getActiveNetworkInfo();// 获取联网状态网络
		if (info == null || !info.isAvailable()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 前后台
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isBackground(Context context) {
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> appProcesses = activityManager
				.getRunningAppProcesses();
		for (RunningAppProcessInfo appProcess : appProcesses) {
			if (appProcess.processName.equals(context.getPackageName())) {
				/*
				 * BACKGROUND=400 EMPTY=500 FOREGROUND=100 GONE=1000
				 * PERCEPTIBLE=130 SERVICE=300 ISIBLE=200
				 */
				Log.i(context.getPackageName(), "此appimportace ="
						+ appProcess.importance
						+ ",context.getClass().getName()="
						+ context.getClass().getName());
				if (appProcess.importance != RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
					Log.i(context.getPackageName(), "处于后台"
							+ appProcess.processName);
					return true;
				} else {
					Log.i(context.getPackageName(), "处于前台"
							+ appProcess.processName);
					return false;
				}
			}
		}
		return false;
	}

	// 时间戳-》日期
	@SuppressLint("SimpleDateFormat")
	public static String stamp2time(String stamp, @Nullable String format) {
		String defaultformat = "yyyy/MM/dd hh:mm";
		if (format != null)
			defaultformat = format;
		SimpleDateFormat sdf = new SimpleDateFormat(defaultformat);
		String format2 = sdf.format(new Date(Long.parseLong(stamp) * 1000));
		return format2;
	}

	// ->>1位小数
	public static String formatFloat(float f) {
		DecimalFormat form = new DecimalFormat("#.0");
		return form.format(f);
	}

	// 获取版本号
	public static String getVersionName() throws Exception {
		// 获取packagemanager的实例
		PackageManager packageManager = App.getInstance().getPackageManager();
		PackageInfo packInfo = packageManager.getPackageInfo(App.getInstance().getPackageName(),
				0);
		String version = packInfo.versionName;
		return version;
	}
	//清理缓存
	public static void cleanCache(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Glide.get(App.getInstance().getApplicationContext()).clearDiskCache();
				
			}
		}).start();
	}
	/** 
     * 获取文件夹大小 
     * @param file File实例 
     * @return long 单位为M 
     * @throws Exception 
     */  
    public static float getFolderSize(java.io.File file)throws Exception{  
        float size = 0;  
        java.io.File[] fileList = file.listFiles();  
        for (int i = 0; i < fileList.length; i++)  
        {  
            if (fileList[i].isDirectory())  
            {  
                size = size + getFolderSize(fileList[i]);  
            } else  
            {  
                size = size + fileList[i].length();  
            }  
        }  
        return size/1048576;  
    }  

}

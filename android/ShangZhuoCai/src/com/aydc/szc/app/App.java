package com.aydc.szc.app;



import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.entity.UserBean;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.util.Logger;



/**
 * 主程序
 */
public class App extends Application implements ActivityLifecycleCallbacks{
	private final static String AYPREFERENCES="aydcRP";

	private static App instance;
	
	public boolean isActive=false;//前后台
	
	public ImageButton btn_cart;
	
	public WeakReference<Activity> currActivity;

	public UserBean userinfo=new UserBean();
	
	public static boolean islogin=false;
	public static boolean isfirst=false;
	public static boolean issafe=false;
	
	public static ArrayList<DishBean> dishes=new ArrayList<>();
	public static ArrayList<ChefBean> chefs=new ArrayList<>();
	public static HashMap<Integer, Integer> carts = new HashMap<>();
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		isActive=true;
		MyCrashHandler handler = MyCrashHandler.getInstance();
		handler.init(getApplicationContext());
		registerActivityLifecycleCallbacks(this);
		
		login();
	}





	

	

	
	private void login() {
		UserModel.getInstance().getUserLocal();
	}










	/**
	 * 单例
	 * @return 
	 */
	public static App getInstance() {		
		 return instance;
	}
	
	/**
	 * 获取首选项	
	 */
	public static SharedPreferences getSharedPrefences() {
		return App.getInstance().getApplicationContext().getSharedPreferences(AYPREFERENCES, Context.MODE_PRIVATE);

	}

	/*
	 * 初始
	 */
	/*
	public static void initImageLoader(Context context) {
        //缓存文件的目录
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "imageloader/Cache"); 
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽 
                .threadPoolSize(3) //线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) //你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值
                .diskCacheSize(30 * 1024 * 1024)  // 50 Mb sd卡(本地)缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径  
                .imageDownloader(new BaseImageDownloader(context, 1 * 1000, 1 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间  
                .writeDebugLogs() // Remove for release app
                .build();
        //全局初始化此配置  
        ImageLoader.getInstance().init(config);
    }
    */
	//获取版本号
	public int getVersion() {
		     try {
		         PackageManager manager = this.getPackageManager();
		         PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
		         int version = info.versionCode;
		         return  version;
		    } catch (Exception e) {
		         e.printStackTrace();
		        return 0;
		    }
		 }



	@Override
	public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void onActivityStarted(Activity activity) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void onActivityResumed(Activity activity) {
		currActivity=new WeakReference<Activity>(activity);
		if(!isActive){
			Logger.e("进入前台");
			isActive=true;
			if(btn_cart!=null) btn_cart.setVisibility(View.VISIBLE);
		}
		
	}



	@Override
	public void onActivityPaused(Activity activity) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void onActivityStopped(Activity activity) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public void onActivityDestroyed(Activity activity) {
		// TODO 自动生成的方法存根
		
	}
	


	


}

package com.aydc.szc.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import android.content.Context;

import com.aydc.szc.app.App;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;




/**
 * 网络请求类
 *默认带头 自动json rxjava
 *
 */
public class HttpManager {
//	    public static final String API_SERVER = "http://192.168.199.147/shangzhuocai/index.php/Home/mobile/";
	    public static final String API_SERVER = "http://mt.ayidiancan.com/index.php/Home/mobile/";
	    //超时时间
	    public static final int CONNECT_OUTTIME = 5;
	    //缓存大小。路径
	    public static final long CACHE_SIZE = 5*1024*1024;
	    public static final String CACHE_NAME = "HttpCache";
	    private static final OkHttpClient mOkHttpClient = new OkHttpClient();
	    private static Retrofit mRetrofit;

	    public static Retrofit getRetrofit() {
	            if (mRetrofit == null) {
	                Context context = App.getInstance().getApplicationContext();
	                mOkHttpClient.setConnectTimeout(CONNECT_OUTTIME, TimeUnit.SECONDS);
//	                HttpLoggingInterceptor logInterceptor=new HttpLoggingInterceptor();
//	                logInterceptor.setLevel(Level.HEADERS);
	                //拦截器自定义Cookies的设置
	                mOkHttpClient.networkInterceptors()
	                            .add(new CookiesInterceptor(context));
//	                mOkHttpClient.networkInterceptors()
//	                .add(logInterceptor);
	                            
	                //设置缓存目录
	                File cacheDirectory = new File(context.getCacheDir()
	                                        .getAbsolutePath(), CACHE_NAME);
	                Cache cache = new Cache(cacheDirectory, CACHE_SIZE);
	                mOkHttpClient.setCache(cache);
	                //构建Retrofit
	                mRetrofit = new Retrofit.Builder()
	                        //配置服务器路径
	                        .baseUrl(API_SERVER)  
	                        .addConverterFactory(GsonConverterFactory.create())
	                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
	                        .client(mOkHttpClient)
	                        .build();
	            }
	            return mRetrofit;
	        }
	    public static Retrofit getRetrofit(String url) {
	    		Context context = App.getInstance().getApplicationContext();
	    		mOkHttpClient.setConnectTimeout(CONNECT_OUTTIME, TimeUnit.SECONDS);
//	                HttpLoggingInterceptor logInterceptor=new HttpLoggingInterceptor();
//	                logInterceptor.setLevel(Level.HEADERS);
	    		//拦截器自定义Cookies的设置
	    		mOkHttpClient.networkInterceptors()
	    		.add(new CookiesInterceptor(context));
//	                mOkHttpClient.networkInterceptors()
//	                .add(logInterceptor);
	    		
	    		//设置缓存目录
	    		File cacheDirectory = new File(context.getCacheDir()
	    				.getAbsolutePath(), CACHE_NAME);
	    		Cache cache = new Cache(cacheDirectory, CACHE_SIZE);
	    		mOkHttpClient.setCache(cache);
	    		//构建Retrofit
	    		Retrofit mRet = new Retrofit.Builder()
	    		//配置服务器路径
	    		.baseUrl(url)  
//	    		.addConverterFactory(GsonConverterFactory.create())
//	    		.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
	    		.client(mOkHttpClient)
	    		.build();
	    		return mRet;
	    }


}

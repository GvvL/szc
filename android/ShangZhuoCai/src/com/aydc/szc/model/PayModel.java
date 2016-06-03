package com.aydc.szc.model;

import java.io.IOException;
import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;
import android.os.Handler;
import android.os.Message;

import com.aydc.szc.util.HttpManager;
import com.aydc.szc.util.JSONUtil;
import com.aydc.szc.util.Logger;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

public class PayModel {
	public static final int PAY_HANDLER_CODE=100;
	public static final int PAY_HANDLER_ERROR_CODE=100;
	public static void createCharge(int type,String channel,int id,final Handler handler){
		final Message message = new Message();
		//组织数据 1类型：订单支付、充值
		//支付方式  支付宝 微信
		//订单id id
		final String postStr=getPostJsonStr(type,channel,id);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String data=null;
				try {
					data=postJson("http://mt.ayidiancan.com/index.php/Home/mobile/createCharge", postStr);
					Logger.e("--"+data);

				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(data!=null){
						message.obj=data;
						message.what=PAY_HANDLER_CODE;
						handler.sendMessage(message);
					}else{
						message.what=PAY_HANDLER_ERROR_CODE;
						handler.sendMessage(message);
					}
				}
			}
		}).start();

		
			
				
	}
    private static String getPostJsonStr(int type, String channel, int id) {
    	HashMap<String, Object> map=new HashMap<>();
    	map.put("type", type+"");
    	map.put("channel", channel);
    	map.put("id", id+"");
		return JSONUtil.map2JSONObject(map).toString();
	}
	private static String postJson(String url, String json) throws IOException {
        MediaType type = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(type, json);
        Request request = new Request.Builder().url(url).post(body).build();

        OkHttpClient client = new OkHttpClient();
        com.squareup.okhttp.Response response = client.newCall(request).execute();

        return response.body().string();
    }
    
    public interface CreateChargeBack{
    	void onSuccess(String str);
    }

	
	public interface PayApi{
		@Headers("Content-Type:application/json")
		@FormUrlEncoded
		@POST("createCharge")
		Call<String> createCharge(@Field("orderid") int orderid
								 ,@Field("channel") String channel
															);

	}
	public static PayApi payApi=HttpManager.getRetrofit().create(PayApi.class);
	
}

package com.aydc.szc.util;

import java.io.IOException;




import java.nio.charset.Charset;

import okio.Buffer;
import okio.BufferedSource;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.content.Context;

/**
 * 头信息拦截器
 *
 */
public class CookiesInterceptor implements Interceptor{
    private Context context;

    public CookiesInterceptor(Context context) {
        this.context = context;
    }
    //重写拦截方法
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();  
        Logger.e(request.httpUrl().toString());
        //cookie
        String cookies = CookieUtil.getCookies(context);
        Request compressedRequest;
        if(cookies.length()>0){
            compressedRequest = request.newBuilder()
//                  .header("cookie", CookieUtil.getCookies(context))
                  .addHeader("Cookie", cookies)
                  .build();
        }else{
            compressedRequest = request.newBuilder().build();
        }
        
        Response response = chain.proceed(compressedRequest);
        //出错
//        Logger.e(response.body().string());
//        BufferedSource source = response.body().source();
//        Buffer buffer = source.buffer();
//        Charset charset = response.body().contentType().charset(Charset.forName("UTF-8"));
//        Logger.e("数据返回:"+buffer.clone().readString(charset));
        CookieUtil.saveCookies(response.headers(), context);
        return response;
    }

}

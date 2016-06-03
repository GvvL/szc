package com.aydc.szc.util;


import com.aydc.szc.entity.ResponseDataBase;

import rx.Subscriber;
/**
 * 服务端约定
 * 2++正常
 * 4++异常
 * 500网络层异常
 * @param <T>
 */
public abstract class ApiCallBack<T extends ResponseDataBase> extends Subscriber<T> {
	private static final int UNAUTHORIZED = 401;
	@Override
	public void onCompleted() {
		
	}

	@Override
	public void onError(Throwable th) {
			th.printStackTrace();
			error(500, th.getMessage());
	}
	@Override
	public void onNext(T data) {
		int code=data.getCode();
		if(code>=200 && code<300){
			success(data);
		}else{
			Logger.e("数据返回错误:"+data.getCode(), data.getMsg());
			error(code, data.getMsg());
		}
		
		
	}
	protected abstract void success(T data);
	protected abstract void error(int code,String str);

	

	

}

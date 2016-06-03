package com.aydc.szc.model;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import com.aydc.szc.app.App;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.UserBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.HttpManager;
import com.aydc.szc.util.JSONUtil;
import com.aydc.szc.util.Logger;
import com.aydc.szc.util.Md5Util;
import com.aydc.szc.widget.MToast;














import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import android.content.Context;



public class UserModel {
	private static String SP_USER_KEY="user";
	private static UserModel instance=new UserModel();
	private UserModel(){
		
	}
	public static UserModel getInstance(){
		return instance;
	}
	
	public boolean isLogin(){
		String userstr = App.getSharedPrefences().getString(SP_USER_KEY, "");
		if(userstr.length()<10) return false;
		return true;
	}
	public static boolean isVip(){
		if(App.getInstance().userinfo.getType()==1){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取sp的user
	 * @return
	 */
	public UserBean getUserLocal(){
//		if(!isLogin()) throw new RuntimeException("用户尚未登录");
		String userstr = App.getSharedPrefences().getString(SP_USER_KEY, "");
		JSONObject instaceJsonObject = JSONUtil.instaceJsonObject(userstr);
		UserBean userBean=JSONUtil.jsonObject2Bean(instaceJsonObject, UserBean.class);
		if(userBean!=null){
			App.islogin=true;
			App.getInstance().userinfo=userBean;
		}
		return userBean;
	}
	/**
	 * 获取用户信息 网络
	 * @param ucb 
	 */
	public void getUserOnServer(final Context c,final UserCallBack ucb){
		if(!App.islogin){
			Logger.e("用户尚未登录");
			return;
		}
		UserBean userLocal = getUserLocal();
			userServerApi.getUser(userLocal.getId())
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(new ApiCallBack<ResponseDataItem<UserBean>>() {

				@Override
				protected void success(ResponseDataItem<UserBean> data) {
					UserBean userdata = data.getData();
					if(userdata!=null){
						saveUserLocal(c, userdata);
						refreshUserUI(userdata);
						App.islogin=true;
						App.getInstance().userinfo=userdata;
						ucb.getUserSuccess(userdata);
					}
				}

				@Override
				protected void error(int code, String str) {
					MToast.createToastConfig(c).ToastShow("获取用户信息失败");
					UserModel.getInstance().logout(c);
				}
			});
	}
	/**
	 * 通知更新
	 * @param userbean
	 */
	public void refreshUserUI(UserBean userbean){
		EventBus.getDefault().post(userbean);
	}
	/**
	 * 持久化
	 * @param c
	 * @param ub
	 */
	private void saveUserLocal(Context c,UserBean ub){
		JSONObject userjsonObject = JSONUtil.bean2JSONObject(ub);
		App.getSharedPrefences().edit().putString(SP_USER_KEY, userjsonObject.toString()).commit();
	}
	/**
	 * 退出登录
	 */
	public void logout(Context c){
		if(!isLogin()) throw new RuntimeException("用户尚未登录");
		App.getSharedPrefences().edit().remove(SP_USER_KEY).commit();
		//通知更新界面
		UserBean user=new UserBean();
		App.islogin=false;
		user.setLogin(false);
		EventBus.getDefault().post(user);
	}
	/**
	 * 
	 *登录
	 */
	public void login(final ViewDelegate viewdelegate,String username,String password,final LoginCallBack call){
		userServerApi.login(username, new Md5Util().getMD5ofStr(password))
		.subscribeOn(Schedulers.io())
		.doOnSubscribe(new Action0() {
			@Override
			public void call() {
				viewdelegate.showLoadingDialog("");
			}
		})
		.subscribeOn(AndroidSchedulers.mainThread())
		.observeOn(AndroidSchedulers.mainThread())
		.doOnNext(new Action1<ResponseDataItem<UserBean>>() {
			@Override
			public void call(ResponseDataItem<UserBean> arg0) {
				viewdelegate.hideLoadingDialog();
			}
		})
		.subscribe(new ApiCallBack<ResponseDataItem<UserBean>>() {

			@Override
			protected void success(ResponseDataItem<UserBean> data) {
				UserBean ubn=data.getData();
				saveUserLocal(App.getInstance().getApplicationContext(), ubn);
				//通知更新界面
				refreshUserUI(ubn);
				call.loginSuccess(ubn);
			}

			@Override
			protected void error(int code, String str) {
				if(code==500){
					viewdelegate.showTS("网络异常");
				}else{
					viewdelegate.showTS("登录失败");
				}
				viewdelegate.hideLoadingDialog();
				Logger.i(code+str);
			}
		});
	}
	
	public interface UserCallBack{
		void getUserSuccess(UserBean loginUser);
	}
	public interface LoginCallBack{
		void loginSuccess(UserBean user);
	}
	public interface UserServerApi{
		@Multipart
		@POST("updataUserinfo")
		Observable<ResponseDataItem<UserBean>> getUser(@Part("uid") int uid);
		@Multipart
		@POST("login")
		Observable<ResponseDataItem<UserBean>> login(@Part("username") String uid,@Part("password") String password);
	}
	public static UserServerApi userServerApi=HttpManager.getRetrofit().create(UserServerApi.class);

}

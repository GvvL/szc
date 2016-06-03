package com.aydc.szc.ui;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.RechargeTypeBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.entity.ResponseDataList;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.PayModel;
import com.aydc.szc.model.RechargeModel;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.Logger;
import com.pingplusplus.android.PaymentActivity;

public class RechargeActivity extends ActP<RechargeView> implements OnClickListener{
	@Override
	protected void preliminary() {
		super.preliminary();
		viewDelegate.showLoading();
		RechargeModel.rechargeApi.getAllRechargeType()
							.observeOn(AndroidSchedulers.mainThread())
							.subscribeOn(Schedulers.io())
							.subscribe(new ApiCallBack<ResponseDataList<RechargeTypeBean>>() {
								@Override
								protected void success(
										ResponseDataList<RechargeTypeBean> data) {
									viewDelegate.hideOperateFrame();
									viewDelegate.showRechargeType(data.getData());
									
								}

								@Override
								protected void error(int code, String str) {
									
								}
							});
	}
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.setOnClickListener(this, R.id.recharge_btn);
	}
	private int value;
	@Override
	public void onClick(View v) {
		value=0;
		final String channel;
		for(int i=0;i<viewDelegate.recharge_face.getChildCount();i++){
			if(((RadioButton)viewDelegate.recharge_face.getChildAt(i)).isChecked()){
				value=viewDelegate.rechargeArr.get(i).getValue();
				break;
			}
		}
		
		if(viewDelegate.recharge_channel1.isChecked()){
			channel=Common.CHANNEL_ALIPAY;
		}else{
			channel=Common.CHANNEL_WECHAT;
		}
		viewDelegate.showLoadingDialog("");
		RechargeModel.rechargeApi.submitRecharge(App.getInstance().userinfo.getId(), value, channel)
											.observeOn(AndroidSchedulers.mainThread())
											.subscribeOn(Schedulers.io())
											.subscribe(new ApiCallBack<ResponseDataItem<RechargeTypeBean>>() {

												@Override
												protected void success(
														ResponseDataItem<RechargeTypeBean> data) {
													
													RechargeActivity.this.createPay(data.getData(),channel);
													
												}

												@Override
												protected void error(int code,
														String str) {
													viewDelegate.hideLoadingDialog();
													
												}
											});
	}
	//回调
	@SuppressLint("HandlerLeak")
	public Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==PayModel.PAY_HANDLER_CODE&&((String)msg.obj)!=null){
				viewDelegate.hideLoadingDialog();
				String data=(String) msg.obj;
				RechargeActivity.this.topay(data);
			}else{
				viewDelegate.hideLoadingDialog();
				viewDelegate.showTS("订单异常");
			}
		};
	};
	protected void createPay(RechargeTypeBean rechbean, String channel) {
		//订单类型 余额充值
		int type=2;
		PayModel.createCharge(type, channel, rechbean.getId(), handler);
		
	}
	protected void topay(String data) {
		Intent intent = new Intent(this, PaymentActivity.class);
		intent.putExtra(PaymentActivity.EXTRA_CHARGE, data);
		startActivityForResult(intent, Common.REQUEST_CODE_PAYMENT);
		
	}
	
	//支付结果
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==Common.REQUEST_CODE_PAYMENT){
				String result = data.getExtras().getString("pay_result");
                /* 处理返回值
                 * "success" - payment succeed
                 * "fail"    - payment failed
                 * "cancel"  - user canceld
                 * "invalid" - payment plugin not installed
                 */
                String errorMsg = data.getExtras().getString("error_msg"); // 错误信息
                String extraMsg = data.getExtras().getString("extra_msg"); // 错误信息
                Logger.e(result+"-"+errorMsg+"-"+extraMsg);
                if(result.trim().equals("success")){
                	String balance = App.getInstance().userinfo.getBalance();
                	App.getInstance().userinfo.setBalance(Float.parseFloat(balance)+value+"");
                	this.finish();
                }
		}
	}

}

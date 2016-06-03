package com.aydc.szc.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.OrderBean;
import com.aydc.szc.fram.ActP;
import com.aydc.szc.model.PayModel;
import com.aydc.szc.util.Logger;
import com.pingplusplus.android.PaymentActivity;
import com.pingplusplus.android.PingppLog;

public class ToPayActivity extends ActP<ToPayView> implements OnClickListener{
	public static OrderBean orderbean;
	@Override
	protected void preliminary() {
		super.preliminary();
		if(orderbean==null||orderbean.getStatus()!=0){
			Logger.e("订单异常");
			finish();
		}
		
		
		
		PingppLog.DEBUG=true;
	}
	
	@Override
	protected void bindEvenListener() {
		super.bindEvenListener();
		viewDelegate.setOnClickListener(this, R.id.topay_btn);
	}
	
	
	
	//支付结果
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		findViewById(R.id.topay_btn).setOnClickListener(this);
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
                viewDelegate.showTS(result);
                if(result.trim().equals("success")){
                	orderbean.setStatus(1);
                	OrdersActivity.ORDER_PAY_SECCESS=orderbean;
                	orderbean=null;
                	this.finish();
                }
		}
	}
	//回调
	@SuppressLint("HandlerLeak")
	public Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==PayModel.PAY_HANDLER_CODE&&((String)msg.obj)!=null){
				String data=(String) msg.obj;
				ToPayActivity.this.topay(data);
			}else{
				viewDelegate.showTS("订单异常");
			}
		};
	};
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.topay_btn:
			findViewById(R.id.topay_btn).setOnClickListener(null);
			
			//获取支付渠道
			String channel=Common.CHANNEL_YUE;
			switch (viewDelegate.topay_rg.getCheckedRadioButtonId()) {
			case R.id.topay_rb1:
				channel=Common.CHANNEL_YUE;
				break;
			case R.id.topay_rb2:
				channel=Common.CHANNEL_ALIPAY;
				break;
			case R.id.topay_rb3:
				channel=Common.CHANNEL_WECHAT;
				break;
			}
			//订单类型 订单支付
			int type=1;
			int orderid=orderbean.getId();
			
			PayModel.createCharge(type,channel,orderid,handler);
			break;

		default:
			break;
		}
	}
	
	private void topay(String data){
		Intent intent = new Intent(this, PaymentActivity.class);
		intent.putExtra(PaymentActivity.EXTRA_CHARGE, data);
		startActivityForResult(intent, Common.REQUEST_CODE_PAYMENT);
	}

}

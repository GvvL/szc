package com.aydc.szc.ui;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Bind;
import com.aydc.szc.R;
import com.aydc.szc.adaper.ToPayFoodsAdapter;
import com.aydc.szc.entity.UserBean;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.model.UserModel.UserCallBack;
import com.aydc.szc.util.AppUtil;
import com.aydc.szc.widget.MListView;

public class ToPayView extends HasTitleViewDelegater {
	@Bind(R.id.topay_foods) MListView mListview;
	@Bind(R.id.topay_all_price) TextView topay_all_price;
	@Bind(R.id.topay_btn) TextView topay_btn;
	@Bind(R.id.topay_rb1) RadioButton rb1;
	@Bind(R.id.topay_rb2) RadioButton rb2;
	@Bind(R.id.topay_rb3) RadioButton rb3;
	@Bind(R.id.topay_rg) RadioGroup topay_rg;
	private ToPayFoodsAdapter adapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_topay;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		adapter=new ToPayFoodsAdapter(getActivity(), ToPayActivity.orderbean.getArr());
		mListview.setAdapter(adapter);
		topay_all_price.setText("¥"+AppUtil.formatFloat(ToPayActivity.orderbean.getPrice()));
		showLoadingDialog("");
		UserModel.getInstance().getUserOnServer(getActivity(), new UserCallBack() {
			
			@Override
			public void getUserSuccess(UserBean loginUser) {
				hideLoadingDialog();
				rb1.setText("余额支付(剩余：¥"+loginUser.getBalance()+")");
				
			}
		});
		rb1.setChecked(true);
	}
	

}

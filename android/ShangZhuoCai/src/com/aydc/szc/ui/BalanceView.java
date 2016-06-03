package com.aydc.szc.ui;

import java.util.ArrayList;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.adaper.BalanceAdapter;
import com.aydc.szc.app.App;
import com.aydc.szc.entity.BalanceDetailBean;

public class BalanceView extends HasTitleViewDelegater{
	@Bind(R.id.balance_recycleView) RecyclerView mRecyclerView;
	@Bind(R.id.balance_yue) TextView balance_yue;
	private BalanceAdapter adapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_balance;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		adapter=new BalanceAdapter(getActivity());
		mRecyclerView.setAdapter(adapter);
		balance_yue.setText(App.getInstance().userinfo.getBalance());
	}
	@OnClick(R.id.balance_recharge)
	public void chargeClick(View v){
		jumpPage(RechargeActivity.class);
	}
	public void showData(ArrayList<BalanceDetailBean> data) {
		adapter.setData(data);
	}

}

package com.aydc.szc.ui;

import java.util.ArrayList;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.adaper.AddressAdapter;
import com.aydc.szc.adaper.AddressDecoration;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.AddressBean;
/**
 * 地址选择和地址查看
 * @author Administrator
 *
 */
public class AddressView extends HasTitleViewDelegater{
	@Bind(R.id.sr_refreshview) SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.rc_recycleView) RecyclerView mRecyclerView;
	
	AddressAdapter adapter;
	ArrayList<AddressBean> addarr;
	private boolean issel;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_address;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		Intent intent = getActivity().getIntent();
		if(intent.hasExtra("sel")){
			issel=intent.getBooleanExtra("sel", false);
		}
		mSwipeRefreshLayout.setEnabled(false);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		adapter=new AddressAdapter(getActivity(),issel);
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.addItemDecoration(new AddressDecoration());
	}
	public void showData(ArrayList<AddressBean> data) {
		addarr=data;
		this.adapter.setdata(addarr);
	}
	@OnClick(R.id.nav_bar_right)
	public void addAddressClick(View v){
		Intent intent=new Intent(this.getActivity(), AddressDetailActivity.class);
		intent.putExtra("isadd", true);
		getActivity().startActivityForResult(intent, Common.REQUEST_ADDRESS_ADD);
	}
	//制空
	public void resetaddress(){
		if(addarr==null) return;
		for(AddressBean addr:addarr){
			if(1==addr.getIsdefault()){
				addr.setIsdefault(0);
			}
		}
	}

}

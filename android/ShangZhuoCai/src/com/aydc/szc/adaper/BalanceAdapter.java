package com.aydc.szc.adaper;

import java.util.ArrayList;

import android.bluetooth.BluetoothAssignedNumbers;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.entity.BalanceDetailBean;
import com.aydc.szc.util.AppUtil;
import com.aydc.szc.util.FontUtil;

public class BalanceAdapter extends Adapter<BalanceAdapter.ViewHolder>{
	private LayoutInflater inflater;
	private ArrayList<BalanceDetailBean> data;
	public BalanceAdapter(Context c) {
		inflater=LayoutInflater.from(c);
	}
	public void setData(ArrayList<BalanceDetailBean> res){
		data=res;
		this.notifyDataSetChanged();
	}
	
	@Override
	public int getItemCount() {
		return data==null?0:data.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder vh, int arg1) {
		BalanceDetailBean balanceDetailBean = data.get(arg1);
		vh.cell_balance_str.setText(balanceDetailBean.getStr());
		vh.cell_balance_time.setText(AppUtil.stamp2time(balanceDetailBean.getTime(), null));
		vh.cell_balance_value.setText(balanceDetailBean.getValue());
		
		
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=inflater.inflate(R.layout.cell_balance, arg0, false);
		ViewHolder vh=new ViewHolder(view);
		return vh;
	}
	
	class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
		@Bind(R.id.cell_balance_time) TextView cell_balance_time;
		@Bind(R.id.cell_balance_str) TextView cell_balance_str;
		@Bind(R.id.cell_balance_value) TextView cell_balance_value;
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
		
	}

}

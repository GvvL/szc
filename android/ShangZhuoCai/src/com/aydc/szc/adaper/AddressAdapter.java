package com.aydc.szc.adaper;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.AddressBean;
import com.aydc.szc.model.AddressModel;
import com.aydc.szc.ui.AddressActivity;
import com.aydc.szc.ui.AddressDetailActivity;
import com.aydc.szc.ui.ConfirmOrderActivity;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.util.JSONUtil;

public class AddressAdapter extends Adapter<AddressAdapter.ViewHolder>{
	private LayoutInflater inflater;
	private ArrayList<AddressBean> address=new ArrayList<>();
	private boolean isresflag;
	private Context mContext;
	public AddressAdapter(Context c,boolean flag) {
		inflater=LayoutInflater.from(c);
		isresflag=flag;
		mContext=c;
	}
	public void setdata(ArrayList<AddressBean> a){
		this.address=a;
		this.notifyDataSetChanged();
	}
	
	@Override
	public int getItemCount() {
		return address.size();
	}
	
	private void reset(){
		for(AddressBean ab:address){
			ab.setIsdefault(0);
		}
		this.notifyDataSetChanged();
	}

	@Override
	public void onBindViewHolder(final ViewHolder vh, int arg1) {
		final AddressBean add=address.get(arg1);
		vh.tv_address.setText(add.getAddress_detail());
		vh.tv_name.setText(add.getAddress_linkman());
		vh.tv_tel.setText(add.getAddress_linktel());
		vh.img_sel.setVisibility(add.getIsdefault()==1?View.VISIBLE:View.INVISIBLE);
		vh.tv_edit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		vh.cell_address_ll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(add.getIsdefault()==1){
					add.setIsdefault(0);
				}else{
					reset();
					add.setIsdefault(1);
				}
				vh.img_sel.setVisibility(add.getIsdefault()==1?View.VISIBLE:View.INVISIBLE);
				if(isresflag){
					((AddressActivity)mContext).setResult(Common.SEL_ADDRESS_RESPONSE_CODE);
					ConfirmOrderActivity.address=add;
					AddressModel.setAddressDefault(App.getInstance().userinfo.getId(), add.getId());
					((AddressActivity)mContext).finish();
				}
			}
		});
		vh.tv_edit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(mContext, AddressDetailActivity.class);
				intent.putExtra("isadd", false);
				intent.putExtra("addr", JSONUtil.bean2JSONObject(add).toString());
				((Activity)mContext).startActivityForResult(intent, Common.REQUEST_ADDRESS_EDIT);
			}
		});
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=inflater.inflate(R.layout.cell_address, null);
		ViewHolder vh=new ViewHolder(view);
		return vh;
	}
	
	class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
		@Bind(R.id.tv_address) TextView tv_address;
		@Bind(R.id.tv_name)  TextView tv_name;
		@Bind(R.id.tv_tel)	TextView tv_tel;
		@Bind(R.id.tv_edit) TextView tv_edit;
		@Bind(R.id.cell_address_ll) RelativeLayout cell_address_ll;
		@Bind(R.id.act_address_sel) ImageButton img_sel;
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			FontUtil.init(1, tv_edit);
		}
		
	}

}

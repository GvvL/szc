package com.aydc.szc.adaper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.widget.GlideRoundTransform;
import com.bumptech.glide.Glide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ConfirmOrderFoodAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<DishBean> order_dishes=new ArrayList<>();
	public ConfirmOrderFoodAdapter(Context c) {
		this.mContext=c;
	}
	@Override
	public int getCount() {
		return order_dishes.size();
	}
	
	public void setdata(ArrayList<DishBean> or){
		this.order_dishes=or;
		this.notifyDataSetChanged();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh=null;
		if(convertView==null){
			convertView=View.inflate(mContext, R.layout.act_confirm_listview_cell, null);
			vh=new ViewHolder();
			ButterKnife.bind(vh, convertView);
			convertView.setTag(vh);
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		DishBean db=order_dishes.get(position);
		vh.tv_title.setText(db.getTitle());
		if(App.carts.containsKey(db.getId())){
			vh.tv_num.setText("x "+App.carts.get(db.getId()));
		}else{
			vh.tv_num.setText("x "+0);
		}
		
		vh.tv_price.setText("¥ "+(UserModel.isVip()?db.getVipprice():db.getPrice()));
		Glide.with(mContext).load(Common.RELEAST_HOST+db.getImg()).transform(new GlideRoundTransform(mContext, 5)).into(vh.img_food);
		return convertView;
	}
	
	class ViewHolder{
		@Bind(R.id.act_confirm_cell_foodtitle) TextView tv_title;
		@Bind(R.id.act_confirm_cell_foodnum) TextView tv_num;
		@Bind(R.id.act_confirm_cell_foodprice) TextView tv_price;
		@Bind(R.id.act_confirm_cell_foodimg) ImageView img_food;
		public ViewHolder() {
		}
	}

}

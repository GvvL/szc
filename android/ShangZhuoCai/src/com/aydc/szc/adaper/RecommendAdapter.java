package com.aydc.szc.adaper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.model.ChefModel;
import com.aydc.szc.model.ChefModel.FindChefCallBack;
import com.aydc.szc.ui.MainActivity;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.util.Logger;
import com.bumptech.glide.Glide;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RecommendAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<DishBean> dishes;
	public RecommendAdapter(Context c,ArrayList<DishBean> d) {
		dishes=d;
		mContext=c;
	}
	public void setdata(ArrayList<DishBean> d){
		dishes=d;
	}
	@Override
	public int getCount() {
		return dishes.size();
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
		final ViewHolder vh;
		final DishBean db=dishes.get(position);
		if(convertView==null){
			convertView=View.inflate(mContext, R.layout.cell_recommend, null);
			vh=new ViewHolder();
			ButterKnife.bind(vh, convertView);
			vh.cart_left.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					CartModel.add(db.getId());
					((MainActivity)mContext).refeshCart();
				}
			});
			vh.cart_right.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					CartModel.add(db.getId());
					((MainActivity)mContext).refeshCart();
				}
			});
			FontUtil.init(1, vh.tv_food_title,vh.tv_food_desc,vh.cart_left,vh.cart_right);
			convertView.setTag(vh);
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		vh.tv_food_title.setText(db.getTitle());
		vh.tv_food_desc.setText(db.getDescription());
		Glide.with(mContext).load(Common.RELEAST_HOST+db.getImg()).placeholder(R.drawable.test_food).into(vh.food_img);
		
		ChefModel.findChef(db.getChef_id(), new FindChefCallBack() {
			@Override
			public void findSuccess(ChefBean chef) {
				Glide.with(mContext).load(Common.RELEAST_HOST+chef.getImg()).placeholder(R.drawable.test_header).into(vh.food_chefimg);
			}
			@Override
			public void findFaild() {
				Logger.e("--->"+db.getTitle()+"的厨师未找到");
			}
		});
		return convertView;
	}
	
	class ViewHolder{
		@Bind(R.id.food_title) TextView tv_food_title;
		@Bind(R.id.food_desc) TextView tv_food_desc;
		@Bind(R.id.cartbtn_left) TextView cart_left;
		@Bind(R.id.cartbtn_right) TextView cart_right;
		@Bind(R.id.food_img) ImageView food_img;
		@Bind(R.id.food_chefimg) ImageView food_chefimg;
		
	}

}

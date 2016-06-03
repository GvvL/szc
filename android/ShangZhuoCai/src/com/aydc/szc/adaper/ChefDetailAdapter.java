package com.aydc.szc.adaper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.ui.ChefDetailView;
import com.aydc.szc.util.AnimUtil;
import com.aydc.szc.util.FontUtil;
import com.bumptech.glide.Glide;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChefDetailAdapter extends BaseAdapter{
	private ChefDetailView chefview;
	ArrayList<DishBean> dishes=new ArrayList<>();
	
	public ChefDetailAdapter(ChefDetailView cdv) {
		this.chefview=cdv;
	}
	public void setData(ArrayList<DishBean> di){
		dishes=di;
		notifyDataSetChanged();
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
		ViewHolder vh = null;
		final DishBean dish=dishes.get(position);
		if(convertView==null){
			convertView=LayoutInflater.from(chefview.getActivity()).inflate(R.layout.cell_chefdetail, null);
			vh=new ViewHolder(convertView);
			convertView.setTag(vh);
			vh.cell_cart_view.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ViewGroup vg=(ViewGroup)v.getParent();
					AnimUtil.getInstance().cartAnim(chefview, vg, chefview.getCartView(), null);
					CartModel.add(dish.getId());
					chefview.refeshCart();
				}
			});
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		Glide.with(chefview.getActivity()).load(Common.RELEAST_HOST+dish.getImg()).into(vh.cell_img);
		vh.cell_vipprice.setText("¥"+dish.getVipprice());
		vh.cell_price.setText("¥"+dish.getPrice());
		vh.cell_title.setText(dish.getTitle());
		return convertView;
	}
	class ViewHolder{
		@Bind(R.id.cell_cart_view)
		TextView cell_cart_view;
		@Bind(R.id.cell_cart_rview)
		RelativeLayout cell_cart_rview;
		@Bind(R.id.cell_img)
		ImageView cell_img;
		@Bind(R.id.cell_title)
		TextView cell_title;
		@Bind(R.id.cell_vipprice)
		TextView cell_vipprice;
		@Bind(R.id.cell_price)
		TextView cell_price;
		public ViewHolder(View convertView) {
			ButterKnife.bind(this, convertView);
			FontUtil.init(0, cell_cart_view);
		}
	}

	

}

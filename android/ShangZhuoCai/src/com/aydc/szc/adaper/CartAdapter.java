package com.aydc.szc.adaper;

import java.util.ArrayList;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.ui.CartView;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CartAdapter extends Adapter<CartAdapter.CartViewHolder>{
	private LayoutInflater inflater;
	private ArrayList<DishBean> dbarr;
	private Context mContext;
	private ViewDelegate viewdelegate;
	public CartAdapter(ViewDelegate vd,ArrayList<DishBean> dbarr) {
		inflater=LayoutInflater.from(vd.getActivity());
		this.dbarr=dbarr;
		mContext=vd.getActivity();
		viewdelegate=vd;
	}
	public void setdata(ArrayList<DishBean> dbarr){
		this.dbarr=dbarr;
		this.notifyDataSetChanged();
	}
	@Override
	public int getItemCount() {
		return dbarr.size();
	}

	@Override
	public void onBindViewHolder(final CartViewHolder arg0, int arg1) {
		final DishBean dishBean = dbarr.get(arg1);
		arg0.product_name.setText(dishBean.getTitle());
		arg0.product_price.setText("¥ "+(UserModel.isVip()?dishBean.getVipprice():dishBean.getPrice()));
		Glide.with(mContext).load(Common.RELEAST_HOST+dishBean.getImg()).into(arg0.product_img);
		arg0.icon_sel.setBackgroundResource(dishBean.isCartSel()?R.drawable.ic_sel_on:R.drawable.ic_sel_off);
		arg0.product_num.setText(""+(App.carts.containsKey(dishBean.getId())?App.carts.get(dishBean.getId()):0));
		arg0.add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CartModel.add(dishBean.getId());
				arg0.product_num.setText(App.carts.get(dishBean.getId())+"");
				((CartView)viewdelegate).refreshPrice();
			}
		});
		arg0.reduce.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(App.carts.containsKey(dishBean.getId())&&App.carts.get(dishBean.getId())==0) return;
				CartModel.add(dishBean.getId(), -1);
				arg0.product_num.setText(App.carts.get(dishBean.getId())+"");
				((CartView)viewdelegate).refreshPrice();
			}
		});
		arg0.icon_sel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dishBean.setCartSel(!dishBean.isCartSel());
				arg0.icon_sel.setBackgroundResource(dishBean.isCartSel()?R.drawable.ic_sel_on:R.drawable.ic_sel_off);
				((CartView)viewdelegate).refershSel();
			}
		});
	}

	@Override
	public CartViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = inflater.inflate(R.layout.cell_cart_product, null);
		CartViewHolder cvh=new CartViewHolder(view);
		return cvh;
	}
	
	
	class CartViewHolder extends ViewHolder{
		@Bind(R.id.product_img) ImageView product_img;
		@Bind(R.id.product_name) TextView product_name;
		@Bind(R.id.product_price) TextView product_price;
		@Bind(R.id.product_num) TextView product_num;
		@Bind(R.id.btn_add) ImageButton add;
		@Bind(R.id.btn_reduce) ImageButton reduce;
		@Bind(R.id.icon_sel) ImageButton icon_sel;
		public CartViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
		
	}

}

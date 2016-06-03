package com.aydc.szc.ui;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.adaper.CartAdapter;
import com.aydc.szc.adaper.Tab2RecDecoration;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.widget.MDialog.ButtonRespond;

public class CartView extends HasTitleViewDelegater{
	@Bind(R.id.cart_recycleView)
	RecyclerView mRecyclerView;
	
	@Bind(R.id.cart_sel) ImageButton cart_sel;
	@Bind(R.id.cart_sel_text) TextView cart_sel_text;
	@Bind(R.id.cart_all_price) TextView cart_all_price;
	@Bind(R.id.cart_all_price_bottom) TextView cart_all_price_bottom;
	
	CartAdapter cartAdapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_cart;
	}
	
	@SuppressLint("NewApi")
	@Override
	public void initWidget() {
		super.initWidget();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		cartAdapter = new CartAdapter(this,CartModel.getCartDishes(false));
		mRecyclerView.setAdapter(cartAdapter);
		mRecyclerView.addItemDecoration(new Tab2RecDecoration());
		refershSel();
	}
	
	public void refershSel(){
		cart_sel.setBackgroundResource(CartModel.isAllSel()?R.drawable.ic_sel_on:R.drawable.ic_sel_off);
		refreshPrice();
	}
	public void refreshPrice(){
		cart_all_price.setText("共"+CartModel.getCartSelNum()+"份，总价合计：¥"+CartModel.getCartPrice());
		cart_all_price_bottom.setText("¥ "+CartModel.getCartPrice());
	}
	@OnClick({R.id.cart_sel,R.id.cart_sel_text})
	public void allSelClick(View v){
		CartModel.selAll(CartModel.isAllSel()?false:true);
		cartAdapter.notifyDataSetChanged();
		refershSel();
	}
	@OnClick(R.id.nav_bar_right)
	public void deleCart(View v){
		int cartSelCount = CartModel.getCartSelCount();
		if(cartSelCount==0) return;
		showDialog("清空", "确认清空选中的"+cartSelCount+"种菜品", "取消", "确认", new ButtonRespond() {
			@Override
			public void buttonRightRespond() {
				CartModel.deleCartSel();
				cartAdapter.setdata(CartModel.getCartDishes(false));
				refershSel();
			}
			
			@Override
			public void buttonLeftRespond() {
				
			}
		});
	}
	@OnClick(R.id.act_cart_next)
	public void nextstep(View v){
		if(CartModel.getCartDishes(true).size()==0){
			showTS("不存在待结算菜品！");
			return;
		}
		jumpPage(ConfirmOrderActivity.class);
	}
}

package com.aydc.szc.ui;


import java.text.DecimalFormat;

import android.widget.TextView;
import butterknife.Bind;

import com.aydc.szc.R;
import com.aydc.szc.adaper.OrderDetailAdapter;
import com.aydc.szc.entity.OrderBean.OrderDishBean;
import com.aydc.szc.widget.MListView;

public class OrderDetailView extends HasTitleViewDelegater{
	@Bind(R.id.orderdetail_listview) MListView food_listview;
	@Bind(R.id.orderdetail_y_price) TextView orderdetail_y_price;
	@Bind(R.id.orderdetail_status) TextView orderdetail_status;
	@Bind(R.id.orderdetail_price) TextView orderdetail_price;
	@Bind(R.id.ordedetail_feight) TextView ordedetail_feight;
	@Bind(R.id.ordedetail_coupon_price) TextView ordedetail_coupon_price;
	@Bind(R.id.orderdetail_address) TextView orderdetail_address;
	@Bind(R.id.orderdetail_tel) TextView orderdetail_tel;
	private OrderDetailAdapter adapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_orderdetail;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		adapter=new OrderDetailAdapter(getActivity(),OrderDetailActivity.order.getArr());
		food_listview.setAdapter(adapter);
		
		float yprice=0f;
		for(OrderDishBean odb:OrderDetailActivity.order.getArr()){
			yprice+=odb.getCount()*odb.getPrice();
		}
		DecimalFormat format=new DecimalFormat(".0");
		orderdetail_y_price.setText("¥"+format.format(yprice));
		ordedetail_feight.setText("¥"+OrderDetailActivity.order.getOrder_freight());
		if(OrderDetailActivity.order.getCouponid()>0&&OrderDetailActivity.order.getCoupon_price()>0){
			ordedetail_coupon_price.setText("-¥"+OrderDetailActivity.order.getCoupon_price());
		}else{
			ordedetail_coupon_price.setText("-¥0");
		}
		
		orderdetail_price.setText("¥"+format.format(OrderDetailActivity.order.getPrice()));
		orderdetail_address.setText(OrderDetailActivity.order.getAddr());
		orderdetail_tel.setText(OrderDetailActivity.order.getTel());
		switch (OrderDetailActivity.order.getStatus()) {
		case 0:
			orderdetail_status.setText("待支付");
			break;
		case 1:
			orderdetail_status.setText("已支付");
			break;

		default:
			break;
		}
	}

	
	
	


}

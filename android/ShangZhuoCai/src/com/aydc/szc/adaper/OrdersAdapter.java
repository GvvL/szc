package com.aydc.szc.adaper;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.entity.OrderBean;
import com.aydc.szc.entity.OrderBean.OrderDishBean;
import com.aydc.szc.ui.OrderDetailActivity;
import com.aydc.szc.ui.ToPayActivity;
import com.aydc.szc.util.AppUtil;
import com.aydc.szc.util.FontUtil;

public class OrdersAdapter extends Adapter<OrdersAdapter.ViewHolder> implements OnClickListener{
	private LayoutInflater inflater;
	private ArrayList<OrderBean> orders=new ArrayList<>();
	private Context mContext;
	public OrdersAdapter(Context c) {
		inflater=LayoutInflater.from(c);
		mContext=c;
	}
	public void setdata(ArrayList<OrderBean> ord){
		orders= ord;
		this.notifyDataSetChanged();
	}
	@Override
	public int getItemCount() {
		return orders==null?0:orders.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder vh, int pos) {
		final OrderBean orderBean = orders.get(pos);
		vh.order_no.setText("订单号："+orderBean.getSn());
		vh.order_time.setText(AppUtil.stamp2time(orderBean.getOrder_time().trim(), null));
		vh.order_address.setText("地址:"+orderBean.getAddr());
		vh.order_linkman.setText(orderBean.getUname());
		vh.order_linktel.setText(orderBean.getTel());

		vh.order_all_count.setText("X "+getfoodcount(orderBean));
		vh.order_all_price.setText("¥ "+orderBean.getPrice());
		vh.order_btn.setTag(orderBean);
		vh.order_btn.setOnClickListener(this);
		String status_str="<u> 已关闭   </u>";
		switch (orderBean.getStatus()) {
		case -1:
			status_str="<u> 已关闭   </u>";
			vh.order_btn.setText("重新下单");
			break;
		case 0:
			status_str="<u> 待支付   </u>";
			vh.order_btn.setText("去支付");
			break;
		case 1:
			status_str="<u> 已付款   </u>";
			vh.order_btn.setText(" 取消  ");
			break;
		case 2:
			status_str="<u> 退款申请中   </u>";
			vh.order_btn.setText("取消申请");
			break;
		case 3:
			status_str="<u> 退款完成   </u>";
			vh.order_btn.setText("重新下单");
			break;
		case 4:
			status_str="<u> 已完成   </u>";
			vh.order_btn.setText("再来一单");
			break;
		default:
			break;
		}
		vh.order_status.setText(Html.fromHtml(status_str));
		vh.order_ll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				OrderDetailActivity.order=orderBean;
				Intent intent=new Intent(mContext, OrderDetailActivity.class);
				mContext.startActivity(intent);
			}
		});
	}
	@Override
	public void onClick(View v) {
		OrderBean ob=(OrderBean)v.getTag();
		switch (ob.getStatus()) {
		case -1:
		case 3:
		case 4:
			//再来一单
			
			break;
		case 0:
			//去支付
			ToPayActivity.orderbean=ob;
			mContext.startActivity(new Intent(mContext, ToPayActivity.class));
			break;
		case 1:
			//取消订单
			break;
		case 2:
			//取消申请
			break;
		default:
			break;
		}
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup arg0, final int arg1) {
		View view=inflater.inflate(R.layout.cell_order, arg0, false);
		ViewHolder vh=new ViewHolder(view);
		return vh;
	}
	
	public int getfoodcount(OrderBean orderBean){
		int num=0;
		for(OrderDishBean obb:orderBean.getArr()){
			num+=obb.getCount();
		}
		return num;
	}
	
	class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
		@Bind(R.id.order_no) TextView order_no;
		@Bind(R.id.order_time) TextView order_time;
		@Bind(R.id.order_address) TextView order_address;
		@Bind(R.id.order_linkman) TextView order_linkman;
		@Bind(R.id.order_linktel) TextView order_linktel;
		@Bind(R.id.order_status) TextView order_status;
		@Bind(R.id.order_all_count) TextView order_all_count;
		@Bind(R.id.order_all_price) TextView order_all_price;
		@Bind(R.id.order_btn) TextView order_btn;
		@Bind(R.id.order_ll) LinearLayout order_ll;
		
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			FontUtil.init(1, order_status);
		}
		
	}



}

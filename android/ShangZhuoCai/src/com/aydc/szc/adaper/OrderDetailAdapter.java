package com.aydc.szc.adaper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.entity.OrderBean;
import com.aydc.szc.entity.OrderBean.OrderDishBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OrderDetailAdapter extends BaseAdapter{
	private ArrayList<OrderBean.OrderDishBean> foods=new ArrayList<>();
	private Context mContext;
	public OrderDetailAdapter(Context c,List<OrderBean.OrderDishBean> ord) {
		mContext=c;
		this.foods=(ArrayList<OrderDishBean>) ord;
	}
	public void setData(ArrayList<OrderBean.OrderDishBean> ord){
		this.foods=ord;
		this.notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		return foods.size();
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
		ViewHolder vh;
		if(convertView==null){
			convertView=View.inflate(mContext, R.layout.cell_order_detail, null);
			vh=new ViewHolder();
			ButterKnife.bind(vh, convertView);
			convertView.setTag(vh);
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		OrderDishBean orderDishBean = foods.get(position);
		vh.name.setText(orderDishBean.getTitle());
		vh.price.setText("¥"+orderDishBean.getPrice()*orderDishBean.getCount()+"/"+orderDishBean.getCount()+"份");
		return convertView;
	}
	class ViewHolder{
		@Bind(R.id.cell_orderdetail_foodname) TextView name;
		@Bind(R.id.cell_orderdetail_foodprice) TextView price;
		
	}

}

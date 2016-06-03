package com.aydc.szc.adaper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.entity.OrderBean;
import com.aydc.szc.entity.OrderBean.OrderDishBean;
import com.aydc.szc.util.FontUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ToPayFoodsAdapter extends BaseAdapter{
	private ArrayList<OrderBean.OrderDishBean> foods=new ArrayList<>();
	private Context mContext;
	public ToPayFoodsAdapter(Context c,List<OrderBean.OrderDishBean> ord) {
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
			convertView=View.inflate(mContext, R.layout.cell_topay, null);
			vh=new ViewHolder();
			ButterKnife.bind(vh, convertView);
			FontUtil.init(1, vh.name,vh.price,vh.num);
			convertView.setTag(vh);
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		OrderDishBean orderDishBean = foods.get(position);
		DecimalFormat format=new DecimalFormat(".0");
		vh.name.setText(orderDishBean.getTitle());
		vh.price.setText("¥"+format.format(orderDishBean.getPrice()*orderDishBean.getCount()));
		vh.num.setText(orderDishBean.getCount()+"份");
		return convertView;
	}
	class ViewHolder{
		@Bind(R.id.cell_topay_foodname) TextView name;
		@Bind(R.id.cell_topay_foodprice) TextView price;
		@Bind(R.id.cell_topay_foodnum) TextView num;
		
	}

}

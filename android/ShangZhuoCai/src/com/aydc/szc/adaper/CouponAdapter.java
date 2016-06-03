package com.aydc.szc.adaper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.CouponBean;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.ui.ConfirmOrderActivity;
import com.aydc.szc.ui.CouponActivity;

public class CouponAdapter extends Adapter<CouponAdapter.ViewHolder>{
	private LayoutInflater inflater;
	private ArrayList<CouponBean> coupons=new ArrayList<CouponBean>();
	private Context mContext;
	public CouponAdapter(Context c,ArrayList<CouponBean> coup) {
		mContext=c;
		inflater=LayoutInflater.from(c);
		this.coupons=coup;
	}
	public void setdata(ArrayList<CouponBean> cous){
		this.coupons=cous;
		this.notifyDataSetChanged();
	}
	@Override
	public int getItemCount() {
		if(coupons==null){
			return 0;
		}else{
			return coupons.size();
		}
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onBindViewHolder(ViewHolder vh, int arg1) {
		final CouponBean coup=coupons.get(arg1);
		vh.coupon_size.setText(coup.getValue()+"");
		vh.coupon_man.setText("满"+coup.getMin()+"元可用");
		SimpleDateFormat formate=new SimpleDateFormat("yyyy/MM/dd");
		vh.coupon_time.setText("有效期至"+(coup.getValid_date()==0?"\n(无限制)":formate.format(new Date(coup.getValid_date()*1000))));
		if(CouponActivity.isSel){
			if(CartModel.getCartPrice()<coup.getMin()){
				vh.coupon_ll.setAlpha(0.4f);
			}else{
				vh.coupon_ll.setAlpha(1f);
				vh.coupon_ll.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						ConfirmOrderActivity.couponSel=coup;
						((CouponActivity)mContext).setResult(Common.SEL_COUPON_RESPONSE_CODE);
						((CouponActivity)mContext).finish();
					}
				});
			}
		}
		
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=inflater.inflate(R.layout.cell_coupon, arg0, false);
		ViewHolder vh=new ViewHolder(view);
		return vh;
	}
	
	class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
		@Bind(R.id.coupon_line) View v_line;
		@Bind(R.id.coupon_size) TextView coupon_size;
		@Bind(R.id.coupon_man) TextView coupon_man;
		@Bind(R.id.coupon_time) TextView coupon_time;
		@Bind(R.id.coupon_ll) LinearLayout coupon_ll;
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			v_line.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		
	}

}

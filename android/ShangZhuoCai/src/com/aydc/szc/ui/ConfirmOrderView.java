package com.aydc.szc.ui;

import java.util.ArrayList;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.adaper.ConfirmOrderFoodAdapter;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.AddressBean;
import com.aydc.szc.entity.CouponBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.model.OrderModel;
import com.aydc.szc.model.UserModel;
import com.aydc.szc.widget.MListView;


public class ConfirmOrderView extends HasTitleViewDelegater{
	@Bind(R.id.act_confirm_lv_food) MListView mListview;
	@Bind(R.id.act_confirm_tv_address) TextView tv_address;
	@Bind(R.id.act_confirm_tv_address_link) TextView tv_link;
	@Bind(R.id.act_confirm_icontv_detail3) TextView tv_cou_value;
	@Bind(R.id.act_confirm_bottom_bar_price) TextView tv_bottom_price;
	@Bind(R.id.act_confirm_bottom_bar_pay) Button btn_bottom_confirm;
	@Bind(R.id.act_confirm_bottom_bar_yprice) TextView tv_bottom_yprice;
	TextView all_price,all_dish_count;
	EditText tv_note;
	private ConfirmOrderFoodAdapter adapter;
	private View cell_header,cell_fooder;
	private AddressBean defaultAddress;
	private float real_price;
	
	public int getRootLayoutId() {
		return R.layout.act_confirmorder;
	};
	@Override
	public void initWidget() {
		super.initWidget();
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		cell_header=View.inflate(getActivity(), R.layout.act_confirm_listview_head, null);
		cell_fooder=View.inflate(getActivity(), R.layout.act_confirm_listview_food, null);
		all_dish_count=(TextView) cell_fooder.findViewById(R.id.act_confirm_food_foodnum);
		all_price=(TextView) cell_fooder.findViewById(R.id.act_confirm_food_foodprice);
		tv_note=(EditText) cell_fooder.findViewById(R.id.act_confirm_note);
		adapter=new ConfirmOrderFoodAdapter(getActivity());
		mListview.setAdapter(adapter);
		mListview.addHeaderView(cell_header);
		mListview.addFooterView(cell_fooder);
		tv_bottom_price.setText("¥ "+CartModel.getCartPrice());
		
		all_price.setText("¥"+CartModel.getCartPrice());
		all_dish_count.setText(CartModel.getCartSelNum()+"道菜品,共计");
		
	}
	
	public void showData(ArrayList<DishBean> dishes){
		adapter.setdata(dishes);
	}
	
	public void showDefaultAddress(@Nullable AddressBean ab){
		defaultAddress=ab;
		if(ab!=null){
			tv_address.setText(ab.getAddress_detail());
			tv_link.setText(ab.getAddress_linkman()+"\t\t"+ab.getAddress_linktel());
		}
	}
	public void showDefaultCoupon(CouponBean cou){
		if(cou==null){
			real_price=CartModel.getCartPrice();
			tv_cou_value.setText("无");
		}else{
			real_price=CartModel.getCartPrice()-cou.getValue();
			tv_cou_value.setText("¥"+cou.getValue());
		}
		if(real_price<=0) real_price=0.1f;
		tv_bottom_price.setText("¥ "+real_price);
		
	}
	@OnClick(R.id.confirmorder_address)
	public void addressclick(View v){
		Intent inten=new Intent(getActivity(), AddressActivity.class);
		inten.putExtra(Common.SEL_ADDRESS, true);
		getActivity().startActivityForResult(inten, Common.SEL_ADDRESS_REQUEST_CODE);
	}
	@OnClick(R.id.act_confirm_coupon)
	public void couponclick(View v){
		Intent inten=new Intent(getActivity(), CouponActivity.class);
		inten.putExtra(Common.SEL_COUPON, true);
		getActivity().startActivityForResult(inten, Common.SEL_COUPON_REQUEST_CODE);
	}
	@OnClick(R.id.act_confirm_bottom_bar_pay)
	public void makeorder(View v){

		int cid =-1;
		if(ConfirmOrderActivity.couponSel!=null){
			cid= ConfirmOrderActivity.couponSel.getId();
		}
		
		OrderModel.submitorder(this,UserModel.getInstance().getUserLocal().getId()
				,real_price
				,ConfirmOrderActivity.address.getId()
				,cid
				,tv_note.getText().toString().trim());
	}
}

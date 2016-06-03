package com.aydc.szc.ui;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Bind;

import com.aydc.szc.R;
import com.aydc.szc.entity.RechargeTypeBean;
import com.aydc.szc.util.AppUtil;

public class RechargeView extends HasTitleViewDelegater{
	@Bind(R.id.recharge_face) RadioGroup recharge_face;
	@Bind(R.id.recharge_channel1) RadioButton recharge_channel1;
	@Bind(R.id.recharge_channel2) RadioButton recharge_channel2;
	ArrayList<RechargeTypeBean> rechargeArr;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_recharge;
	}

	public void showRechargeType(ArrayList<RechargeTypeBean> data) {
		rechargeArr=data;
		Drawable drawable= getActivity().getResources().getDrawable(R.drawable.ic_tab6_cate4);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		RadioGroup.LayoutParams ll_lp=new RadioGroup.LayoutParams(-1, -2);
		ll_lp.topMargin=AppUtil.designedDP2px(12);
		for(RechargeTypeBean rtb:rechargeArr){
			RadioButton rb=new RadioButton(getActivity());
			rb.setButtonDrawable(getActivity().getResources().getDrawable(R.drawable.select_bg_selector));
			rb.setText(rtb.getValue()+"");
			//设置左边图片
			rb.setCompoundDrawables(drawable, null, null, null);
			rb.setLayoutParams(ll_lp);
			recharge_face.addView(rb);
		}
		//默认选中第一个
		((RadioButton)recharge_face.getChildAt(0)).setChecked(true);
		recharge_channel1.setChecked(true);
	}

}

package com.aydc.szc.ui;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.AddressBean;
import com.aydc.szc.entity.ResponseDataItem;
import com.aydc.szc.model.AddressModel;
import com.aydc.szc.util.ApiCallBack;
import com.aydc.szc.util.JSONUtil;

public class AddressDetailView extends HasTitleViewDelegater{
	@Bind(R.id.act_address_edt_people) EditText act_address_edt_people;
	@Bind(R.id.act_address_edt_tel) EditText act_address_edt_tel;
	@Bind(R.id.act_address_edt_jiedao) EditText act_address_edt_jiedao;
	@Bind(R.id.act_address_edt_menpai) EditText act_address_edt_menpai;
	@Bind(R.id.act_addrde_rb1) RadioButton act_addrde_rb1;
	@Bind(R.id.act_addrde_rb2) RadioButton act_addrde_rb2;
	@Bind(R.id.nav_bar_title) TextView nav_bar_title;
	boolean isadd;
	AddressBean addressBean=null;
	@Override
	public int getRootLayoutId() {
		return R.layout.act_addressdetail;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		act_addrde_rb1.setChecked(true);
	}
	public void showAddr(AddressBean addr){
		addressBean=addr;
		act_address_edt_people.setText(addr.getAddress_linkman());
		act_address_edt_tel.setText(addr.getAddress_linktel());
		act_address_edt_menpai.setText(addr.getAddress_detail());
	}
	
	@OnClick(R.id.act_address_btn_one)
	public void addAddress(View v){
		String uname=act_address_edt_people.getText().toString().trim();
		if(uname.length()==0){
			showTS("联系人不可为空");
			return;
		}
		uname+=act_addrde_rb1.isChecked()?"先生":"女士";
		String linktel=act_address_edt_tel.getText().toString().trim();
		if(linktel.length()!=11 || !linktel.startsWith("1")){
			showTS("联系电话不正确");
			return;
		}
		String jiedao=act_address_edt_jiedao.getText().toString().trim();
//		if(jiedao.length()==0){
//			showTS("地址不可为空");
//			return;
//		}
		String menpai=act_address_edt_menpai.getText().toString().trim();
		showLoadingDialog("");
		if(isadd){
			AddressModel.addressApi.addAddress(App.getInstance().userinfo.getId(),
					uname, linktel, jiedao+menpai, true)
					.observeOn(AndroidSchedulers.mainThread())
					.subscribeOn(Schedulers.io())
					.subscribe(new ApiCallBack<ResponseDataItem<AddressBean>>() {

						@Override
						protected void success(ResponseDataItem<AddressBean> data) {
							hideLoadingDialog();
							Intent intent = getActivity().getIntent();
							intent.putExtra("ab", JSONUtil.bean2JSONObject(data.getData()).toString());
							getActivity().setResult(Common.RESPONSE_HANDLER_ADDRESS, intent);
							getActivity().finish();
							
						}

						@Override
						protected void error(int code, String str) {
							hideLoadingDialog();
							showTS(str);
						}
					});
		}else{
			AddressModel.addressApi.editAddress(App.getInstance().userinfo.getId(),
					addressBean.getId(),uname, linktel, jiedao+menpai, true)
					.observeOn(AndroidSchedulers.mainThread())
					.subscribeOn(Schedulers.io())
					.subscribe(new ApiCallBack<ResponseDataItem<AddressBean>>() {

						@Override
						protected void success(ResponseDataItem<AddressBean> data) {
							hideLoadingDialog();
							Intent intent = getActivity().getIntent();
							intent.putExtra("ab", JSONUtil.bean2JSONObject(data.getData()).toString());
							getActivity().setResult(Common.RESPONSE_HANDLER_ADDRESS, intent);
							getActivity().finish();
						}

						@Override
						protected void error(int code, String str) {
							hideLoadingDialog();
							showTS(str);
						}
					});
		}
	}
}

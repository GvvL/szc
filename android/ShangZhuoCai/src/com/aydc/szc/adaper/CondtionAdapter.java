package com.aydc.szc.adaper;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.aydc.szc.R;
import com.aydc.szc.fram.ViewDelegate;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CondtionAdapter extends BaseAdapter{
	private ArrayList<CondtionBean> cons=new ArrayList<>();
	private WeakReference<ViewDelegate> viewdelegate;
	int colorblack;
	int colorred;
	public CondtionAdapter(ViewDelegate v,ArrayList<CondtionBean> con) {
		viewdelegate=new WeakReference<ViewDelegate>(v);
		cons=con;
		Resources resources = viewdelegate.get().getActivity().getResources();
		colorblack = resources.getColor(R.color.gray_font);
		colorred=resources.getColor(R.color.red);
	}

	@Override
	public int getCount() {
		return cons.size();
	}
	public String setSel(int pos){
		for(CondtionBean con:cons){
			con.setSel(false);
		}
		CondtionBean condtionBean = cons.get(pos);
		condtionBean.setSel(true);
		this.notifyDataSetChanged();
		return condtionBean.getName();
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
		ViewH vh=null;
		if(convertView==null){
			convertView=View.inflate(viewdelegate.get().getActivity(), R.layout.popup_listview_cell, null);
			vh=new ViewH();
			ButterKnife.bind(vh, convertView);
			convertView.setTag(vh);
		}else{
			vh=(ViewH) convertView.getTag();
		}
		CondtionBean condtionBean = cons.get(position);
		vh.textview.setText(condtionBean.getName());

		vh.textview.setTextColor(condtionBean.isSel()?colorred:colorblack);
		return convertView;
	}
	static class ViewH{
		@Bind(R.id.activity_cart_popup_listview_cell_tv) TextView textview;
	}
	
	public static class CondtionBean{
		public CondtionBean(String name) {
			this.name=name;
		}
		private String name;
		private boolean isSel=false;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean isSel() {
			return isSel;
		}
		public void setSel(boolean isSel) {
			this.isSel = isSel;
		}
	}

}

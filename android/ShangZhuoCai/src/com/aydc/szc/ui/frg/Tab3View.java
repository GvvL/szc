package com.aydc.szc.ui.frg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.adaper.CondtionAdapter;
import com.aydc.szc.adaper.Tab2RecDecoration;
import com.aydc.szc.adaper.Tab3ChefAdapter;
import com.aydc.szc.adaper.CondtionAdapter.CondtionBean;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.AppUtil;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.util.Logger;

public class Tab3View extends ViewDelegate implements AnimatorUpdateListener,OnItemClickListener{
	@Bind(R.id.tab3_nav_bar_title1) TextView nav_bar_title1;
	@Bind(R.id.tab3_nav_bar_title2) TextView nav_bar_title2;
	@Bind(R.id.tab3_condition_1) TextView condition1;
	@Bind(R.id.tab3_condition_2) TextView condition2;
	
	@Bind(R.id.tab3_recycleView) RecyclerView mRecyclerView;
	@Bind(R.id.tab3_loading_framlayout) RelativeLayout loading_frame;
	@Bind(R.id.tab3_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
	Tab3ChefAdapter adapter;
	@Bind(R.id.tab3_stub) LinearLayout tab3_stub;
	@Bind(R.id.tab3_con_listview1) ListView tab3_con_listview1;
	@Bind(R.id.tab3_con_listview2) ListView tab3_con_listview2;	
	private float cont_tab3_height1;
	private float cont_tab3_height2;
	private final float alpa_float=0.4f;
	private final int alpa_anim_durtion=300;
	private ArrayList<CondtionAdapter.CondtionBean> contion_str1=new ArrayList<>();
	private ArrayList<CondtionAdapter.CondtionBean> contion_str2=new ArrayList<>();
	private int condtion_status=0;//条件筛选展示收起的状态
	private CondtionAdapter fliter_adapter1,fliter_adapter2;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab3;
	}
	
	@Override
	public void initWidget() {
		super.initWidget();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		adapter=new Tab3ChefAdapter(getActivity());
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.addItemDecoration(new Tab2RecDecoration());
		FontUtil.init(1, nav_bar_title1,nav_bar_title2,condition1,condition2);
		tab3_stub.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(condtion_status==0) return false;
				shadehidden();
				return true;
			}
		});
		makealpashade(tab3_con_listview1, 0);
		makealpashade(tab3_con_listview2, 0);
	}
	
	public void showChefs(ArrayList<ChefBean> chefs){
		ChefBean chefBean = chefs.get(1);
		Logger.e(chefBean.getCuisine()+"--"+chefBean.getMonicker()+"--"+chefBean.getGrade());
		adapter.setdata(chefs);
		//获取筛选条件
		getContion1(chefs);
	}

	private void getContion1(ArrayList<ChefBean> chefs) {
		contion_str2.clear();
		for(String fname:Common.TAB3_FILTER_STR){
			contion_str2.add(new CondtionBean(fname));
		}
		int s=AppUtil.dp2px(38)*(contion_str2.size());
		cont_tab3_height2=((float)s/alpa_float);//高度计算
		tab3_con_listview2.setTag(cont_tab3_height2);
		
		Set<String> set=new HashSet<String>();
		for(ChefBean chef:chefs){
			set.add(chef.getStyle_name());
		}
		contion_str1.clear();
		contion_str1.add(new CondtionBean("全部"));
		for(String fname:set){
			contion_str1.add(new CondtionBean(fname));
		}

		int s2=AppUtil.dp2px(38)*(contion_str1.size());
		cont_tab3_height1=((float)s2/alpa_float);
		tab3_con_listview1.setTag(cont_tab3_height1);
		
		fliter_adapter1=new CondtionAdapter(this, contion_str1);
		fliter_adapter2=new CondtionAdapter(this, contion_str2);
		tab3_con_listview1.setAdapter(fliter_adapter1);
		tab3_con_listview2.setAdapter(fliter_adapter2);
		tab3_con_listview1.setOnItemClickListener(this);
		tab3_con_listview2.setOnItemClickListener(this);
		fliter_adapter2.setSel(0);
		fliter_adapter1.setSel(0);
		
	}
	@OnClick(R.id.tab3_condition_1)
	public void condition1click(View v){
		if(condtion_status==1){
			shadehidden();
			if(curr_tab.getId()==tab3_con_listview2.getId()){
				v.postDelayed(new Runnable() {
					@Override
					public void run() {
						shadeShow(tab3_con_listview1);
					}
				}, alpa_anim_durtion);
			}
		}else{
			shadeShow(tab3_con_listview1);
		}
	}
	@OnClick(R.id.tab3_condition_2)
	public void condition2click(View v){
		if(condtion_status==1){
			shadehidden();
			if(curr_tab.getId()==tab3_con_listview1.getId()){
				v.postDelayed(new Runnable() {
					@Override
					public void run() {
						shadeShow(tab3_con_listview2);
					}
				}, alpa_anim_durtion);
			}
		}else{
			shadeShow(tab3_con_listview2);
		}	
	}
	private View curr_tab=tab3_con_listview1;
	//遮罩层展示
	public void shadeShow(View v){
		condtion_status=1;
		curr_tab=v;
		ValueAnimator setDuration = ValueAnimator.ofFloat(0.0f,alpa_float).setDuration(alpa_anim_durtion);
		setDuration.addUpdateListener(this);
		setDuration.start();
		
	}
	//遮罩层隐藏
	public void shadehidden(){
		condtion_status=0;
		ValueAnimator setDuration = ValueAnimator.ofFloat(alpa_float,0.0f).setDuration(alpa_anim_durtion);
		setDuration.addUpdateListener(this);
		setDuration.start();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		final String selname = ((CondtionAdapter)arg0.getAdapter()).setSel(arg2);
		shadehidden();
		condition1.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				if(curr_tab.equals(tab3_con_listview1)){
					condition1.setText(selname+"  Cuisine");
				}else{
					condition2.setText(selname+"  Sort");
				}
				adapter.filter(getfliterStr(condition1).trim(), getfliterStr(condition2).trim());
				
			}
		}, alpa_anim_durtion);
		
	}

	@Override
	public void onAnimationUpdate(ValueAnimator animation) {
		float f=(float)animation.getAnimatedValue();
		makealpashade(curr_tab, f);
		
	}
	@SuppressLint("NewApi")
	public void makealpashade(View v,float f){
		Drawable background = tab3_stub.getBackground();
		background.setAlpha((int)(255f*f));
		tab3_stub.setBackground(background);
		LayoutParams lm=(LinearLayout.LayoutParams)v.getLayoutParams();
		if(v.getTag()==null){
			lm.height=0;
			v.setLayoutParams(lm);
			return;
		}
		lm.height=(int) (((float)v.getTag())*f);
		v.setLayoutParams(lm);
		
	}
	public String getfliterStr(TextView tv){
		String text = tv.getText().toString();
		String string = text.split("  ")[0];
		Logger.e(string);
		if(string.equals("菜系")) string="全部";
		return string;
	}

}

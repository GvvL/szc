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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;

import com.aydc.szc.R;
import com.aydc.szc.adaper.CondtionAdapter;
import com.aydc.szc.adaper.CondtionAdapter.CondtionBean;
import com.aydc.szc.adaper.Tab2RecAdapter;
import com.aydc.szc.adaper.Tab2RecDecoration;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.AppUtil;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.util.Logger;

public class Tab2View extends ViewDelegate implements AnimatorUpdateListener,OnItemClickListener{
	@Bind(R.id.nav_bar_title1) TextView nav_bar_title1;
	@Bind(R.id.nav_bar_title2) TextView nav_bar_title2;
	@Bind(R.id.condition_1) TextView condition1;
	@Bind(R.id.condition_2) TextView condition2;
	
	@Bind(R.id.tab2_recycleView) RecyclerView mRecyclerView;
	@Bind(R.id.tab2_loading_framlayout) RelativeLayout loading_fram;
	@Bind(R.id.tab2_refresh) SwipeRefreshLayout mRefreshView;
	
	@Bind(R.id.tab2_stub) LinearLayout tab2_stub;
	@Bind(R.id.tab2_rlayout) RelativeLayout tab2_rlayout;
	@Bind(R.id.tab2_con_listview1) ListView tab2_con_listview1;
	@Bind(R.id.tab2_con_listview2) ListView tab2_con_listview2;
	private CondtionAdapter fliter_adapter1,fliter_adapter2;
	private int condtion_status=0;//条件筛选展示收起的状态
	Tab2RecAdapter adapter;
	private float cont_tab2_height1;
	private float cont_tab2_height2;
	private final float alpa_float=0.4f;
	private final int alpa_anim_durtion=300;
	private ArrayList<CondtionAdapter.CondtionBean> contion_str1=new ArrayList<>();
	private ArrayList<CondtionAdapter.CondtionBean> contion_str2=new ArrayList<>();//{"智能排序","价格","推荐人数","销售数量"};//智能排序  Sort ▼
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab2;
	}
	
	@Override
	public void initWidget() {
		super.initWidget();
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
		adapter=new Tab2RecAdapter(getActivity());
		mRecyclerView.setAdapter(adapter);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.addItemDecoration(new Tab2RecDecoration());
		FontUtil.init(1, nav_bar_title1,nav_bar_title2,condition1,condition2);
		tab2_stub.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(condtion_status==0) return false;
				shadehidden();
				return true;
			}
		});
		makealpashade(tab2_con_listview1, 0);
		makealpashade(tab2_con_listview2, 0);
		
	}
	
	public void showDishes(ArrayList<DishBean> dishes){
		adapter.setData(dishes);
		//获取筛选条件
		getContion1(dishes);
	}
	//获取条件个数
	private void getContion1(ArrayList<DishBean> dishes) {
		contion_str2.clear();
		for(String fname:Common.TAB2_FILTER_STR){
			contion_str2.add(new CondtionBean(fname));
		}
		int s=AppUtil.dp2px(38)*(contion_str2.size());
		cont_tab2_height2=((float)s/alpa_float);//高度计算
		tab2_con_listview2.setTag(cont_tab2_height2);
		
		Set<String> set=new HashSet<String>();
		for(DishBean dish:dishes){
			set.add(dish.getType_title());
		}
		contion_str1.clear();
		contion_str1.add(new CondtionBean("全部"));
		for(String fname:set){
			contion_str1.add(new CondtionBean(fname));
		}

		int s2=AppUtil.dp2px(38)*(contion_str1.size());
		cont_tab2_height1=((float)s2/alpa_float);
		tab2_con_listview1.setTag(cont_tab2_height1);
		
		fliter_adapter1=new CondtionAdapter(this, contion_str1);
		fliter_adapter2=new CondtionAdapter(this, contion_str2);
		tab2_con_listview1.setAdapter(fliter_adapter1);
		tab2_con_listview2.setAdapter(fliter_adapter2);
		tab2_con_listview1.setOnItemClickListener(this);
		tab2_con_listview2.setOnItemClickListener(this);
		fliter_adapter2.setSel(0);
		fliter_adapter1.setSel(0);
		
	}

	@OnClick(R.id.condition_1)
	public void condition1click(View v){
		if(condtion_status==1){
			shadehidden();
			if(curr_tab.getId()==tab2_con_listview2.getId()){
				v.postDelayed(new Runnable() {
					@Override
					public void run() {
						shadeShow(tab2_con_listview1);
					}
				}, alpa_anim_durtion);
			}
		}else{
			shadeShow(tab2_con_listview1);
		}
	}
	@OnClick(R.id.condition_2)
	public void condition2click(View v){
		if(condtion_status==1){
			shadehidden();
			if(curr_tab.getId()==tab2_con_listview1.getId()){
				v.postDelayed(new Runnable() {
					@Override
					public void run() {
						shadeShow(tab2_con_listview2);
					}
				}, alpa_anim_durtion);
			}
		}else{
			shadeShow(tab2_con_listview2);
		}

		
	}
	private View curr_tab=tab2_con_listview1;
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
	public void onAnimationUpdate(ValueAnimator animation) {
		float f=(float)animation.getAnimatedValue();
		makealpashade(curr_tab, f);
	}
	@SuppressLint("NewApi")
	public void makealpashade(View v,float f){
		Drawable background = tab2_stub.getBackground();
		background.setAlpha((int)(255f*f));
		tab2_stub.setBackground(background);
		LayoutParams lm=(LinearLayout.LayoutParams)v.getLayoutParams();
		if(v.getTag()==null){
			lm.height=0;
			v.setLayoutParams(lm);
			return;
		}
		lm.height=(int) (((float)v.getTag())*f);
		v.setLayoutParams(lm);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		final String selname = ((CondtionAdapter)arg0.getAdapter()).setSel(arg2);
		shadehidden();
		condition1.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				if(curr_tab.equals(tab2_con_listview1)){
					condition1.setText(selname+"  Cuisine");
				}else{
					condition2.setText(selname+"  Sort");
				}
				adapter.filter(getfliterStr(condition1), getfliterStr(condition2));
				
			}
		}, alpa_anim_durtion);

	}
	public String getfliterStr(TextView tv){
		String text = tv.getText().toString();
		String string = text.split("  ")[0];
		Logger.e(string);
		if(string.equals("品类")) string="全部";
		return string;
	}


}

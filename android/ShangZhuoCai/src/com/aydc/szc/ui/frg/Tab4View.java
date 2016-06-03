package com.aydc.szc.ui.frg;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.TextView;
import butterknife.Bind;

import com.aydc.szc.R;
import com.aydc.szc.adaper.Tab4LikeAdapter;
import com.aydc.szc.adaper.Tab4LikeDecoration;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.util.Logger;

public class Tab4View extends ViewDelegate{
	@Bind(R.id.tab4_nav_bar_title1) TextView nav_bar_title1;
	@Bind(R.id.tab4_nav_bar_title2) TextView nav_bar_title2;
	@Bind(R.id.tab4_rcv_recommend) RecyclerView rc_view;
	@Bind(R.id.tab4_swipeRefreshLayout) SwipeRefreshLayout mSwipeRefreshLayout;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab4;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		
		FontUtil.init(1, nav_bar_title1,nav_bar_title2);
		LinearLayoutManager llm=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
		rc_view.setLayoutManager(llm);
		rc_view.setAdapter(new Tab4LikeAdapter(getActivity()));
		rc_view.addItemDecoration(new Tab4LikeDecoration());
		rc_view.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView,
					int newState) {
				Logger.e(newState+"");
				if(newState==1){
					mSwipeRefreshLayout.setEnabled(false);
				}else{
					mSwipeRefreshLayout.setEnabled(true);
				}
				super.onScrollStateChanged(recyclerView, newState);
			}
			
		});
	}

}

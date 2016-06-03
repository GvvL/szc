package com.aydc.szc.ui.frg;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import com.aydc.szc.R;
import com.aydc.szc.adaper.RecommendAdapter;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.CarouselBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.entity.Tab1Bean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.widget.CircleIndicator;
import com.aydc.szc.widget.MImageCycleView;
import com.aydc.szc.widget.MListView;
import com.aydc.szc.widget.MScrollViewExtend;
import com.aydc.szc.widget.MImageCycleView.ImageInfo;
import com.aydc.szc.widget.MImageCycleView.LoadImageCallBack;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Tab1View extends ViewDelegate{
	@Bind(R.id.nar_bar_address)
	TextView tv_address;
	
	@Bind(R.id.imagecycle)
	MImageCycleView imageCycle;
	@Bind(R.id.indicator)
	CircleIndicator indicator;//知识器
	
	@Bind(R.id.id_listview)
	MListView mListView;
	@Bind(R.id.scrollview)
	MScrollViewExtend scroll;
	
	
	@Bind(R.id.tab1_recommend_zh)
	TextView tv_recommend_zh;
	@Bind(R.id.tab1_recommend_en)
	TextView tv_recommend_en;
	
	@Bind(R.id.tab1_refresh)
	SwipeRefreshLayout mSwipeRefreshLayout;
	
	@Bind(R.id.tab1_loading_framlayout) RelativeLayout loading_framlayout;
	
	RecommendAdapter adapter;
	@Override
	public int getRootLayoutId() {
		return R.layout.frg_tab1;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		FontUtil.init(1, tv_address,tv_recommend_zh);
		FontUtil.init(2, tv_recommend_en);
		
		imageCycle.setNestParent(mSwipeRefreshLayout);
		mSwipeRefreshLayout.setColorSchemeColors(Color.BLACK);

		
		
	}
	public void showData(Tab1Bean bean){
		if(loading_framlayout.VISIBLE==View.VISIBLE) loading_framlayout.setVisibility(View.GONE);
		this.showAdv(bean.getCarousels());
		this.showDishes(App.dishes);
		
		
	}
	
	
	
	private void showDishes(ArrayList<DishBean> dishes) {
		if(adapter==null){
			adapter=new RecommendAdapter(getActivity(), dishes);
			mListView.setAdapter(adapter);
		} else{
			adapter.setdata(dishes);
			adapter.notifyDataSetChanged();
		}

	}
	public void showAdv(ArrayList<CarouselBean> list){
		
		List<MImageCycleView.ImageInfo> imglist=new ArrayList<>();
		for(CarouselBean cb:list){
			imglist.add(new ImageInfo(cb.getImg(), "", ""));
		}
		
		imageCycle.loadData(imglist, new LoadImageCallBack() {
			@Override
			public View loadAndDisplay(ImageInfo imageInfo) {
				ImageView imageview=new ImageView(getActivity());
				imageview.setScaleType(ScaleType.FIT_XY);
				//缓存到本地
				Glide.with(getActivity().getApplicationContext())
					.load(Common.RELEAST_HOST+imageInfo.image)
					.diskCacheStrategy(DiskCacheStrategy.ALL)
					.placeholder(R.drawable.test_cart)
					.into(imageview);
				return imageview;
			}
		});
		imageCycle.hindBottomText();
		indicator.setViewPager(imageCycle.getIndicatorVP());
	}


}

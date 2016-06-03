package com.aydc.szc.ui;


import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.Bind;

import com.aydc.szc.R;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.util.Logger;
import com.aydc.szc.widget.MScrollViewExtend;
import com.aydc.szc.widget.MScrollViewExtend.OnScrollListener;

public class GoodsDetailView extends ViewDelegate implements OnScrollListener{

	@Bind(R.id.title_bar2) RelativeLayout title_bar2;
	@Bind(R.id.title_bar1) RelativeLayout title_bar1;

	
	@Bind(R.id.title_bar2_bgview) View title_bar2_bg;
	
	@Bind(R.id.goods_scroll_view) MScrollViewExtend mScrollView;
	
	@Bind(R.id.goods_name) TextView goods_name1;
	
	@Bind(R.id.goods_video) VideoView goods_video;
	
	@Bind(R.id.bar_left) TextView bar_left;
	@Bind(R.id.bar_share) TextView bar_share;
	@Bind(R.id.bar_cart) TextView bar_cart;
	@Bind(R.id.bar_title) TextView bar_title;
	@Bind(R.id.goods_img) ImageView goods_img;
	
	
	@Override
	public int getRootLayoutId() {
		return R.layout.act_goodsdetail;
	}
	
	@Override
	public void initWidget() {
		super.initWidget();
		mScrollView.setOnScrollListener(this);
		FontUtil.init(1, goods_name1,bar_title);
		FontUtil.init(0, bar_left,bar_share,bar_cart);
	}

	@Override
	public void onScroll(int scrollY) {
	}
	int change_flag_height;
	public void mesearHeight(){
		change_flag_height=(goods_img.getMeasuredHeight()-title_bar2_bg.getMeasuredHeight())/2;
	}
	@Override
	public void onScrollReal(int rY) {
		if(rY<change_flag_height){
			setIconColor(Color.WHITE);
			title_bar2_bg.setAlpha(0f);
			return;
		}
		if(rY>change_flag_height*2){
			setIconColor(Color.BLACK);
			title_bar2_bg.setAlpha(1f);
			bar_title.setVisibility(View.VISIBLE);
			return;
		}
		bar_title.setVisibility(View.INVISIBLE);
		float al=(float)(rY-change_flag_height)/(float)change_flag_height;
		title_bar2_bg.setAlpha(al);
		int sc=change_flag_height/14;
		int cn=(rY-change_flag_height)/sc;
		Logger.e(cn+"??"+Integer.valueOf(Integer.toHexString(1118481*cn), 16));
		setIconColor(Color.WHITE-Integer.valueOf(Integer.toHexString(1118481*cn), 16));
		Logger.e((0xffffffff-0xffeeeeee)+"--"+(0xffeeeeee-0xffdddddd));
		Logger.e((0xffffffff-0xff000000)/15+"--");
	}

	public void showData(DishBean dishBean) {
//		Uri.parse(uriString);
//		goods_video.setVideoURI(uri);
//		goods_video.setMediaController(new MediaController(getActivity()));
	}
	
	private void setIconColor(int color){
		bar_left.setTextColor(color);
		bar_share.setTextColor(color);
		bar_cart.setTextColor(color);
	}

}

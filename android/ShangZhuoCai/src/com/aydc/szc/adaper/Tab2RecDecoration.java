package com.aydc.szc.adaper;

import com.aydc.szc.util.AppUtil;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
/**
 * recycle间隔
 * @author Administrator
 *
 */
public class Tab2RecDecoration extends ItemDecoration{
	
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
			State state) {
		outRect.top=AppUtil.designedDP2px(10);
	}

}

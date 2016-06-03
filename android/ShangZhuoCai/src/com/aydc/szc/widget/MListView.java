package com.aydc.szc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MListView extends ListView{

	public MListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(10000, MeasureSpec.AT_MOST));
		
	}

}

package com.aydc.szc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MGridView extends GridView{

	public MGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(10000, MeasureSpec.AT_MOST));
		
	}

}

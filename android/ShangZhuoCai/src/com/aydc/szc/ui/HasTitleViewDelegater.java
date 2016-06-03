package com.aydc.szc.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.aydc.szc.R;
import com.aydc.szc.fram.ViewDelegate;
import com.aydc.szc.util.FontUtil;

public class HasTitleViewDelegater extends ViewDelegate{

	@Override
	public int getRootLayoutId() {
		return 0;
	}
	@Override
	public void initWidget() {
		super.initWidget();
		TextView title=get(R.id.nav_bar_title);
		FontUtil.init(1, title);
		get(R.id.nav_bar_left).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActivity().finish();
			}
		});
	}
}

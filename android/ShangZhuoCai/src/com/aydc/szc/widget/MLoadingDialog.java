package com.aydc.szc.widget;





import com.aydc.szc.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;



/**
 * 不带文字
 *
 */
public class MLoadingDialog extends Dialog {
	private Context context;
	private RotateAnimation mAnim;
	private LinearLayout mll;
	


	public MLoadingDialog(Context context) {
		super(context, R.style.Dialog_bocop);
		this.context=context;
		init();
	}

	private void init() {
		View contentView = View.inflate(getContext(), R.layout.lgloding_dialog, null);
		setContentView(contentView);
		mll=(LinearLayout) findViewById(R.id.lg_loading_dialog_ll);
//		initAnim();
//		getWindow().setWindowAnimations(R.anim.alpha_in);
	}
	
	
	private void initAnim() {
		mAnim = new RotateAnimation(360, 0,Animation.RESTART, 0.5f, Animation.RESTART,0.5f);
		mAnim.setDuration(2000);
		mAnim.setRepeatCount(Animation.INFINITE);
		mAnim.setRepeatMode(Animation.RESTART);
		mAnim.setStartTime(Animation.START_ON_FIRST_FRAME);
	}

	@Override
	public void show() {
		super.show();
	}
	
	@Override
	public void dismiss() {
		Animation anim=AnimationUtils.loadAnimation(context, R.anim.right_out);
		mll.startAnimation(anim);
		anim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				MLoadingDialog.super.dismiss();
			}
		});
		super.dismiss();
		
	}
	
	
	@Override
	public void setCancelable(boolean flag) {
		super.setCancelable(flag);
	}
	
	@Override
	public void setTitle(CharSequence title) {
//		tv.setText(title);
	}
	
	@Override
	public void setTitle(int titleId) {
		setTitle(getContext().getString(titleId));
	}
}

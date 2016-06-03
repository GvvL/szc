package com.aydc.szc.util;

import com.aydc.szc.R;
import com.aydc.szc.fram.ViewDelegate;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AnimUtil {
	
	private AnimUtil() {
	}
	private static AnimUtil instance=new AnimUtil();
	public static AnimUtil getInstance(){
		return instance;
	}
	public void cartAnim(ViewDelegate act,View fromView,View toView,AnimCallBack callback){
		fromToAnim(act, fromView, toView, 0, 650, callback);
	}
	private Animation cartanimfrom;
	private Animation cartanimto;
	
	public void fromToAnim(final ViewDelegate vd,View fromView,final View toView,int startoffset,int duration,final AnimCallBack callback){
		if(cartanimfrom==null){
			cartanimfrom=AnimationUtils.loadAnimation(vd.getActivity(), R.anim.cart_anim1);
		}
		if(cartanimto==null){
			cartanimto=AnimationUtils.loadAnimation(vd.getActivity(), R.anim.cart_anim2);
		}
		fromView.startAnimation(cartanimfrom);
		
		int[] start_position=new int[2];
		int[] end_position=new int[2];
		fromView.getLocationInWindow(start_position);
		toView.getLocationInWindow(end_position);
		end_position[0]+=toView.getMeasuredWidth()/2;
		end_position[1]+=toView.getMeasuredHeight()/2;
		
		
		final ImageView img=new ImageView(vd.getActivity());
		img.setBackgroundResource(R.drawable.icon_cart);
		LinearLayout.LayoutParams layoutP=new LinearLayout.LayoutParams(-2, -2);
		layoutP.leftMargin=start_position[0];
		layoutP.topMargin=start_position[1];
		img.setLayoutParams(layoutP);
		final LinearLayout createAnimFrame = createAnimFrame(vd.getActivity());
		createAnimFrame.addView(img);
		
		TranslateAnimation trX=new TranslateAnimation(0, end_position[0]-start_position[0], 0, 0);
		TranslateAnimation trY=new TranslateAnimation(0, 0, 0, end_position[1]-start_position[1]);
		trY.setInterpolator(new DecelerateInterpolator(1.4f));
		trX.setInterpolator(new LinearInterpolator());
		AnimationSet set=new AnimationSet(false);
		set.addAnimation(trX);
		set.addAnimation(trY);
		set.setStartOffset(startoffset);
		set.setDuration(duration);
		img.startAnimation(set);
		set.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				toView.startAnimation(AnimUtil.this.cartanimto);
				if(callback!=null) callback.animEnd(animation);
				createAnimFrame.removeAllViews();
			}
		});
		
	}
	/**
	 * 创建动画层
	 * @param act
	 * @return
	 */
	private LinearLayout createAnimFrame(Activity act) {
		LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1, -1);
		LinearLayout animFrame=new LinearLayout(act);
		animFrame.setLayoutParams(lp);
		animFrame.setBackgroundColor(Color.TRANSPARENT);
		((ViewGroup)act.getWindow().getDecorView()).addView(animFrame);
		return animFrame;
	}
	public static interface AnimCallBack{
//		void animStart(Animation animation);
		void animEnd(Animation animation);
	}

}

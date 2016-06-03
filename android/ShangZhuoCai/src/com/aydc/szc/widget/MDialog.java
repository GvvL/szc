package com.aydc.szc.widget;



import com.aydc.szc.R;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;




public class MDialog extends Dialog implements android.view.View.OnClickListener {
	private ButtonRespond respond;

	private TextView tvDialogtitle;// 对话框标题
	private TextView tvDialogMassage;// 对话框信息
	private Button btLeft;// 左边按钮
	private Button btRight;// 右边按钮
	private LinearLayout llFreame;// 空壳view对象
	private LinearLayout mainll;

	public MDialog(Context context, ButtonRespond respond) {
		super(context, R.style.custom_dialog);
		this.respond = respond;
		setContentView(R.layout.m_dialog);
		initView();
		setCanceledOnTouchOutside(false);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutParams p = getWindow().getAttributes();

		getWindow().setAttributes(p);
		getWindow().setGravity(Gravity.CENTER);

	}
	@Override
	public void show() {
		tvDialogMassage.setScaleY(0);
		super.show();
		tvDialogMassage.animate().scaleY(1).setDuration(600).start();
	}
	@Override
	public void dismiss() {
		super.dismiss();
		
	}

	@Override
	public void cancel() {
		super.cancel();
	}

	/**
	 * 组件初始化
	 */
	private void initView() {

		tvDialogtitle = (TextView) this.findViewById(R.id.tv_dialog_title);
		tvDialogMassage = (TextView) this.findViewById(R.id.tv_dialog_massage);
		llFreame = (LinearLayout) this.findViewById(R.id.ll_frame);
		mainll=(LinearLayout) this.findViewById(R.id.mainll);
		btLeft = (Button) this.findViewById(R.id.bt_left);
		btLeft.setOnClickListener(this);
		btRight = (Button) this.findViewById(R.id.bt_right);
		btRight.setOnClickListener(this);
		tvDialogMassage.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		LayoutTransition lt=new LayoutTransition();
		ObjectAnimator anim = ObjectAnimator.ofFloat(this, "scaleY", 1,0);
		anim.setDuration(800);
		lt.setAnimator(LayoutTransition.DISAPPEARING, anim);
		mainll.setLayoutTransition(lt);
	}

	/**
	 * 设置对话框标题
	 * 
	 * @param resouseId
	 *            资源id
	 */
	public void setDialogTitle(int resouceId) {
		tvDialogtitle.setText(resouceId);
	}

	/**
	 * 设置对话框标题
	 * 
	 * @param titleStr
	 *            标题
	 */
	public void setDialogTitle(String titleStr) {
		tvDialogtitle.setText(titleStr);
	}

	/**
	 * 设置对话框提示信息
	 * 
	 * @param resouceID
	 *            资源ID
	 */
	public void setDialogMassage(int resouceID) {
		tvDialogMassage.setText(resouceID);
	}

	/**
	 * 设置对话框提示信息
	 * 
	 * @param massage
	 *            提示信息
	 */
	public void setDialogMassage(String massage) {
		tvDialogMassage.setText(massage);
	}

	/**
	 * 设置左边按钮文字
	 * 
	 * @param resouceId
	 *            资源id
	 */
	public void setLeftButtonText(int resouceId) {
		btLeft.setText(resouceId);
	}

	/**
	 * 设置左边按钮文字
	 * 
	 * @param text
	 *            按钮文字
	 */
	public void setLeftButtonText(String text) {
		btLeft.setText(text);
	}

	/**
	 * 设置右边按钮文字
	 * 
	 * @param resuoceId
	 *            资源id
	 */
	public void setRightButtonText(int resuoceId) {
		btRight.setText(resuoceId);
	}

	/**
	 * 设置右边按钮文字
	 * 
	 * @param text
	 *            按钮文字
	 */
	public void setRightButtonText(String text) {
		btRight.setText(text);
	}

	/**
	 * 设置文字信息界面是否可见
	 * 
	 * @param visibility
	 */
	public void setMagssageViewVisibility(int visibility) {
		tvDialogMassage.setVisibility(visibility);
	}

	/**
	 * 框架界面是否可见
	 * 
	 * @param visibility
	 */
	public void setFrameViewVisibility(int visibility) {
		llFreame.setVisibility(visibility);
	}

	/**
	 * 给空壳LinearLayout添加布局文件
	 * 
	 * @param view
	 */
	public void addView2Frame(View view) {
		llFreame.addView(view, 0);
	}

	/**
	 * 设置左边按钮的背景
	 * 
	 * @param resid
	 */
	public void setLeftButonBackgroud(int resid) {
		btLeft.setBackgroundResource(resid);
	}

	/**
	 * 设置右边按钮的背景
	 * 
	 * @param resid
	 */
	public void setRightButonBackgroud(int resid) {
		btRight.setBackgroundResource(resid);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_left:
			respond.buttonLeftRespond();
			this.cancel();
			break;
		case R.id.bt_right:
			respond.buttonRightRespond();
			this.cancel();
			break;
		default:
			break;
		}

	}
	public void setButtonRespond(ButtonRespond rs){
		this.respond=rs;
	}

	public interface ButtonRespond {
		public void buttonLeftRespond();

		public void buttonRightRespond();

	}
}


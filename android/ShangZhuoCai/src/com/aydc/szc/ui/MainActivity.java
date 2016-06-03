package com.aydc.szc.ui;

import java.util.ArrayList;
import java.util.List;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aydc.szc.R;
import com.aydc.szc.app.App;
import com.aydc.szc.app.Common;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.ui.frg.Tab1Presenter;
import com.aydc.szc.ui.frg.Tab2Presenter;
import com.aydc.szc.ui.frg.Tab3Presenter;
import com.aydc.szc.ui.frg.Tab4Presenter;
import com.aydc.szc.ui.frg.Tab6Presenter;
import com.aydc.szc.util.ActManager;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.util.Logger;
import com.aydc.szc.widget.MViewPage;


public class MainActivity extends FragmentActivity implements OnPageChangeListener,OnClickListener{
	RadioButton rb1,rb2,rb3,rb4,rb6;
	MViewPage viewpager;
	
	FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	RadioGroup rg;
	
	private ImageButton img_cart;
	private TextView tv_cart;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);
		makeBarTranslucent();
		img_cart=(ImageButton) findViewById(R.id.img_cart);
		tv_cart=(TextView) findViewById(R.id.tv_cart);
		img_cart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(CartModel.getCartNum()==0) return;
				Intent intent=new Intent(MainActivity.this, CartActivity.class);
				startActivity(intent);
			}
		});
		
		ActManager.getInstance().addActivity2Stack(this);
		rg=(RadioGroup) findViewById(R.id.radiogroup);
		rb1=(RadioButton) findViewById(R.id.id_tab_bottom_1);
		rb2=(RadioButton) findViewById(R.id.id_tab_bottom_2);
		rb3=(RadioButton) findViewById(R.id.id_tab_bottom_3);
		rb4=(RadioButton) findViewById(R.id.id_tab_bottom_4);
//		rb5=(RadioButton) findViewById(R.id.id_tab_bottom_5);
		rb6=(RadioButton) findViewById(R.id.id_tab_bottom_6);
		viewpager=(MViewPage) findViewById(R.id.id_viewpager);
		FontUtil.init(1, rb1,rb2,rb3,rb4,rb6);
		rb1.setChecked(true);
		viewpager.setOnPageChangeListener(this);
		viewpager.setOffscreenPageLimit(5);//fragment初始化数据放入setuser
		initViewPager();
		rb1.setOnClickListener(this);
		rb2.setOnClickListener(this);
		rb3.setOnClickListener(this);
		rb4.setOnClickListener(this);
//		rb5.setOnClickListener(this);
		rb6.setOnClickListener(this);
		
	}
	private int flag_cart_num=0;
	//购物车刷新
	public void refeshCart(){
		if(CartModel.getCartNum()==0){
			tv_cart.setVisibility(View.GONE);
			return;
		} 
		int cartNum = CartModel.getCartNum();
		if(cartNum>flag_cart_num){
			flag_cart_num=cartNum;
			animCart();
		}else if(cartNum<flag_cart_num){
			flag_cart_num=cartNum;
		}
		tv_cart.setVisibility(View.VISIBLE);
		tv_cart.setText(cartNum+"");
	}
	//购书车动画
	public void animCart(){
		Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.cart_anim3);
		img_cart.startAnimation(loadAnimation);
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		refeshCart();
		if(OrdersActivity.ORDER_JUMP){
			Intent intent=new Intent();
			intent.setClass(this, OrdersActivity.class);
			startActivity(intent);
		}
		
	}

	private void initViewPager() {
		Tab1Presenter tab1=new Tab1Presenter();
		Tab2Presenter tab2=new Tab2Presenter();
		Tab3Presenter tab3=new Tab3Presenter();
		Tab4Presenter tab4=new Tab4Presenter();
//		Tab5Presenter tab5=new Tab5Presenter();
		Tab6Presenter tab6=new Tab6Presenter();
		mFragments.add(tab1);
		mFragments.add(tab2);
		mFragments.add(tab3);
		mFragments.add(tab4);
//		mFragments.add(tab5);
		mFragments.add(tab6);
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{
			@Override
			public int getCount()
			{
				return mFragments.size();
			}
			@Override
			public Fragment getItem(int arg0)
			{
				return mFragments.get(arg0);
			}
		};
		viewpager.setAdapter(mAdapter);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		if(arg0==4){
			img_cart.setVisibility(View.INVISIBLE);
			tv_cart.setVisibility(View.INVISIBLE);
		}else{
			img_cart.setVisibility(View.VISIBLE);
			refeshCart();
		}
	}

	@Override
	public void onPageSelected(int arg0) {
		switch (arg0) {
		case 0:
			rb1.setChecked(true);
			break;
		case 1:
			rb2.setChecked(true);
			break;
		case 2:
			rb3.setChecked(true);
			break;
		case 3:
			rb4.setChecked(true);
			break;
		case 4:
			rb6.setChecked(true);
			break;
//		case 5:
//			rb6.setChecked(true);
//			break;
		default:
			break;
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_tab_bottom_1:
			viewpager.setCurrentItem(0,false);
			break;
		case R.id.id_tab_bottom_2:
			viewpager.setCurrentItem(1,false);
			break;
		case R.id.id_tab_bottom_3:
			viewpager.setCurrentItem(2,false);
			break;
		case R.id.id_tab_bottom_4:
			viewpager.setCurrentItem(3,false);
			break;
//		case R.id.id_tab_bottom_5:
//			viewpager.setCurrentItem(5,false);
//			break;
		case R.id.id_tab_bottom_6:
			viewpager.setCurrentItem(4,false);
			break;
		default:
			break;
		}
		
	}
	
	public void makeBarTranslucent(){
		if(Common.TRANSTYPE==Common.NOTRANS) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // 透明上部状态栏
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明下部导航栏
            if(Common.TRANSTYPE==Common.TRANSTOP) return;
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
	}
	
	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		Logger.e("进入后台");
		App.getInstance().isActive=false;
	}
	@Override
	public void startActivity(Intent intent) {
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
		super.startActivity(intent);
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus){
//			createCartBtn(rb5);
		}
	}
	

	public void createCartBtn(View v){
		WindowManager wm=(WindowManager) getApplication().getSystemService(WINDOW_SERVICE);
		App.getInstance().btn_cart=new ImageButton(getApplicationContext());
		App.getInstance().btn_cart.setImageResource(R.drawable.ic_tab5_off);
		App.getInstance().btn_cart.setBackgroundResource(R.drawable.act_goods_left_arrow);
		App.getInstance().btn_cart.setScaleX(0.6f);
		App.getInstance().btn_cart.setScaleY(0.6f);
		LayoutParams layoutParams = new WindowManager.LayoutParams();
		layoutParams.width=70;
		layoutParams.height=70;
		int[] lacPo=new int[2];
		v.getLocationInWindow(lacPo);
		layoutParams.x=lacPo[0]+46;
		layoutParams.y=lacPo[1]-74;
		layoutParams.gravity=Gravity.TOP|Gravity.LEFT;
		Logger.e("购物车位置："+lacPo[0]+":"+lacPo[1]);
		layoutParams.type=WindowManager.LayoutParams.TYPE_TOAST;
		layoutParams.format=PixelFormat.RGBA_8888;
		layoutParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL  
                | LayoutParams.FLAG_NOT_FOCUSABLE;
		wm.addView(App.getInstance().btn_cart, layoutParams);
		App.getInstance().btn_cart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(App.getInstance().currActivity.get()!=null) Logger.e("购物车");
			}
		});
		
	}

}

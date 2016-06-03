package com.aydc.szc.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.aydc.szc.R;

/**
 * 
 * 自定义图片自动轮播控件，自定轮播指示器样式，支持点击，无限轮播，网络下载图片</br>
 * 可是使用XUtil的BitmapUtils也可是使用smart-image-view加载图片，支持轮播文字切换</br>
 * 此插件是基于viewpager实现的,需要导入android-support-v4.jar</br></br>
 *
 * 如果使用网络图片记得加权限。</br> uses-permission
 * android:name="android.permission.INTERNET" uses-permission
 * android:name="android.permission.WRITE_EXTERNAL_STORAGE"
 *
 * 主要功能:</br></br> 1.支持设置文字提示</br>
 * 2.支持修改轮播指示器的样式及位置（修改view_cycle_image.xml样式,不能修改id）</br>
 * 3.支持修改文字提样式及位置（修改view_cycle_image.xml样式,不能修改id）</br> 4.支持设置是否开启自动轮播</br>
 * 5.支持运行中启动和停止自动轮播</br> 6.支持网络加载图片，资源图片id，sd卡图片</br>
 * 7.设置支持XUtil的BitmapUtils也可是使用smart-image-view加载图片</br> 8.支持点击事件</br>
 * 9.默认是第一张</br></br>
 *
 * demo实例:</br> </br>
 *
 * List<ImageCycleView.ImageInfo> list=new
 * ArrayList<ImageCycleView.ImageInfo>(); mImageCycleView = (ImageCycleView)
 * findViewById(R.id.icv_topView);
 * 
 * //避免网络图片和本地图片混合使用，特殊要求可在ImageCycleView.LoadImageCallBack回调中判断处理
 * //判断是数字加载本地图片，是http请求加载网络图片 List<ImageCycleView.ImageInfo> list=new
 * ArrayList<ImageCycleView.ImageInfo>();
 * 
 * //使用本地图片 //list.add(new
 * ImageCycleView.ImageInfo(R.drawable.a1,"111111111111","")); //list.add(new
 * ImageCycleView.ImageInfo(R.drawable.a2,"222222222222222","")); //list.add(new
 * ImageCycleView.ImageInfo(R.drawable.a3,"3333333333333",""));
 * 
 * //SD卡图片资源 list.add(new ImageCycleView.ImageInfo(new
 * File(Environment.getExternalStorageDirectory(),"a1.jpg"),"11111",""));
 * list.add(new ImageCycleView.ImageInfo(new
 * File(Environment.getExternalStorageDirectory(),"a2.jpg"),"22222",""));
 * list.add(new ImageCycleView.ImageInfo(new
 * File(Environment.getExternalStorageDirectory(),"a3.jpg"),"33333",""));
 * 
 * //使用网络加载图片 list.add(new ImageCycleView.ImageInfo(
 * "http://img.lakalaec.com/ad/57ab6dc2-43f2-4087-81e2-b5ab5681642d.jpg"
 * ,"3333333333333","")); list.add(new ImageCycleView.ImageInfo(
 * "http://img.lakalaec.com/ad/cb56a1a6-6c33-41e4-9c3c-363f4ec6b728.jpg"
 * ,"222222222222222","")); list.add(new ImageCycleView.ImageInfo(
 * "http://img.lakalaec.com/ad/e4229e25-3906-4049-9fe8-e2b52a98f6d1.jpg"
 * ,"3333333333333",""));
 * 
 * 
 * mImageCycleView.loadData(list, new ImageCycleView.LoadImageCallBack() {
 * 
 * @Override public ImageView loadAndDisplay(ImageCycleView.ImageInfo
 *           imageInfo){
 * 
 *           //本地图片 //ImageView imageView=new ImageView(MainActivity.this);
 *           //imageView
 *           .setImageResource(Integer.parseInt(imageInfo.image.toString()));
 *           //return imageView;
 * 
 *           //使用SD卡图片 SmartImageView smartImageView=new
 *           SmartImageView(MainActivity.this);
 *           smartImageView.setImageURI(Uri.fromFile((File)imageInfo.image));
 *           return smartImageView;
 * 
 *           //使用SmartImageView //SmartImageView smartImageView=new
 *           SmartImageView(MainActivity.this);
 *           //smartImageView.setImageResource
 *           (Integer.parseInt(imageInfo.image.toString())); //return
 *           smartImageView;
 * 
 *           //使用BitmapUtils BitmapUtils bitmapUtils=new
 *           BitmapUtils(MainActivity.this); ImageView imageView=new
 *           ImageView(MainActivity.this);
 *           bitmapUtils.display(imageView,imageInfo.image.toString()); return
 *           imageView; } });
 *
 */
public class MImageCycleView extends FrameLayout {

	/**
	 * 是否显示底部信息
	 */
	public void hindBottomText() {
		mGroup.setVisibility(View.GONE);
		mIndicationGroup.setVisibility(View.GONE);
		mText.setVisibility(View.GONE);
	}

	/**
	 * 上下文
	 */
	private Context mContext;
	/**
	 * 图片轮播视图
	 */
	public ImageCycleViewPager mViewPager;
	/**
	 * 数据集合 Map<String,String> map=new HashMap<String, String>();
	 * map.put("","");
	 *
	 */
	private List<ImageInfo> data = new ArrayList<ImageInfo>();
	/**
	 * 加载图片回调函数
	 */
	private LoadImageCallBack mLoadImageCallBack;

	/**
	 * 图片轮播指示器容器
	 */
	private LinearLayout mIndicationGroup;
	/**
	 * 包括指示和文字的ll
	 */
	private LinearLayout mGroup;
	/**
	 * 轮播的总数
	 */
	private int mCount = 0;
	/**
	 * 未获得焦点指示器资源
	 */
	private Bitmap unFocusIndicationStyle;
	/**
	 * 获得焦点指示器资源
	 */
	private Bitmap focusIndicationStyle;
	/**
	 * 指示器间距相对于自身的百分比,默认间距为指示器高度的1/2
	 */
	private float indication_self_margin_percent = 0.5f;
	/**
	 * 单击事件监听器
	 */
	private OnPageClickListener mOnPageClickListener;
	/**
	 * 图片文本提示
	 */
	private TextView mText;

	public MImageCycleView(Context context) {
		super(context);
		init(context);
	}

	public MImageCycleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	/**
	 * 初始化基础信息
	 * 
	 * @param context
	 */
	private void init(Context context) {
		mContext = context;
		unFocusIndicationStyle = drawCircle(50, Color.GRAY);
		focusIndicationStyle = drawCircle(50, Color.WHITE);
		initView();
	}

	/**
	 * 初始化view控件
	 */
	@SuppressWarnings("deprecation")
	private void initView() {
		View.inflate(mContext, R.layout.frg_tab1_view_cycle, this);
		FrameLayout fl_image_cycle = (FrameLayout) findViewById(R.id.fl_image_cycle);
		mViewPager = new ImageCycleViewPager(mContext);
		mViewPager.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));
		fl_image_cycle.addView(mViewPager);
		mViewPager.setOnPageChangeListener(new ImageCyclePageChangeListener());
		mIndicationGroup = (LinearLayout) findViewById(R.id.ll_indication_group);
		mGroup = (LinearLayout) findViewById(R.id.ll_group);
		mText = (TextView) findViewById(R.id.tv_text);
	}

	public enum IndicationStyle {
		COLOR, IMAGE
	}

	public ImageCycleViewPager getIndicatorVP() {
		return mViewPager;
	}

	/**
	 * 设置轮播指示器样式，如果你对默认的样式不满意可以自己设置
	 * 
	 * @param indicationStyle
	 *            资源类型,color,image,shape
	 * @param unFocus
	 *            未获得焦点指示器资源id 图片或shape或color值
	 * @param focus
	 *            获得焦点指示器资源id 图片或shape或color值
	 * @param indication_self_percent
	 *            自身高度的百分比 >=0f
	 */
	public void setIndicationStyle(IndicationStyle indicationStyle,
			int unFocus, int focus, float indication_self_percent) {
		if (indicationStyle == IndicationStyle.COLOR) {
			unFocusIndicationStyle = drawCircle(50, unFocus);
			focusIndicationStyle = drawCircle(50, focus);
		} else if (indicationStyle == IndicationStyle.IMAGE) {
			unFocusIndicationStyle = BitmapFactory.decodeResource(
					mContext.getResources(), unFocus);
			focusIndicationStyle = BitmapFactory.decodeResource(
					mContext.getResources(), focus);
		}
		indication_self_margin_percent = indication_self_percent;
		initIndication();
	}

	/**
	 * 图片轮播是自动滚动状态 true 自动滚动，false 图片不能自动滚动只能手动左右滑动
	 */
	private boolean isAutoCycle = true;
	/**
	 * 自动轮播时间间隔默认5秒
	 */
	private long mCycleDelayed = 4000;

	/**
	 * 设置是否自动无限轮播
	 * 
	 * @param delayed
	 *            自动轮播时间间隔
	 */
	public void setCycleDelayed(long delayed) {
		mCycleDelayed = delayed;
	}

	/**
	 * 设置是否自动无限轮播
	 * 
	 * @param state
	 */
	public void setAutoCycle(Boolean state) {
		isAutoCycle = state;
	}

	/**
	 * 加载显示的数据 网络图片资源及标题
	 * 
	 * @param list
	 *            数据
	 * @param callBack
	 *            如何加载图片及显示的回调方法 not null
	 */
	public void loadData(List<ImageInfo> list, LoadImageCallBack callBack) {
		data = list;
		mCount = list.size();
		initIndication();
		if (callBack == null) {
			new IllegalArgumentException("LoadImageCallBack 回调函数不能为空！");
		}
		mLoadImageCallBack = callBack;
		mViewPager.setAdapter(new ImageCycleAdapter());
		mViewPager.realCount = mCount;
		// 最大值中间 的第一个
//		mViewPager.setCurrentItem(Integer.MAX_VALUE / 2
//				- ((Integer.MAX_VALUE / 2) % mCount));
	}

	/**
	 * 设置点击事件监听回调函数
	 * 
	 * @param listener
	 */
	public void setOnPageClickListener(OnPageClickListener listener) {
		mOnPageClickListener = listener;
	}

	/**
	 * 轮播控件的监听事件
	 */
	public interface OnPageClickListener {
		/**
		 * 单击图片事件
		 * 
		 * @param imageView
		 *            被点击的View对象
		 * @param imageInfo
		 *            数据信息
		 */
		void onClick(View imageView, ImageInfo imageInfo);
	}

	/**
	 * 初始化指标器
	 */
	private void initIndication() {
		mIndicationGroup.removeAllViews();
		for (int i = 0; i < mCount; i++) {
			ImageView imageView = new ImageView(mContext);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					mIndicationGroup.getLayoutParams().height,
					LinearLayout.LayoutParams.MATCH_PARENT);
			params.leftMargin = (int) (mIndicationGroup.getLayoutParams().height * indication_self_margin_percent);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(params);
			if (i == 0) {
				imageView.setImageBitmap(focusIndicationStyle);
			} else {
				imageView.setImageBitmap(unFocusIndicationStyle);
			}
			mIndicationGroup.addView(imageView);
		}
	}

	private Bitmap drawCircle(int radius, int color) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(color);// 设置颜色
		Bitmap bitmap = Bitmap.createBitmap(radius, radius,
				Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawCircle(radius / 2, radius / 2, radius / 2, paint);
		return bitmap;
	}

	public static class ImageInfo {
		public ImageInfo(Object image, String text, Object value) {
			this.image = image;
			this.text = text;
			this.value = value;
		}

		public Object image;
		public String text = "";
		public Object value;
	}

	/**
	 * 加载图片并显示回调接口
	 */
	public interface LoadImageCallBack {
		/**
		 * 自己如何设置加载图片
		 * 
		 * @param imageInfo
		 *            数据信息
		 */
		View loadAndDisplay(ImageInfo imageInfo);
	}

	/**
	 * 轮播图片监听
	 * 
	 */
	private final class ImageCyclePageChangeListener implements
			OnPageChangeListener {

		// 上次指示器指示的位置,开始为默认位置0
		private int preIndex = 0;

		@Override
		public void onPageSelected(int index) {
			index = index % mCount;
			// 更新文本信息
			String text = data.get(index).text;
			mText.setText(TextUtils.isEmpty(text) ? "" : text);
			// 恢复默认没有获得焦点指示器样式
			((ImageView) (mIndicationGroup.getChildAt(preIndex)))
					.setImageBitmap(unFocusIndicationStyle);
			// 设置当前显示图片的指示器样式
			((ImageView) (mIndicationGroup.getChildAt(index)))
					.setImageBitmap(focusIndicationStyle);
			preIndex = index;
		}

		@Override
		public void onPageScrollStateChanged(int state) {
			enableDisableSwipeRefresh(state == ViewPager.SCROLL_STATE_IDLE);
			
		}
	    private void enableDisableSwipeRefresh(boolean b) {
	    	 
	        if (mViewPager.parent != null) {
	        	mViewPager.parent.setEnabled(b);
	        }
	    }

		@Override
		public void onPageScrolled(int i, float v, int i1) {

		}
	}

	/**
	 * 图片轮播适配器
	 */
	private class ImageCycleAdapter extends PagerAdapter {

		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			final ImageInfo imageInfo = data.get(position % mCount);

			View imageView = mLoadImageCallBack.loadAndDisplay(imageInfo);
			imageView.setLayoutParams(new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT));
			// imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			// 设置图片点击监听
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (mOnPageClickListener != null) {
						mOnPageClickListener.onClick(v, imageInfo);
					}
				}
			});

			container.addView(imageView);
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public int getCount() {
			if(data==null || data.size()==0){
				return 0;
			}
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == obj;
		}
	}

	/**
	 * 开始图片轮播
	 */
	private void startImageCycle() {
		handler.sendEmptyMessageDelayed(0, mCycleDelayed);
	}

	/**
	 * 暂停图片轮播
	 */
	private void stopImageCycle() {
		handler.removeCallbacksAndMessages(null);
	}

	/**
	 * 实现自动轮播
	 */
	private Handler handler = new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			if (mViewPager != null) {
				mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
				handler.sendEmptyMessageDelayed(0, mCycleDelayed);
			}
			return false;
		}
	});

	/**
	 * 触摸停止计时器，抬起启动计时器
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (isAutoCycle) {
				// 开始图片滚动
				startImageCycle();
			}
		} else {
			if (isAutoCycle) {
				// 停止图片滚动
				stopImageCycle();
			}
		}
		return super.dispatchTouchEvent(event);
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		// 停止图片滚动
		stopImageCycle();
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		if (isAutoCycle) {
			startImageCycle();
		}
	}
	public void setNestParent(ViewGroup viewg){
		mViewPager.setNestParent(viewg);
	}
	/**
	 * 自定义ViewPager主要用于事件处理
	 */
	public class ImageCycleViewPager extends ViewPager {
		private ViewGroup parent;
		// 滑动距离及坐标
		@SuppressWarnings("unused")
		private float xDistance, yDistance, xLast, yLast;
		public int realCount;

		public ImageCycleViewPager(Context context) {
			super(context);
		}

		public ImageCycleViewPager(Context context, AttributeSet attrs) {
			super(context, attrs);
		}

		public void setNestParent(ViewGroup parent) {
			this.parent = parent;
		}

		/**
		 * 事件拦截
		 */
		@Override
		public boolean onInterceptTouchEvent(MotionEvent ev) {
			if (parent != null) {
				parent.requestDisallowInterceptTouchEvent(true);
			}
			return super.onInterceptTouchEvent(ev);
		}

/*		@Override
		public boolean onInterceptTouchEvent(MotionEvent ev) {
			// 确保有SwipeRefreshLayout有Target
			// 遍历所有child，第一个child就是target(除了刷新的那个圈)。
			// 这就是为啥SwiperefreshLayout只能有一个child的原因。
			// 先无视掉这句代码，和我们分析目的无关 ensureTarget();
			final int action = MotionEventCompat.getActionMasked(ev);
			// 这个也无视吧， mReturningToStart一直都是false的，源码中并没有赋值
			// 估计原本用于判断是否正在刷新中，后来用了其他方式判断。（猜测）
			if (mReturningToStart && action == MotionEvent.ACTION_DOWN) {
				mReturningToStart = false;
			}
			if (!isEnabled() || mReturningToStart || canChildScrollUp()
					|| mRefreshing) {
				// Fail fast if we're not in a state where a swipe is possible
				return false;
			}
			switch (action) {
			case MotionEvent.ACTION_DOWN:
				setTargetOffsetTopAndBottom(
						mOriginalOffsetTop - mCircleView.getTop(), true);
				mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
				// 一个记录是否正在进行拖拽的标记，初始化false。
				mIsBeingDragged = false;
				// 获取按下的Y轴位置
				final float initialDownY = getMotionEventY(ev, mActivePointerId);
				if (initialDownY == -1) {
					return false;
				}
				mInitialDownY = initialDownY;
				break;
			case MotionEvent.ACTION_MOVE:
				if (mActivePointerId == INVALID_POINTER) {
					Log.e("--",
							"Got ACTION_MOVE event but don't have an active pointer id.");
					return false;
				}
				// 获取当前的Y轴位置
				final float y = getMotionEventY(ev, mActivePointerId);
				if (y == -1) {
					return false;
				}
				// 获取手指在Y轴的滑动距离
				final float yDiff = y - mInitialDownY;
				// 如果滑动距离大于mTouchSlop（不同手机的值不同，一般为8px）
				// 并且当前不是在拖拽中
				if (yDiff > mTouchSlop && !mIsBeingDragged) {
					mInitialMotionY = mInitialDownY + mTouchSlop;
					// 设置当前拖拽标记为true
					mIsBeingDragged = true;
					mProgress.setAlpha(STARTING_PROGRESS_ALPHA);
				}
				break;
			case MotionEventCompat.ACTION_POINTER_UP:
				onSecondaryPointerUp(ev);
				break;
			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_CANCEL:
				// 当手指抬起的时候设置拖拽标记为false；
				mIsBeingDragged = false;
				mActivePointerId = INVALID_POINTER;
				break;
			}
			// 如果是拖拽中，拦截事件，否则不拦截。
			return mIsBeingDragged;

		}*/

		/**
		 * 事件分发
		 */
		@Override
		public boolean dispatchTouchEvent(MotionEvent ev) {
			if (parent != null) {
				parent.requestDisallowInterceptTouchEvent(true);
			}
			return super.dispatchTouchEvent(ev);
		}

		/**
		 * 事件处理
		 */
		@SuppressLint("ClickableViewAccessibility")
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			if (parent != null) {
				parent.requestDisallowInterceptTouchEvent(true);
			}
			return super.onTouchEvent(event);
		}

	}

}

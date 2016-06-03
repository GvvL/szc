package com.aydc.szc.widget;  
  
import com.aydc.szc.util.Logger;

import android.annotation.SuppressLint;
import android.content.Context;  
import android.graphics.Rect;
import android.os.Handler;  
import android.util.AttributeSet;  
import android.view.MotionEvent;  
import android.widget.ScrollView;  

public class MScrollViewExtend extends ScrollView {  
    private OnScrollListener onScrollListener;  

    private int lastScrollY;  
      
    public MScrollViewExtend(Context context) {  
        super(context);  
    }  
      
    public MScrollViewExtend(Context context, AttributeSet attrs) {  
    	super(context, attrs);  
    }  
  
      
    /** 
     * @param onScrollListener 
     */  
    public void setOnScrollListener(OnScrollListener onScrollListener) {  
        this.onScrollListener = onScrollListener;  
    }  
  
  
 
    @SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {  
  
        public void handleMessage(android.os.Message msg) {  
            int scrollY = MScrollViewExtend.this.getScrollY();  
              
            //此时的距离和记录下的距离不相等，在隔5毫秒给handler发送消息  
            if(lastScrollY != scrollY){  
                lastScrollY = scrollY;  
                handler.sendMessageDelayed(handler.obtainMessage(), 5);    
            }  
            if(onScrollListener != null){  
                onScrollListener.onScroll(scrollY);  
            }  
              
        };  
  
    };   
  
 
	@Override  
    public boolean onTouchEvent(MotionEvent ev) {  
        if(onScrollListener != null){  
            onScrollListener.onScroll(lastScrollY = this.getScrollY());  
        }  
        switch(ev.getAction()){  
        case MotionEvent.ACTION_UP:  
             handler.sendMessageDelayed(handler.obtainMessage(), 5);    
            break;  
        }  
        return super.onTouchEvent(ev);  
    }  
	
	@Override
	protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
		Logger.e(rect.height()+"--");
		return 0;
	}
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if(onScrollListener!=null)
		onScrollListener.onScrollReal(t);
	}
  
  
 
    public interface OnScrollListener{  
        /** 
         * 回调方法， 返回MyScrollView滑动的Y方向距离 
         * @param scrollY 
         *              、 
         */  
        public void onScroll(int scrollY); 
        public void onScrollReal(int rY);
    }  
      
      
  
}  
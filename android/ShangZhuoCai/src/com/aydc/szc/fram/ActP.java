package com.aydc.szc.fram;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;












import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.util.ActManager;
import com.aydc.szc.util.SystemBarTintManager;


/**
 * Created by giw on 2016/2/21.
 */
public abstract class ActP<T extends ViewDelegate> extends Activity {
    protected T viewDelegate;
    protected boolean transbar=true;


    @SuppressWarnings("unchecked")
	public ActP() {

        try {
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            Class<T> entityClass = (Class<T>) params[0];
            viewDelegate =entityClass.newInstance();
//            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("create IDelegate error");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("create IDelegate error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if(transbar){
        	makeBarTranslucent2();
        }
        viewDelegate.create(getLayoutInflater(), null, savedInstanceState);
        setContentView(viewDelegate.getRootView());
        viewDelegate.initWidget();
        preliminary();
        bindEvenListener();
        ActManager.getInstance().addActivity2Stack(this);
    }
    /**
     * 事件绑定
     */
    protected void bindEvenListener() {
    }
    /**
     * 数据准备
     */
    protected void preliminary(){
    	
    }

    @SuppressWarnings("unchecked")
	@Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            try {
                Type genType = getClass().getGenericSuperclass();
                Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
                Class<T> entityClass = (Class<T>) params[0];
                viewDelegate =entityClass.newInstance();
//                viewDelegate = getDelegateClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create IView error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IView error");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionsMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        viewDelegate.deinitWidget();
        viewDelegate = null;
        super.onDestroy();
    }
//    protected abstract Class<T> getDelegateClass();
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
	public void makeBarTranslucent2(){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {  
            setTranslucentStatus(true);  
            SystemBarTintManager tintManager = new SystemBarTintManager(this);  
            tintManager.setStatusBarTintEnabled(true);  
            tintManager.setStatusBarTintResource(android.R.color.transparent);//通知栏所需颜色
        } 
	}
	@TargetApi(19)   
    private void setTranslucentStatus(boolean on) {  
        Window win = getWindow();  
        WindowManager.LayoutParams winParams = win.getAttributes();  
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;  
        if (on) {  
            winParams.flags |= bits;  
        } else {  
            winParams.flags &= ~bits;  
        }  
        win.setAttributes(winParams);  
    }

}

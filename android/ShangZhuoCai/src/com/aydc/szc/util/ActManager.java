package com.aydc.szc.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;



import android.app.Activity;

/**
 * ҳ�������
 * @author Administrator
 *
 */
public class ActManager {
	private  ArrayList<WeakReference<Activity>> activitystack;
	private ActManager(){
		activitystack = new ArrayList<WeakReference<Activity>>();
	}
	private static ActManager instance=new ActManager();
	public static ActManager getInstance(){
		return instance;
	}
	
	/**
	 * ����ȫ�˳�
	 */
	public void onTerminate() {
//		MobclickAgent.onKillProcess(getApplicationContext());
		for (WeakReference<Activity> ractivity : activitystack) {
			if(ractivity.get()!=null){
				ractivity.get().finish();
			}
		}
		activitystack.clear();
//		super.onTerminate();
	}
	/**
	 * ��Ӧ�ó��������ջ�е�һactivityʵ����ӵ�activitystack��
	 * 
	 * @param activity
	 *            һ��activityʵ��
	 */
	public  void addActivity2Stack(Activity activity) {
		activitystack.add(new WeakReference<Activity>(activity));
	}
	/**
	 * ��activityʵ����activitystack���Ƴ�
	 * 
	 * @param activity
	 *            һ��activityʵ��
	 */
	public  void removeActivityFromStack(Activity activity) {
		activitystack.remove(activity);
	}

}

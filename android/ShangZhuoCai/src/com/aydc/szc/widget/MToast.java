package com.aydc.szc.widget;

import com.aydc.szc.R;
import com.aydc.szc.util.FontUtil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MToast {
    private static MToast toastCommom;  
    
    private Toast toast; 
    TextView text;
      
    private MToast(Context context){ 
        View layout = LayoutInflater.from(context).inflate(R.layout.toast_layout,null);  
        text = (TextView) layout.findViewById(R.id.toast_tv);  
        FontUtil.init(1, text);
        toast = new Toast(context);  
        toast.setDuration(Toast.LENGTH_SHORT);  
        toast.setView(layout); 
    }  
      
    public static MToast createToastConfig(Context context){  
        if (toastCommom==null) {  
            toastCommom = new MToast(context);  
        }  
        return toastCommom;  
    }  
      

      
    public void ToastShow(String tvString){  
    	text.setText(tvString);
        toast.show();  
    }  
}

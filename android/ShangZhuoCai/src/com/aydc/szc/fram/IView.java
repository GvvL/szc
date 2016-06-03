package com.aydc.szc.fram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by giw on 2016/2/21.
 */
public interface IView {
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    int getOptionsMenuId();


    View getRootView();

    void initWidget();
}

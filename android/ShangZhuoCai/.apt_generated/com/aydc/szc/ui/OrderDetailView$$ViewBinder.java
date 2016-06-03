// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class OrderDetailView$$ViewBinder<T extends com.aydc.szc.ui.OrderDetailView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361916, "field 'ordedetail_coupon_price'");
    target.ordedetail_coupon_price = finder.castView(view, 2131361916, "field 'ordedetail_coupon_price'");
    view = finder.findRequiredView(source, 2131361917, "field 'ordedetail_feight'");
    target.ordedetail_feight = finder.castView(view, 2131361917, "field 'ordedetail_feight'");
    view = finder.findRequiredView(source, 2131361918, "field 'orderdetail_y_price'");
    target.orderdetail_y_price = finder.castView(view, 2131361918, "field 'orderdetail_y_price'");
    view = finder.findRequiredView(source, 2131361921, "field 'orderdetail_address'");
    target.orderdetail_address = finder.castView(view, 2131361921, "field 'orderdetail_address'");
    view = finder.findRequiredView(source, 2131361920, "field 'orderdetail_price'");
    target.orderdetail_price = finder.castView(view, 2131361920, "field 'orderdetail_price'");
    view = finder.findRequiredView(source, 2131361922, "field 'orderdetail_tel'");
    target.orderdetail_tel = finder.castView(view, 2131361922, "field 'orderdetail_tel'");
    view = finder.findRequiredView(source, 2131361919, "field 'orderdetail_status'");
    target.orderdetail_status = finder.castView(view, 2131361919, "field 'orderdetail_status'");
    view = finder.findRequiredView(source, 2131361915, "field 'food_listview'");
    target.food_listview = finder.castView(view, 2131361915, "field 'food_listview'");
  }

  @Override public void unbind(T target) {
    target.ordedetail_coupon_price = null;
    target.ordedetail_feight = null;
    target.orderdetail_y_price = null;
    target.orderdetail_address = null;
    target.orderdetail_price = null;
    target.orderdetail_tel = null;
    target.orderdetail_status = null;
    target.food_listview = null;
  }
}

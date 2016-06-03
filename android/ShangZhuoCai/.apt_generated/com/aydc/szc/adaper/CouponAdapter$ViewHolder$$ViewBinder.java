// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CouponAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.CouponAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361977, "field 'v_line'");
    target.v_line = view;
    view = finder.findRequiredView(source, 2131361976, "field 'coupon_size'");
    target.coupon_size = finder.castView(view, 2131361976, "field 'coupon_size'");
    view = finder.findRequiredView(source, 2131361978, "field 'coupon_man'");
    target.coupon_man = finder.castView(view, 2131361978, "field 'coupon_man'");
    view = finder.findRequiredView(source, 2131361979, "field 'coupon_time'");
    target.coupon_time = finder.castView(view, 2131361979, "field 'coupon_time'");
    view = finder.findRequiredView(source, 2131361975, "field 'coupon_ll'");
    target.coupon_ll = finder.castView(view, 2131361975, "field 'coupon_ll'");
  }

  @Override public void unbind(T target) {
    target.v_line = null;
    target.coupon_size = null;
    target.coupon_man = null;
    target.coupon_time = null;
    target.coupon_ll = null;
  }
}

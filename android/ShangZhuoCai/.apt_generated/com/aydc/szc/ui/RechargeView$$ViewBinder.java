// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RechargeView$$ViewBinder<T extends com.aydc.szc.ui.RechargeView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361923, "field 'recharge_face'");
    target.recharge_face = finder.castView(view, 2131361923, "field 'recharge_face'");
    view = finder.findRequiredView(source, 2131361926, "field 'recharge_channel2'");
    target.recharge_channel2 = finder.castView(view, 2131361926, "field 'recharge_channel2'");
    view = finder.findRequiredView(source, 2131361925, "field 'recharge_channel1'");
    target.recharge_channel1 = finder.castView(view, 2131361925, "field 'recharge_channel1'");
  }

  @Override public void unbind(T target) {
    target.recharge_face = null;
    target.recharge_channel2 = null;
    target.recharge_channel1 = null;
  }
}

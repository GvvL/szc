// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ToPayFoodsAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.ToPayFoodsAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362006, "field 'name'");
    target.name = finder.castView(view, 2131362006, "field 'name'");
    view = finder.findRequiredView(source, 2131362007, "field 'price'");
    target.price = finder.castView(view, 2131362007, "field 'price'");
    view = finder.findRequiredView(source, 2131362008, "field 'num'");
    target.num = finder.castView(view, 2131362008, "field 'num'");
  }

  @Override public void unbind(T target) {
    target.name = null;
    target.price = null;
    target.num = null;
  }
}

// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class OrderDetailAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.OrderDetailAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361991, "field 'price'");
    target.price = finder.castView(view, 2131361991, "field 'price'");
    view = finder.findRequiredView(source, 2131361990, "field 'name'");
    target.name = finder.castView(view, 2131361990, "field 'name'");
  }

  @Override public void unbind(T target) {
    target.price = null;
    target.name = null;
  }
}

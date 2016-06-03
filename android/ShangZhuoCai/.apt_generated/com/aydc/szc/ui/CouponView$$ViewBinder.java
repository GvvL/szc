// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CouponView$$ViewBinder<T extends com.aydc.szc.ui.CouponView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361887, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131361887, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131361886, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131361886, "field 'mSwipeRefreshLayout'");
  }

  @Override public void unbind(T target) {
    target.mRecyclerView = null;
    target.mSwipeRefreshLayout = null;
  }
}

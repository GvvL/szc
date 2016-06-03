// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class OrdersView$$ViewBinder<T extends com.aydc.szc.ui.OrdersView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361823, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131361823, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131361824, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131361824, "field 'mRecyclerView'");
  }

  @Override public void unbind(T target) {
    target.mSwipeRefreshLayout = null;
    target.mRecyclerView = null;
  }
}

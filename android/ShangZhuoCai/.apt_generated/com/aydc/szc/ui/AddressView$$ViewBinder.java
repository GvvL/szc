// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AddressView$$ViewBinder<T extends com.aydc.szc.ui.AddressView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361823, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131361823, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131361824, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131361824, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131361822, "method 'addAddressClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addAddressClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.mSwipeRefreshLayout = null;
    target.mRecyclerView = null;
  }
}

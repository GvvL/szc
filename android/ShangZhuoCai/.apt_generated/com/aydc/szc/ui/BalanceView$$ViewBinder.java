// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BalanceView$$ViewBinder<T extends com.aydc.szc.ui.BalanceView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361839, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131361839, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131361837, "field 'balance_yue'");
    target.balance_yue = finder.castView(view, 2131361837, "field 'balance_yue'");
    view = finder.findRequiredView(source, 2131361838, "method 'chargeClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.chargeClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.mRecyclerView = null;
    target.balance_yue = null;
  }
}

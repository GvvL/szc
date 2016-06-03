// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BalanceAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.BalanceAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361959, "field 'cell_balance_time'");
    target.cell_balance_time = finder.castView(view, 2131361959, "field 'cell_balance_time'");
    view = finder.findRequiredView(source, 2131361961, "field 'cell_balance_value'");
    target.cell_balance_value = finder.castView(view, 2131361961, "field 'cell_balance_value'");
    view = finder.findRequiredView(source, 2131361960, "field 'cell_balance_str'");
    target.cell_balance_str = finder.castView(view, 2131361960, "field 'cell_balance_str'");
  }

  @Override public void unbind(T target) {
    target.cell_balance_time = null;
    target.cell_balance_value = null;
    target.cell_balance_str = null;
  }
}

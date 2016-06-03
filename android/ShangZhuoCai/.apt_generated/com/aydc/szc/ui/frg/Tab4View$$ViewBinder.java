// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui.frg;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab4View$$ViewBinder<T extends com.aydc.szc.ui.frg.Tab4View> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362050, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131362050, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131362048, "field 'nav_bar_title1'");
    target.nav_bar_title1 = finder.castView(view, 2131362048, "field 'nav_bar_title1'");
    view = finder.findRequiredView(source, 2131362049, "field 'nav_bar_title2'");
    target.nav_bar_title2 = finder.castView(view, 2131362049, "field 'nav_bar_title2'");
    view = finder.findRequiredView(source, 2131362052, "field 'rc_view'");
    target.rc_view = finder.castView(view, 2131362052, "field 'rc_view'");
  }

  @Override public void unbind(T target) {
    target.mSwipeRefreshLayout = null;
    target.nav_bar_title1 = null;
    target.nav_bar_title2 = null;
    target.rc_view = null;
  }
}

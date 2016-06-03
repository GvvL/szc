// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui.frg;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab3View$$ViewBinder<T extends com.aydc.szc.ui.frg.Tab3View> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362041, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131362041, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131362043, "field 'loading_frame'");
    target.loading_frame = finder.castView(view, 2131362043, "field 'loading_frame'");
    view = finder.findRequiredView(source, 2131362040, "field 'condition2'");
    target.condition2 = finder.castView(view, 2131362040, "field 'condition2'");
    view = finder.findRequiredView(source, 2131362036, "field 'nav_bar_title1'");
    target.nav_bar_title1 = finder.castView(view, 2131362036, "field 'nav_bar_title1'");
    view = finder.findRequiredView(source, 2131362042, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131362042, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131362039, "field 'condition1'");
    target.condition1 = finder.castView(view, 2131362039, "field 'condition1'");
    view = finder.findRequiredView(source, 2131362037, "field 'nav_bar_title2'");
    target.nav_bar_title2 = finder.castView(view, 2131362037, "field 'nav_bar_title2'");
  }

  @Override public void unbind(T target) {
    target.mSwipeRefreshLayout = null;
    target.loading_frame = null;
    target.condition2 = null;
    target.nav_bar_title1 = null;
    target.mRecyclerView = null;
    target.condition1 = null;
    target.nav_bar_title2 = null;
  }
}

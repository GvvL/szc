// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui.frg;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab3View$$ViewBinder<T extends com.aydc.szc.ui.frg.Tab3View> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362044, "field 'tab3_con_listview1'");
    target.tab3_con_listview1 = finder.castView(view, 2131362044, "field 'tab3_con_listview1'");
    view = finder.findRequiredView(source, 2131362037, "field 'nav_bar_title2'");
    target.nav_bar_title2 = finder.castView(view, 2131362037, "field 'nav_bar_title2'");
    view = finder.findRequiredView(source, 2131362039, "field 'condition1' and method 'condition1click'");
    target.condition1 = finder.castView(view, 2131362039, "field 'condition1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.condition1click(p0);
        }
      });
    view = finder.findRequiredView(source, 2131362041, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131362041, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131362042, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131362042, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131362046, "field 'loading_frame'");
    target.loading_frame = finder.castView(view, 2131362046, "field 'loading_frame'");
    view = finder.findRequiredView(source, 2131362045, "field 'tab3_con_listview2'");
    target.tab3_con_listview2 = finder.castView(view, 2131362045, "field 'tab3_con_listview2'");
    view = finder.findRequiredView(source, 2131362036, "field 'nav_bar_title1'");
    target.nav_bar_title1 = finder.castView(view, 2131362036, "field 'nav_bar_title1'");
    view = finder.findRequiredView(source, 2131362043, "field 'tab3_stub'");
    target.tab3_stub = finder.castView(view, 2131362043, "field 'tab3_stub'");
    view = finder.findRequiredView(source, 2131362040, "field 'condition2' and method 'condition2click'");
    target.condition2 = finder.castView(view, 2131362040, "field 'condition2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.condition2click(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.tab3_con_listview1 = null;
    target.nav_bar_title2 = null;
    target.condition1 = null;
    target.mSwipeRefreshLayout = null;
    target.mRecyclerView = null;
    target.loading_frame = null;
    target.tab3_con_listview2 = null;
    target.nav_bar_title1 = null;
    target.tab3_stub = null;
    target.condition2 = null;
  }
}

// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui.frg;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab2View$$ViewBinder<T extends com.aydc.szc.ui.frg.Tab2View> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362030, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131362030, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131362025, "field 'tab2_rlayout'");
    target.tab2_rlayout = finder.castView(view, 2131362025, "field 'tab2_rlayout'");
    view = finder.findRequiredView(source, 2131362029, "field 'mRefreshView'");
    target.mRefreshView = finder.castView(view, 2131362029, "field 'mRefreshView'");
    view = finder.findRequiredView(source, 2131362034, "field 'loading_fram'");
    target.loading_fram = finder.castView(view, 2131362034, "field 'loading_fram'");
    view = finder.findRequiredView(source, 2131362032, "field 'tab2_con_listview1'");
    target.tab2_con_listview1 = finder.castView(view, 2131362032, "field 'tab2_con_listview1'");
    view = finder.findRequiredView(source, 2131362033, "field 'tab2_con_listview2'");
    target.tab2_con_listview2 = finder.castView(view, 2131362033, "field 'tab2_con_listview2'");
    view = finder.findRequiredView(source, 2131362031, "field 'tab2_stub'");
    target.tab2_stub = finder.castView(view, 2131362031, "field 'tab2_stub'");
    view = finder.findRequiredView(source, 2131362028, "field 'condition2' and method 'condition2click'");
    target.condition2 = finder.castView(view, 2131362028, "field 'condition2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.condition2click(p0);
        }
      });
    view = finder.findRequiredView(source, 2131362023, "field 'nav_bar_title1'");
    target.nav_bar_title1 = finder.castView(view, 2131362023, "field 'nav_bar_title1'");
    view = finder.findRequiredView(source, 2131362027, "field 'condition1' and method 'condition1click'");
    target.condition1 = finder.castView(view, 2131362027, "field 'condition1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.condition1click(p0);
        }
      });
    view = finder.findRequiredView(source, 2131362024, "field 'nav_bar_title2'");
    target.nav_bar_title2 = finder.castView(view, 2131362024, "field 'nav_bar_title2'");
  }

  @Override public void unbind(T target) {
    target.mRecyclerView = null;
    target.tab2_rlayout = null;
    target.mRefreshView = null;
    target.loading_fram = null;
    target.tab2_con_listview1 = null;
    target.tab2_con_listview2 = null;
    target.tab2_stub = null;
    target.condition2 = null;
    target.nav_bar_title1 = null;
    target.condition1 = null;
    target.nav_bar_title2 = null;
  }
}

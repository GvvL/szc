// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui.frg;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab1View$$ViewBinder<T extends com.aydc.szc.ui.frg.Tab1View> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362009, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131362009, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131362016, "field 'indicator'");
    target.indicator = finder.castView(view, 2131362016, "field 'indicator'");
    view = finder.findRequiredView(source, 2131362014, "field 'loading_framlayout'");
    target.loading_framlayout = finder.castView(view, 2131362014, "field 'loading_framlayout'");
    view = finder.findRequiredView(source, 2131362010, "field 'scroll'");
    target.scroll = finder.castView(view, 2131362010, "field 'scroll'");
    view = finder.findRequiredView(source, 2131362017, "field 'tv_address'");
    target.tv_address = finder.castView(view, 2131362017, "field 'tv_address'");
    view = finder.findRequiredView(source, 2131362011, "field 'tv_recommend_zh'");
    target.tv_recommend_zh = finder.castView(view, 2131362011, "field 'tv_recommend_zh'");
    view = finder.findRequiredView(source, 2131362013, "field 'mListView'");
    target.mListView = finder.castView(view, 2131362013, "field 'mListView'");
    view = finder.findRequiredView(source, 2131362015, "field 'imageCycle'");
    target.imageCycle = finder.castView(view, 2131362015, "field 'imageCycle'");
    view = finder.findRequiredView(source, 2131362012, "field 'tv_recommend_en'");
    target.tv_recommend_en = finder.castView(view, 2131362012, "field 'tv_recommend_en'");
  }

  @Override public void unbind(T target) {
    target.mSwipeRefreshLayout = null;
    target.indicator = null;
    target.loading_framlayout = null;
    target.scroll = null;
    target.tv_address = null;
    target.tv_recommend_zh = null;
    target.mListView = null;
    target.imageCycle = null;
    target.tv_recommend_en = null;
  }
}

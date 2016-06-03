// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ToPayView$$ViewBinder<T extends com.aydc.szc.ui.ToPayView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361941, "field 'topay_rg'");
    target.topay_rg = finder.castView(view, 2131361941, "field 'topay_rg'");
    view = finder.findRequiredView(source, 2131361940, "field 'topay_all_price'");
    target.topay_all_price = finder.castView(view, 2131361940, "field 'topay_all_price'");
    view = finder.findRequiredView(source, 2131361942, "field 'rb1'");
    target.rb1 = finder.castView(view, 2131361942, "field 'rb1'");
    view = finder.findRequiredView(source, 2131361939, "field 'mListview'");
    target.mListview = finder.castView(view, 2131361939, "field 'mListview'");
    view = finder.findRequiredView(source, 2131361944, "field 'rb3'");
    target.rb3 = finder.castView(view, 2131361944, "field 'rb3'");
    view = finder.findRequiredView(source, 2131361943, "field 'rb2'");
    target.rb2 = finder.castView(view, 2131361943, "field 'rb2'");
    view = finder.findRequiredView(source, 2131361945, "field 'topay_btn'");
    target.topay_btn = finder.castView(view, 2131361945, "field 'topay_btn'");
  }

  @Override public void unbind(T target) {
    target.topay_rg = null;
    target.topay_all_price = null;
    target.rb1 = null;
    target.mListview = null;
    target.rb3 = null;
    target.rb2 = null;
    target.topay_btn = null;
  }
}

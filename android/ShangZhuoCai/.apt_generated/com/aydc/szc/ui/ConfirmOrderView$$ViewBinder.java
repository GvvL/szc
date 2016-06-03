// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ConfirmOrderView$$ViewBinder<T extends com.aydc.szc.ui.ConfirmOrderView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361883, "field 'btn_bottom_confirm' and method 'makeorder'");
    target.btn_bottom_confirm = finder.castView(view, 2131361883, "field 'btn_bottom_confirm'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.makeorder(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361874, "field 'tv_address'");
    target.tv_address = finder.castView(view, 2131361874, "field 'tv_address'");
    view = finder.findRequiredView(source, 2131361884, "field 'tv_bottom_price'");
    target.tv_bottom_price = finder.castView(view, 2131361884, "field 'tv_bottom_price'");
    view = finder.findRequiredView(source, 2131361875, "field 'tv_link'");
    target.tv_link = finder.castView(view, 2131361875, "field 'tv_link'");
    view = finder.findRequiredView(source, 2131361885, "field 'tv_bottom_yprice'");
    target.tv_bottom_yprice = finder.castView(view, 2131361885, "field 'tv_bottom_yprice'");
    view = finder.findRequiredView(source, 2131361882, "field 'mListview'");
    target.mListview = finder.castView(view, 2131361882, "field 'mListview'");
    view = finder.findRequiredView(source, 2131361881, "field 'tv_cou_value'");
    target.tv_cou_value = finder.castView(view, 2131361881, "field 'tv_cou_value'");
    view = finder.findRequiredView(source, 2131361880, "method 'couponclick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.couponclick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361873, "method 'addressclick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addressclick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.btn_bottom_confirm = null;
    target.tv_address = null;
    target.tv_bottom_price = null;
    target.tv_link = null;
    target.tv_bottom_yprice = null;
    target.mListview = null;
    target.tv_cou_value = null;
  }
}

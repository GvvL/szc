// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CartView$$ViewBinder<T extends com.aydc.szc.ui.CartView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361841, "field 'cart_sel' and method 'allSelClick'");
    target.cart_sel = finder.castView(view, 2131361841, "field 'cart_sel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.allSelClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361842, "field 'cart_sel_text' and method 'allSelClick'");
    target.cart_sel_text = finder.castView(view, 2131361842, "field 'cart_sel_text'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.allSelClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361846, "field 'cart_all_price_bottom'");
    target.cart_all_price_bottom = finder.castView(view, 2131361846, "field 'cart_all_price_bottom'");
    view = finder.findRequiredView(source, 2131361843, "field 'cart_all_price'");
    target.cart_all_price = finder.castView(view, 2131361843, "field 'cart_all_price'");
    view = finder.findRequiredView(source, 2131361844, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131361844, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131361822, "method 'deleCart'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.deleCart(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361845, "method 'nextstep'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.nextstep(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.cart_sel = null;
    target.cart_sel_text = null;
    target.cart_all_price_bottom = null;
    target.cart_all_price = null;
    target.mRecyclerView = null;
  }
}

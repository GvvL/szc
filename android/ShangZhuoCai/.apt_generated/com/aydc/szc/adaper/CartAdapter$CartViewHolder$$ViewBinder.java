// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CartAdapter$CartViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.CartAdapter.CartViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361967, "field 'product_num'");
    target.product_num = finder.castView(view, 2131361967, "field 'product_num'");
    view = finder.findRequiredView(source, 2131361965, "field 'product_price'");
    target.product_price = finder.castView(view, 2131361965, "field 'product_price'");
    view = finder.findRequiredView(source, 2131361963, "field 'product_img'");
    target.product_img = finder.castView(view, 2131361963, "field 'product_img'");
    view = finder.findRequiredView(source, 2131361968, "field 'reduce'");
    target.reduce = finder.castView(view, 2131361968, "field 'reduce'");
    view = finder.findRequiredView(source, 2131361962, "field 'icon_sel'");
    target.icon_sel = finder.castView(view, 2131361962, "field 'icon_sel'");
    view = finder.findRequiredView(source, 2131361966, "field 'add'");
    target.add = finder.castView(view, 2131361966, "field 'add'");
    view = finder.findRequiredView(source, 2131361964, "field 'product_name'");
    target.product_name = finder.castView(view, 2131361964, "field 'product_name'");
  }

  @Override public void unbind(T target) {
    target.product_num = null;
    target.product_price = null;
    target.product_img = null;
    target.reduce = null;
    target.icon_sel = null;
    target.add = null;
    target.product_name = null;
  }
}

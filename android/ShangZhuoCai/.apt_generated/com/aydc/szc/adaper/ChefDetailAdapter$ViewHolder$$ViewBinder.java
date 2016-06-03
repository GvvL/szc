// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChefDetailAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.ChefDetailAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361972, "field 'cell_price'");
    target.cell_price = finder.castView(view, 2131361972, "field 'cell_price'");
    view = finder.findRequiredView(source, 2131361973, "field 'cell_cart_rview'");
    target.cell_cart_rview = finder.castView(view, 2131361973, "field 'cell_cart_rview'");
    view = finder.findRequiredView(source, 2131361970, "field 'cell_title'");
    target.cell_title = finder.castView(view, 2131361970, "field 'cell_title'");
    view = finder.findRequiredView(source, 2131361974, "field 'cell_cart_view'");
    target.cell_cart_view = finder.castView(view, 2131361974, "field 'cell_cart_view'");
    view = finder.findRequiredView(source, 2131361971, "field 'cell_vipprice'");
    target.cell_vipprice = finder.castView(view, 2131361971, "field 'cell_vipprice'");
    view = finder.findRequiredView(source, 2131361969, "field 'cell_img'");
    target.cell_img = finder.castView(view, 2131361969, "field 'cell_img'");
  }

  @Override public void unbind(T target) {
    target.cell_price = null;
    target.cell_cart_rview = null;
    target.cell_title = null;
    target.cell_cart_view = null;
    target.cell_vipprice = null;
    target.cell_img = null;
  }
}

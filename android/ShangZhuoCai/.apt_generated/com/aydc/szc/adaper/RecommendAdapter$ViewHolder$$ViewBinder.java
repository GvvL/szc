// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RecommendAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.RecommendAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361992, "field 'food_img'");
    target.food_img = finder.castView(view, 2131361992, "field 'food_img'");
    view = finder.findRequiredView(source, 2131361892, "field 'cart_left'");
    target.cart_left = finder.castView(view, 2131361892, "field 'cart_left'");
    view = finder.findRequiredView(source, 2131361993, "field 'food_chefimg'");
    target.food_chefimg = finder.castView(view, 2131361993, "field 'food_chefimg'");
    view = finder.findRequiredView(source, 2131361994, "field 'tv_food_title'");
    target.tv_food_title = finder.castView(view, 2131361994, "field 'tv_food_title'");
    view = finder.findRequiredView(source, 2131361995, "field 'tv_food_desc'");
    target.tv_food_desc = finder.castView(view, 2131361995, "field 'tv_food_desc'");
    view = finder.findRequiredView(source, 2131361893, "field 'cart_right'");
    target.cart_right = finder.castView(view, 2131361893, "field 'cart_right'");
  }

  @Override public void unbind(T target) {
    target.food_img = null;
    target.cart_left = null;
    target.food_chefimg = null;
    target.tv_food_title = null;
    target.tv_food_desc = null;
    target.cart_right = null;
  }
}

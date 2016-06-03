// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab2RecAdapter$ViewH$$ViewBinder<T extends com.aydc.szc.adaper.Tab2RecAdapter.ViewH> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361992, "field 'img_food'");
    target.img_food = finder.castView(view, 2131361992, "field 'img_food'");
    view = finder.findRequiredView(source, 2131361994, "field 'food_title'");
    target.food_title = finder.castView(view, 2131361994, "field 'food_title'");
    view = finder.findRequiredView(source, 2131361997, "field 'img_chef'");
    target.img_chef = finder.castView(view, 2131361997, "field 'img_chef'");
    view = finder.findRequiredView(source, 2131361892, "field 'cartbtn_left'");
    target.cartbtn_left = finder.castView(view, 2131361892, "field 'cartbtn_left'");
    view = finder.findRequiredView(source, 2131361893, "field 'cartbtn_right'");
    target.cartbtn_right = finder.castView(view, 2131361893, "field 'cartbtn_right'");
    view = finder.findRequiredView(source, 2131361996, "field 'food_title_en'");
    target.food_title_en = finder.castView(view, 2131361996, "field 'food_title_en'");
    view = finder.findRequiredView(source, 2131361998, "field 'name'");
    target.name = finder.castView(view, 2131361998, "field 'name'");
    view = finder.findRequiredView(source, 2131361995, "field 'food_desc'");
    target.food_desc = finder.castView(view, 2131361995, "field 'food_desc'");
  }

  @Override public void unbind(T target) {
    target.img_food = null;
    target.food_title = null;
    target.img_chef = null;
    target.cartbtn_left = null;
    target.cartbtn_right = null;
    target.food_title_en = null;
    target.name = null;
    target.food_desc = null;
  }
}

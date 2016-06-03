// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ConfirmOrderFoodAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.ConfirmOrderFoodAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361864, "field 'tv_num'");
    target.tv_num = finder.castView(view, 2131361864, "field 'tv_num'");
    view = finder.findRequiredView(source, 2131361862, "field 'img_food'");
    target.img_food = finder.castView(view, 2131361862, "field 'img_food'");
    view = finder.findRequiredView(source, 2131361865, "field 'tv_price'");
    target.tv_price = finder.castView(view, 2131361865, "field 'tv_price'");
    view = finder.findRequiredView(source, 2131361863, "field 'tv_title'");
    target.tv_title = finder.castView(view, 2131361863, "field 'tv_title'");
  }

  @Override public void unbind(T target) {
    target.tv_num = null;
    target.img_food = null;
    target.tv_price = null;
    target.tv_title = null;
  }
}

// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GoodsDetailView$$ViewBinder<T extends com.aydc.szc.ui.GoodsDetailView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361857, "field 'bar_share'");
    target.bar_share = finder.castView(view, 2131361857, "field 'bar_share'");
    view = finder.findRequiredView(source, 2131361891, "field 'goods_name1'");
    target.goods_name1 = finder.castView(view, 2131361891, "field 'goods_name1'");
    view = finder.findRequiredView(source, 2131361899, "field 'title_bar2_bg'");
    target.title_bar2_bg = view;
    view = finder.findRequiredView(source, 2131361855, "field 'bar_left'");
    target.bar_left = finder.castView(view, 2131361855, "field 'bar_left'");
    view = finder.findRequiredView(source, 2131361854, "field 'bar_title'");
    target.bar_title = finder.castView(view, 2131361854, "field 'bar_title'");
    view = finder.findRequiredView(source, 2131361898, "field 'title_bar2'");
    target.title_bar2 = finder.castView(view, 2131361898, "field 'title_bar2'");
    view = finder.findRequiredView(source, 2131361888, "field 'mScrollView'");
    target.mScrollView = finder.castView(view, 2131361888, "field 'mScrollView'");
    view = finder.findRequiredView(source, 2131361889, "field 'goods_img'");
    target.goods_img = finder.castView(view, 2131361889, "field 'goods_img'");
    view = finder.findRequiredView(source, 2131361856, "field 'bar_cart'");
    target.bar_cart = finder.castView(view, 2131361856, "field 'bar_cart'");
    view = finder.findRequiredView(source, 2131361897, "field 'goods_video'");
    target.goods_video = finder.castView(view, 2131361897, "field 'goods_video'");
    view = finder.findRequiredView(source, 2131361890, "field 'title_bar1'");
    target.title_bar1 = finder.castView(view, 2131361890, "field 'title_bar1'");
  }

  @Override public void unbind(T target) {
    target.bar_share = null;
    target.goods_name1 = null;
    target.title_bar2_bg = null;
    target.bar_left = null;
    target.bar_title = null;
    target.title_bar2 = null;
    target.mScrollView = null;
    target.goods_img = null;
    target.bar_cart = null;
    target.goods_video = null;
    target.title_bar1 = null;
  }
}

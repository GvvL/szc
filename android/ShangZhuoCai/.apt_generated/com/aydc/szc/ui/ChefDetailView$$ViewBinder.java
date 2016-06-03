// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.content.res.Resources;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChefDetailView$$ViewBinder<T extends com.aydc.szc.ui.ChefDetailView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361854, "field 'bar_title'");
    target.bar_title = finder.castView(view, 2131361854, "field 'bar_title'");
    view = finder.findRequiredView(source, 2131361853, "field 'nav_bar_bg'");
    target.nav_bar_bg = view;
    view = finder.findRequiredView(source, 2131361852, "field 'gridview'");
    target.gridview = finder.castView(view, 2131361852, "field 'gridview'");
    view = finder.findRequiredView(source, 2131361850, "field 'll_content'");
    target.ll_content = finder.castView(view, 2131361850, "field 'll_content'");
    view = finder.findRequiredView(source, 2131361848, "field 'chef_detail_bg'");
    target.chef_detail_bg = finder.castView(view, 2131361848, "field 'chef_detail_bg'");
    view = finder.findRequiredView(source, 2131361860, "field 'chefdetail_gride'");
    target.chefdetail_gride = finder.castView(view, 2131361860, "field 'chefdetail_gride'");
    view = finder.findRequiredView(source, 2131361857, "field 'bar_share'");
    target.bar_share = finder.castView(view, 2131361857, "field 'bar_share'");
    view = finder.findRequiredView(source, 2131361858, "field 'bar_cartnum_view'");
    target.bar_cartnum_view = finder.castView(view, 2131361858, "field 'bar_cartnum_view'");
    view = finder.findRequiredView(source, 2131361851, "field 'view_fliter'");
    target.view_fliter = finder.castView(view, 2131361851, "field 'view_fliter'");
    view = finder.findRequiredView(source, 2131361849, "field 'scrollView1'");
    target.scrollView1 = finder.castView(view, 2131361849, "field 'scrollView1'");
    view = finder.findRequiredView(source, 2131361855, "field 'bar_left' and method 'backclick'");
    target.bar_left = finder.castView(view, 2131361855, "field 'bar_left'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.backclick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361856, "field 'bar_cart' and method 'cartclick'");
    target.bar_cart = finder.castView(view, 2131361856, "field 'bar_cart'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cartclick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361859, "field 'chefdetail_headimg'");
    target.chefdetail_headimg = finder.castView(view, 2131361859, "field 'chefdetail_headimg'");
    view = finder.findRequiredView(source, 2131361861, "field 'chefdetail_sales'");
    target.chefdetail_sales = finder.castView(view, 2131361861, "field 'chefdetail_sales'");
    view = finder.findRequiredView(source, 2131361835, "field 'nav_bar'");
    target.nav_bar = finder.castView(view, 2131361835, "field 'nav_bar'");
    view = finder.findRequiredView(source, 2131361847, "field 'framelayout'");
    target.framelayout = finder.castView(view, 2131361847, "field 'framelayout'");
    Resources res = finder.getContext(source).getResources();
    target.blackColor = res.getColor(2131034114);
    target.redColor = res.getColor(2131034112);
    target.whiteColor = res.getColor(2131034115);
  }

  @Override public void unbind(T target) {
    target.bar_title = null;
    target.nav_bar_bg = null;
    target.gridview = null;
    target.ll_content = null;
    target.chef_detail_bg = null;
    target.chefdetail_gride = null;
    target.bar_share = null;
    target.bar_cartnum_view = null;
    target.view_fliter = null;
    target.scrollView1 = null;
    target.bar_left = null;
    target.bar_cart = null;
    target.chefdetail_headimg = null;
    target.chefdetail_sales = null;
    target.nav_bar = null;
    target.framelayout = null;
  }
}

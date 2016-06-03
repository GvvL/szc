// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class OrdersAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.OrdersAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361987, "field 'order_status'");
    target.order_status = finder.castView(view, 2131361987, "field 'order_status'");
    view = finder.findRequiredView(source, 2131361985, "field 'order_linktel'");
    target.order_linktel = finder.castView(view, 2131361985, "field 'order_linktel'");
    view = finder.findRequiredView(source, 2131361988, "field 'order_all_count'");
    target.order_all_count = finder.castView(view, 2131361988, "field 'order_all_count'");
    view = finder.findRequiredView(source, 2131361986, "field 'order_btn'");
    target.order_btn = finder.castView(view, 2131361986, "field 'order_btn'");
    view = finder.findRequiredView(source, 2131361984, "field 'order_linkman'");
    target.order_linkman = finder.castView(view, 2131361984, "field 'order_linkman'");
    view = finder.findRequiredView(source, 2131361989, "field 'order_all_price'");
    target.order_all_price = finder.castView(view, 2131361989, "field 'order_all_price'");
    view = finder.findRequiredView(source, 2131361981, "field 'order_no'");
    target.order_no = finder.castView(view, 2131361981, "field 'order_no'");
    view = finder.findRequiredView(source, 2131361982, "field 'order_time'");
    target.order_time = finder.castView(view, 2131361982, "field 'order_time'");
    view = finder.findRequiredView(source, 2131361983, "field 'order_address'");
    target.order_address = finder.castView(view, 2131361983, "field 'order_address'");
    view = finder.findRequiredView(source, 2131361980, "field 'order_ll'");
    target.order_ll = finder.castView(view, 2131361980, "field 'order_ll'");
  }

  @Override public void unbind(T target) {
    target.order_status = null;
    target.order_linktel = null;
    target.order_all_count = null;
    target.order_btn = null;
    target.order_linkman = null;
    target.order_all_price = null;
    target.order_no = null;
    target.order_time = null;
    target.order_address = null;
    target.order_ll = null;
  }
}

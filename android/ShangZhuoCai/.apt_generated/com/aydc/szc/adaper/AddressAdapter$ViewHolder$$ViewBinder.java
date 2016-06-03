// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AddressAdapter$ViewHolder$$ViewBinder<T extends com.aydc.szc.adaper.AddressAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361954, "field 'tv_address'");
    target.tv_address = finder.castView(view, 2131361954, "field 'tv_address'");
    view = finder.findRequiredView(source, 2131361957, "field 'tv_edit'");
    target.tv_edit = finder.castView(view, 2131361957, "field 'tv_edit'");
    view = finder.findRequiredView(source, 2131361955, "field 'tv_name'");
    target.tv_name = finder.castView(view, 2131361955, "field 'tv_name'");
    view = finder.findRequiredView(source, 2131361958, "field 'img_sel'");
    target.img_sel = finder.castView(view, 2131361958, "field 'img_sel'");
    view = finder.findRequiredView(source, 2131361956, "field 'tv_tel'");
    target.tv_tel = finder.castView(view, 2131361956, "field 'tv_tel'");
    view = finder.findRequiredView(source, 2131361953, "field 'cell_address_ll'");
    target.cell_address_ll = finder.castView(view, 2131361953, "field 'cell_address_ll'");
  }

  @Override public void unbind(T target) {
    target.tv_address = null;
    target.tv_edit = null;
    target.tv_name = null;
    target.img_sel = null;
    target.tv_tel = null;
    target.cell_address_ll = null;
  }
}

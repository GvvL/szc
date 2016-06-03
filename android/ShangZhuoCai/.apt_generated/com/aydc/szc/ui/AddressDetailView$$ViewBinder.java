// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AddressDetailView$$ViewBinder<T extends com.aydc.szc.ui.AddressDetailView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361825, "field 'act_address_edt_people'");
    target.act_address_edt_people = finder.castView(view, 2131361825, "field 'act_address_edt_people'");
    view = finder.findRequiredView(source, 2131361830, "field 'act_address_edt_jiedao'");
    target.act_address_edt_jiedao = finder.castView(view, 2131361830, "field 'act_address_edt_jiedao'");
    view = finder.findRequiredView(source, 2131361826, "field 'act_addrde_rb1'");
    target.act_addrde_rb1 = finder.castView(view, 2131361826, "field 'act_addrde_rb1'");
    view = finder.findRequiredView(source, 2131361827, "field 'act_addrde_rb2'");
    target.act_addrde_rb2 = finder.castView(view, 2131361827, "field 'act_addrde_rb2'");
    view = finder.findRequiredView(source, 2131361821, "field 'nav_bar_title'");
    target.nav_bar_title = finder.castView(view, 2131361821, "field 'nav_bar_title'");
    view = finder.findRequiredView(source, 2131361828, "field 'act_address_edt_tel'");
    target.act_address_edt_tel = finder.castView(view, 2131361828, "field 'act_address_edt_tel'");
    view = finder.findRequiredView(source, 2131361831, "field 'act_address_edt_menpai'");
    target.act_address_edt_menpai = finder.castView(view, 2131361831, "field 'act_address_edt_menpai'");
    view = finder.findRequiredView(source, 2131361834, "method 'addAddress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addAddress(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.act_address_edt_people = null;
    target.act_address_edt_jiedao = null;
    target.act_addrde_rb1 = null;
    target.act_addrde_rb2 = null;
    target.nav_bar_title = null;
    target.act_address_edt_tel = null;
    target.act_address_edt_menpai = null;
  }
}

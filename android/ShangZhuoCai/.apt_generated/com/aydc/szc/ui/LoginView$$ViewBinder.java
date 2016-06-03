// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginView$$ViewBinder<T extends com.aydc.szc.ui.LoginView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361900, "field 'edt_username'");
    target.edt_username = finder.castView(view, 2131361900, "field 'edt_username'");
    view = finder.findRequiredView(source, 2131361901, "field 'edt_password'");
    target.edt_password = finder.castView(view, 2131361901, "field 'edt_password'");
    view = finder.findRequiredView(source, 2131361822, "field 'nav_bar_right'");
    target.nav_bar_right = finder.castView(view, 2131361822, "field 'nav_bar_right'");
  }

  @Override public void unbind(T target) {
    target.edt_username = null;
    target.edt_password = null;
    target.nav_bar_right = null;
  }
}

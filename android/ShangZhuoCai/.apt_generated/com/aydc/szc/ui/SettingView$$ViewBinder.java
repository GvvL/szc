// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SettingView$$ViewBinder<T extends com.aydc.szc.ui.SettingView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361929, "field 'set_cacche_size'");
    target.set_cacche_size = finder.castView(view, 2131361929, "field 'set_cacche_size'");
    view = finder.findRequiredView(source, 2131361931, "field 'set_ban'");
    target.set_ban = finder.castView(view, 2131361931, "field 'set_ban'");
    view = finder.findRequiredView(source, 2131361935, "method 'logout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.logout(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361928, "method 'cacheClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cacheClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361933, "method 'tuiClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.tuiClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361930, "method 'banClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.banClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361934, "method 'aboutClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.aboutClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131361932, "method 'suggestClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.suggestClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.set_cacche_size = null;
    target.set_ban = null;
  }
}

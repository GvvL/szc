// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.ui.frg;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab6View$$ViewBinder<T extends com.aydc.szc.ui.frg.Tab6View> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362055, "field 'title1'");
    target.title1 = finder.castView(view, 2131362055, "field 'title1'");
    view = finder.findRequiredView(source, 2131362061, "field 'img_header'");
    target.img_header = finder.castView(view, 2131362061, "field 'img_header'");
    view = finder.findRequiredView(source, 2131362056, "field 'title2'");
    target.title2 = finder.castView(view, 2131362056, "field 'title2'");
    view = finder.findRequiredView(source, 2131362062, "field 'tv_tel'");
    target.tv_tel = finder.castView(view, 2131362062, "field 'tv_tel'");
    view = finder.findRequiredView(source, 2131362059, "field 'img_bg'");
    target.img_bg = finder.castView(view, 2131362059, "field 'img_bg'");
    view = finder.findRequiredView(source, 2131362058, "field 'mSwipeRefreshLayout'");
    target.mSwipeRefreshLayout = finder.castView(view, 2131362058, "field 'mSwipeRefreshLayout'");
    view = finder.findRequiredView(source, 2131362063, "field 'tv_login'");
    target.tv_login = finder.castView(view, 2131362063, "field 'tv_login'");
    view = finder.findRequiredView(source, 2131362064, "method 'cateClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cateClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131362065, "method 'cateClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cateClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131362066, "method 'cateClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cateClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131362067, "method 'cateClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cateClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131362057, "method 'cateClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.cateClick(p0);
        }
      });
    target.cates = Finder.arrayOf(
        finder.<android.widget.TextView>findRequiredView(source, 2131362065, "field 'cates'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131362066, "field 'cates'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131362067, "field 'cates'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131362068, "field 'cates'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131362069, "field 'cates'")
    );
  }

  @Override public void unbind(T target) {
    target.title1 = null;
    target.img_header = null;
    target.title2 = null;
    target.tv_tel = null;
    target.img_bg = null;
    target.mSwipeRefreshLayout = null;
    target.tv_login = null;
    target.cates = null;
  }
}

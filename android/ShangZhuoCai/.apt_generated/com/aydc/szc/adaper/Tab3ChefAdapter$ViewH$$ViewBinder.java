// Generated code from Butter Knife. Do not modify!
package com.aydc.szc.adaper;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab3ChefAdapter$ViewH$$ViewBinder<T extends com.aydc.szc.adaper.Tab3ChefAdapter.ViewH> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131362004, "field 'cell_chef_recommend'");
    target.cell_chef_recommend = finder.castView(view, 2131362004, "field 'cell_chef_recommend'");
    view = finder.findRequiredView(source, 2131362001, "field 'cell_chef_type'");
    target.cell_chef_type = finder.castView(view, 2131362001, "field 'cell_chef_type'");
    view = finder.findRequiredView(source, 2131362005, "field 'cell_chef_desc'");
    target.cell_chef_desc = finder.castView(view, 2131362005, "field 'cell_chef_desc'");
    view = finder.findRequiredView(source, 2131362000, "field 'chef_bg'");
    target.chef_bg = finder.castView(view, 2131362000, "field 'chef_bg'");
    view = finder.findRequiredView(source, 2131361999, "field 'cell_rl'");
    target.cell_rl = finder.castView(view, 2131361999, "field 'cell_rl'");
    view = finder.findRequiredView(source, 2131362002, "field 'cell_chef_rat'");
    target.cell_chef_rat = finder.castView(view, 2131362002, "field 'cell_chef_rat'");
    view = finder.findRequiredView(source, 2131362003, "field 'cell_chef_ratingbar'");
    target.cell_chef_ratingbar = finder.castView(view, 2131362003, "field 'cell_chef_ratingbar'");
  }

  @Override public void unbind(T target) {
    target.cell_chef_recommend = null;
    target.cell_chef_type = null;
    target.cell_chef_desc = null;
    target.chef_bg = null;
    target.cell_rl = null;
    target.cell_chef_rat = null;
    target.cell_chef_ratingbar = null;
  }
}

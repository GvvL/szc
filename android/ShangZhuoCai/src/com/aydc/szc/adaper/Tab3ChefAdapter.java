package com.aydc.szc.adaper;

import java.util.ArrayList;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.ui.ChefDetailActivity;
import com.aydc.szc.util.FontUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.Bind;
import butterknife.ButterKnife;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Tab3ChefAdapter extends RecyclerView.Adapter<Tab3ChefAdapter.ViewH>{
	
	private LayoutInflater inflater;
	private Context mcontext;
	ArrayList<ChefBean> chefs=new ArrayList<>();
	
	public Tab3ChefAdapter(Context c) {
		mcontext=c;
		inflater=LayoutInflater.from(c);
	}
	
	public void setdata(ArrayList<ChefBean> che){
		chefs=che;
		this.notifyDataSetChanged();
	}


	@Override
	public int getItemCount() {
		return chefs.size();
	}

	@Override
	public void onBindViewHolder(ViewH vh, int arg1) {
		final ChefBean cb=chefs.get(arg1);
		vh.cell_chef_desc.setText(cb.getDescription());
		vh.cell_chef_rat.setText(cb.getMonicker());
		vh.cell_chef_recommend.setText(Html.fromHtml("<u>   "+cb.getSupporter()+"人推荐   </u>"));
		vh.cell_chef_type.setText(cb.getStyle_name());
		vh.cell_chef_ratingbar.setRating(cb.getGrade());
		Glide.with(mcontext).load(Common.RELEAST_HOST+cb.getPhoto()).placeholder(R.drawable.test_user).diskCacheStrategy(DiskCacheStrategy.ALL).into(vh.chef_bg);
		vh.cell_rl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(mcontext, ChefDetailActivity.class);
				ChefDetailActivity.chefb=cb;
				mcontext.startActivity(intent);
			}
		});
	}

	@Override
	public ViewH onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=inflater.inflate(R.layout.cell_tab3, null);
		ViewH vh=new ViewH(view);
		return vh;
	}
	
	
	class ViewH extends ViewHolder{
		@Bind(R.id.cell_chef_desc) TextView cell_chef_desc;
		@Bind(R.id.cell_chef_rat) TextView	cell_chef_rat;
		@Bind(R.id.cell_chef_recommend) TextView	cell_chef_recommend;
		@Bind(R.id.cell_chef_type) TextView	cell_chef_type;
		@Bind(R.id.chef_bg) ImageView chef_bg;
		@Bind(R.id.cell_chef_ratingbar) RatingBar cell_chef_ratingbar;
		@Bind(R.id.cell_rl) RelativeLayout cell_rl;
		public ViewH(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			FontUtil.init(1, cell_chef_desc,cell_chef_rat,cell_chef_recommend,cell_chef_type);
		}
		
	}
}

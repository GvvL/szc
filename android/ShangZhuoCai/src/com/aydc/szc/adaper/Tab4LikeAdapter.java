package com.aydc.szc.adaper;

import com.aydc.szc.R;

import butterknife.ButterKnife;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class Tab4LikeAdapter extends RecyclerView.Adapter<Tab4LikeAdapter.ViewHolder>{
	private Context mContext;
	public Tab4LikeAdapter(Context c) {
		this.mContext=c;
	}
	@Override
	public int getItemCount() {
		return 6;
	}

	@Override
	public void onBindViewHolder(ViewHolder vh, int arg1) {
		
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup vg, int position) {
		View view=View.inflate(mContext, R.layout.cell_tab4_like, null);
		ViewHolder vh=new ViewHolder(view);
		return vh;
	}
	
	public static class ViewHolder extends RecyclerView.ViewHolder{
		
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}


}

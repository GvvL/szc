package com.aydc.szc.adaper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.aydc.szc.R;
import com.aydc.szc.app.Common;
import com.aydc.szc.entity.ChefBean;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.model.CartModel;
import com.aydc.szc.model.ChefModel;
import com.aydc.szc.model.ChefModel.FindChefCallBack;
import com.aydc.szc.ui.MainActivity;
import com.aydc.szc.util.FontUtil;
import com.aydc.szc.widget.MImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Tab2RecAdapter extends RecyclerView.Adapter<ViewHolder>{
	
	private LayoutInflater inflater;
	private Context mcontext;
	private ArrayList<DishBean> dishes=new ArrayList<>();
	private ArrayList<DishBean> currdishes=new ArrayList<>();
	
	public Tab2RecAdapter(Context c) {
		mcontext=c;
		inflater=LayoutInflater.from(c);
	}
	public void setData(ArrayList<DishBean> dis){
		dishes=dis;
		filter(null, null);
	}
	public void filter(String f1,String f2){
		if(f1==null||f1.equals("全部")){
			currdishes=dishes;
		}else{
			currdishes=new ArrayList<>();
			for(DishBean db:dishes){
				if(db.getType_title().equals(f1)){
					currdishes.add(db);
				}
			}
		}
		//排序
		if(f2!=null)
		Collections.sort(currdishes, new MySort(f2));
		this.notifyDataSetChanged();
	}
	
	
	@Override
	public int getItemCount() {
		return currdishes.size();
	}
	@Override
	public void onBindViewHolder(ViewHolder arg0, int arg1) {
		final ViewH vh=(ViewH) arg0;
		final DishBean dish=currdishes.get(arg1);
		vh.food_title.setText(dish.getTitle());
		vh.cartbtn_left.setText("¥"+dish.getPrice()+"  "+dish.getType_title());
		vh.food_desc.setText(dish.getDescription());
		Glide.with(mcontext).load(Common.RELEAST_HOST+dish.getImg()).placeholder(R.drawable.test_food).into(vh.img_food);
		ChefModel.findChef(dish.getChef_id(), new FindChefCallBack() {
			@Override
			public void findSuccess(ChefBean chef) {
				vh.name.setText(chef.getName());
				Glide.with(mcontext)
				.load(Common.RELEAST_HOST+chef.getImg())
				.placeholder(R.drawable.test_header)
				.into(vh.img_chef);
			}
			@Override
			public void findFaild() {
				vh.name.setText("未知");
				
				
			}
		});
		vh.cartbtn_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CartModel.add(dish.getId());
				((MainActivity)mcontext).refeshCart();
			}
		});
		vh.cartbtn_right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CartModel.add(dish.getId());
				((MainActivity)mcontext).refeshCart();
			}
		});
	}


	@Override
	public ViewH onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=inflater.inflate(R.layout.cell_tab2_rec, null);
		ViewH vh=new ViewH(view);
		FontUtil.init(1,vh.food_desc,vh.cartbtn_left,vh.cartbtn_right);
		FontUtil.init(2, vh.name);
		return vh;
	}
	class ViewH extends ViewHolder{
		@Bind(R.id.name) TextView name;
		@Bind(R.id.food_title) TextView food_title;
		@Bind(R.id.cartbtn_left) TextView cartbtn_left;
		@Bind(R.id.cartbtn_right) TextView cartbtn_right;
		@Bind(R.id.food_desc) TextView food_desc;
		@Bind(R.id.chef_headimg) MImageView img_chef;
		@Bind(R.id.food_img) ImageView img_food;
		@Bind(R.id.dish_food_en) TextView food_title_en;

		public ViewH(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
		
	}
	class MySort implements Comparator<DishBean>{
		String type;
		public MySort(String t) {
			type=t;
		}
		@Override
		public int compare(DishBean lhs, DishBean rhs) {
			int comp = 0;
			switch (type) {
			case "价格":
				comp=(int) (lhs.getPrice()-rhs.getPrice());
				break;
			case "推荐人数":
				comp=lhs.getRecommended()-rhs.getRecommended();
				break;
			case "销售数量":
				comp=lhs.getNum()-rhs.getNum();
				break;
			default:
				break;
			}
			return comp;
		}
		
	}


}

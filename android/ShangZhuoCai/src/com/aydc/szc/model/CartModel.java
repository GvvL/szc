package com.aydc.szc.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.aydc.szc.app.App;
import com.aydc.szc.entity.DishBean;
import com.aydc.szc.util.Logger;

public class CartModel {
	public static void add(int id){
		add(id, 1);
	}
	public static void add(int id,int num){
		int n=0;
		if(App.carts.containsKey(id)){
			n=App.carts.get(id)+num;
			App.carts.put(id, n);
		}else{
			App.carts.put(id, num);
		}
		if(App.carts.get(id)<0){
			App.carts.put(id, 0);
		}
	}
	public static int getCartNum(){
		if(App.carts.size()==0) return 0;
		int num=0;
		for(Integer n:App.carts.values()){
			if(n>0) num+=n;
		}
		Logger.e("-购物车数量-"+num+"--");
		return num;
	}
	public static int getCartSelNum(){
		if(App.carts.size()==0) return 0;
		int num=0;
		for(DishBean db:App.dishes){
			if(db.isCartSel()&&App.carts.containsKey(db.getId())){
				num+=App.carts.get(db.getId());
			}
		}
		return num;
	}

	public static float getCartPrice(){
		boolean isVip=false;
		if(App.islogin){
			isVip=App.getInstance().userinfo.getType()==1?true:false;
		}else{
			isVip=false;
		}
		if(App.dishes.size()==0) return 0;
		float price=0.0f;
		for(DishBean db:App.dishes){
			if(db.isCartSel()&&App.carts.containsKey(db.getId())){
				price+=(isVip?db.getVipprice():db.getPrice())*App.carts.get(db.getId());
			}
		}
		DecimalFormat decimalFormat=new DecimalFormat(".0");
		float ff=Float.parseFloat(decimalFormat.format(price));
		return ff;
	}
	/**
	 * 选中的种类
	 * @return
	 */
	public static int getCartSelCount(){
		int sel=0;
		for(DishBean db:App.dishes){
			if(db.isCartSel()&&App.carts.containsKey(db.getId())){
				if(App.carts.get(db.getId())>0){
					sel++;
				}
			}
		}
		return sel;
	}
	public static void deleCartSel(){
		for(DishBean db:App.dishes){
			if(db.isCartSel()&&App.carts.containsKey(db.getId())){
				if(App.carts.get(db.getId())>0){
					App.carts.put(db.getId(), 0);
				}
			}
		}
	}
	/**
	 * 实付获取选中的
	 * @param se
	 * @return
	 */
	public static ArrayList<DishBean> getCartDishes(boolean se){
		ArrayList<DishBean> dishes=new ArrayList<>();
		for(DishBean db:App.dishes){
			if(App.carts.containsKey(db.getId())&&App.carts.get(db.getId())>0){
				if(!se){
					dishes.add(db);
				}else{
					if(db.isCartSel()) dishes.add(db);
				}
			}
		}
		return dishes;
	}
	/**
	 * 是否全部选中
	 * @return
	 */
	public static boolean isAllSel(){
		boolean isallsel=true;
		for(DishBean db:App.dishes){
			if(App.carts.containsKey(db.getId())&&App.carts.get(db.getId())>0&&!db.isCartSel()){
				isallsel=false;
				break;
			}
		}
		return isallsel;
	}
	/**
	 * 全部选中、全部不选中
	 * @param sel
	 * @return
	 */
	public static void selAll(boolean sel){
		for(DishBean db:App.dishes){
			if(App.carts.containsKey(db.getId())&&App.carts.get(db.getId())>0&&db.isCartSel()!=sel){
				db.setCartSel(sel);
			}
		}
	}
	//获取菜品
	public static DishBean getDishBean(int id){
		DishBean dishbean=null;
		for(DishBean db:App.dishes){
			if(db.getId()==id){
				dishbean=db;
				break;
			}
		}
		return dishbean;
	}

}

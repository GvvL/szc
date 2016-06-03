package com.aydc.szc.entity;

import java.util.ArrayList;

public class Tab1Bean extends Bean{
	private ArrayList<DishBean> dishes;
	private ArrayList<CarouselBean> carousels;
	private ArrayList<ChefBean> chefs;
	public ArrayList<DishBean> getDishes() {
		return dishes;
	}
	public void setDishes(ArrayList<DishBean> dishes) {
		this.dishes = dishes;
	}
	public ArrayList<CarouselBean> getCarousels() {
		return carousels;
	}
	public void setCarousels(ArrayList<CarouselBean> carousels) {
		this.carousels = carousels;
	}
	public ArrayList<ChefBean> getChefs() {
		return chefs;
	}
	public void setChefs(ArrayList<ChefBean> chefs) {
		this.chefs = chefs;
	}
	
	


}

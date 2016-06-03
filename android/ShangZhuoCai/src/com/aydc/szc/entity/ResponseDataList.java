package com.aydc.szc.entity;

import java.util.ArrayList;
/**
 *多条返回
 * @param <T>
 */
public class ResponseDataList<T extends Bean> extends ResponseDataBase{
	private ArrayList<T> data;

	public ArrayList<T> getData() {
		return data;
	}
	public void setData(ArrayList<T> data) {
		this.data = data;
	}


}

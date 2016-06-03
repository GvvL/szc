//
//  DishModel.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/17.
//  Copyright © 2016年 Giw. All rights reserved.
//

class DishModel {
	var chefs = [ChefBean]()
	var dishes = [DishBean]()
	var cart = [Int: Int]() // 购物车
	static let instance = DishModel()
	private init() {
	}
	// 获取数据
	func loadIndexDatas(onserver: Bool, callback: (chefs: [ChefBean], dishes: [DishBean]) -> Void) {
		if !onserver {
			callback(chefs: self.chefs, dishes: self.dishes)
			return
		}
		NetUtil.GET(Constant.Method.IndexLoad, showToast: false, success: { (jsonData) -> Void in
			if jsonData["code"].intValue != Constant.RESPONSE.RESP_OK.rawValue {
				AppUtil.showToast("数据加载出错")
			} else {
				self.dishes = DishBean.json2ModelList(jsonData["data", "dishes"].object) as! [DishBean]
				self.chefs = ChefBean.json2ModelList(jsonData["data", "chefs"].object) as! [ChefBean]
			}
			callback(chefs: self.chefs, dishes: self.dishes)
			}
	) }
	// 首页要展示的菜品
	var recommend_dishes: [DishBean] {
		return self.dishes.filter({
			return $0.recommended == 1
		})
	}
}

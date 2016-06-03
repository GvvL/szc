//
//  DishBean.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/17.
//  Copyright © 2016年 Giw. All rights reserved.
//

import Foundation
@objc(DishBean)
class DishBean : BaseBean {
	var id = -1
	var Description = "本恶贝贝贝贝"
	var vipprice = 0.0
	var style = -1
	var favors = -1
	var recommended = -1
	var img = ""
	var title = ""
	var price = 0.0
	var type = -1
	var vedio = ""
	var chef_id = -1
	var en = ""
	var num = -1
	var type_title = ""
	var sales = -1
	var status = -1
	func getChef(callback: (chef: ChefBean?) -> Void) { // 现在内存找不到 去网络
		let cs = DishModel.instance.chefs.filter() {
			return $0.id == self.chef_id
		}
		if cs.count > 0 {
			callback(chef: cs[0])
			return
		}
		NetUtil.GET(Constant.Method.GetChefById, parameters: ["chefid": "\(self.chef_id)"], showToast: false, success: { (jsonData) -> Void in
			if jsonData["code"].intValue == Constant.RESPONSE.RESP_OK.rawValue {
				let chef = ChefBean.jsonToModel(jsonData["data"].object) as ChefBean
				callback(chef: chef)
			} else {
				callback(chef: nil)
			}
		}) { (err) -> Void in
			callback(chef: nil)
		}
	}
	var cartNum: Int {
		get {
			return DishModel.instance.cart[self.id] ?? 0
		}
		set {
			DishModel.instance.cart[self.id] = newValue
		}
	}
}

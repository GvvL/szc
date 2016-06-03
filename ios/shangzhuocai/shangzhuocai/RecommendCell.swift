//
//  RecommendCell.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/16.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit
import SDWebImage

class RecommendCell: UITableViewCell {
	weak var dish: DishBean?

	@IBOutlet weak var foodImg: UIImageView!

	@IBOutlet weak var foodChefImg: UIImageView!

	@IBOutlet weak var foodTitle: UILabel!

	@IBOutlet weak var foodDetail: UILabel!

	func initCell(db: DishBean) {
		self.dish = db
		foodImg.sd_setImageWithURL(NSURL(string: Constant.URL.HOST + self.dish!.img)!)
		foodTitle.text = dish?.title
		foodDetail.text = dish?.Description
		self.dish?.getChef({ (chef) -> Void in
			if let ch = chef {
				self.foodChefImg.sd_setImageWithURL(NSURL(string: Constant.URL.HOST + ch.img)!)
			}
		})
	}

	@IBAction func cartAddClick(sender: UIButton) {
	}
}

//
//  ChefCellTableViewCell.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/19.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit

class ChefCell: UITableViewCell {

	@IBOutlet weak var chefDetail: UILabel!
	@IBOutlet weak var chefRecommed: UILabel!
	@IBOutlet weak var chefRatingLabel: UILabel!
	@IBOutlet weak var chefType: UIButton!
	@IBOutlet weak var ratingBar: RatingBar!
	weak var chef: ChefBean?
	override func awakeFromNib() {
		super.awakeFromNib()
		// Initialization code
	}

	override func setSelected(selected: Bool, animated: Bool) {
		super.setSelected(selected, animated: animated)

		// Configure the view for the selected state
	}
	func initCell(chef: ChefBean) {
		self.chef = chef
		ratingBar.currValue = chef.grade
		chefType.setTitle(self.chef?.style_name, forState: UIControlState.Normal)
		chefRatingLabel.text = self.chef?.monicker
		let cr = (self.chef?.supporter.description ?? "0") + "人推荐"
		let crstr = NSMutableAttributedString(string: cr)
		crstr.addAttribute(NSUnderlineStyleAttributeName, value: 1, range: NSMakeRange(0, cr.characters.count))
		chefRecommed.attributedText = crstr
	}
}

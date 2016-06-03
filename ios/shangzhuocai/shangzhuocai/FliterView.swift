//
//  FliterView.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/18.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit

class FliterView: UIView {

	@IBOutlet weak var cate2: UIButton!
	@IBOutlet weak var cate1: UIButton!
	@IBOutlet weak var bg_btn: UIButton!
	required init?(coder aDecoder: NSCoder) {
			.."构造1"
		super.init(coder: aDecoder)
	}
	override init(frame: CGRect) {
			.."构造2"
		super.init(frame: frame)
	}
	override func drawRect(rect: CGRect) {
		super.drawRect(rect)
		bg_btn.backgroundColor = UIColor.blackColor()
		bg_btn.alpha = 0.0
		cate2.tag = 1000
		cate1.tag = 1000
		bg_btn.tag = 1000
	}
	@IBAction func cate1click(sender: UIButton) {
		UIView.animateWithDuration(0.8) { () -> Void in
			self.bg_btn.alpha = 0.3
		}
	}
	@IBAction func cate2click(sender: UIButton) {
		UIView.animateWithDuration(0.8) { () -> Void in
			self.bg_btn.alpha = 0.3
		}
	}
	@IBAction func bgClick(sender: UIButton) {
		UIView.animateWithDuration(0.8) { () -> Void in
			self.bg_btn.alpha = 0.0
		}
	}
	override func hitTest(point: CGPoint, withEvent event: UIEvent?) -> UIView? {
		let v = super.hitTest(point, withEvent: event)
		if v?.tag == 1000 {
			return v
		}
		return nil
	}
}

//
//  RatingBar.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/19.
//  Copyright © 2016年 Giw. All rights reserved.
//评分控件

import UIKit
protocol RatingBarDelegate {
	func ratingBarValueChangeTo(currValue: Float, oldValue: Float)
}
class RatingBar: UIView {
	var isIndicator = false
	private var imageViews = [UIImageView]()
	var marginSpec: CGFloat = 0// 星星间的间距
	let ratingNumMax = 5
	private var value: Float = 5
	var currValue: Float {
		set {
			var v: Float = 0.0
			v = max(0.0, newValue)
			v = min(Float(ratingNumMax), v)
			let newValue = Float(lroundf(v * 2.0)) / 2.0
			if newValue != self.value {
				self.delegate?.ratingBarValueChangeTo(newValue, oldValue: self.value)
				self.value = newValue
				refreshImages()
			}
		}
		get {
			return value
		}
	}
	var delegate: RatingBarDelegate?
	lazy var img_full = UIImage(named: "rating_star_full")
	lazy var img_half = UIImage(named: "rating_star_half")
	lazy var img_empty = UIImage(named: "rating_star_empty")
	private var ratingWidth: CGFloat!
	required init?(coder aDecoder: NSCoder) {
		super.init(coder: aDecoder)
	}
	override init(frame: CGRect) {
		super.init(frame: frame)
	}
	override func drawRect(rect: CGRect) {
		super.drawRect(rect)
		self.backgroundColor = UIColor.clearColor()
		ratingWidth = (frame.width - CGFloat(ratingNumMax - 1) * marginSpec) / CGFloat(ratingNumMax)
		for i in 0 ..< ratingNumMax {
			let iv = UIImageView(frame: CGRectMake(CGFloat(i) * (ratingWidth + marginSpec), 0, ratingWidth, frame.height))
			iv.backgroundColor = UIColor.clearColor()
			iv.contentMode = UIViewContentMode.ScaleAspectFit
			addSubview(iv)
		}
		refreshImages()
		self.userInteractionEnabled = isIndicator
		let tap = UITapGestureRecognizer(target: self, action: "click:")
		addGestureRecognizer(tap)
	}

	func click(s: UIGestureRecognizer) {
		let x = s.locationInView(self).x
		if ratingWidth <= 0.0 {
			self.currValue = Float(ratingNumMax)
			return
		}
		let n = x / (ratingWidth + marginSpec)
		// 处理在木椅出连续双击
		let c = Float(n) - currValue
		if c < 0.5 && c >= 0.0 {
			self.currValue += 0.5
		} else if c < 0 && c > -0.5 {
			self.currValue -= 0.5
		} else {
			self.currValue = Float(n)
		}
	}

	func refreshImages() {
		if (Int(self.value * 2.0) & 1) == 0 {
			for (k, iv) in self.imageViews.enumerate() {
				if (k + 1) <= Int(self.value) {
					iv.image = img_full
				} else {
					iv.image = img_empty
				}
			}
		} else {
			for (k, iv) in self.imageViews.enumerate() {
				if k == Int(self.value) {
					iv.image = img_half
				} else if k < Int(self.value) {
					iv.image = img_full
				} else {
					iv.image = img_empty
				}
			}
		}
	}

	override func addSubview(view: UIView) {
		super.addSubview(view)
		if let iv = (view as? UIImageView) {
			self.imageViews.append(iv)
		}
	}
}

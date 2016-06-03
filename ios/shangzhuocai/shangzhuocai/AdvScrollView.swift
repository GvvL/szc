//
//  AdvScrollView.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/15.
//  Copyright © 2016年 Giw. All rights reserved.
//广告条

import UIKit

class AdvScrollView: UIScrollView {
	var mydelegate: ScrollTouchDelegate?
	override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
		super.touchesBegan(touches, withEvent: event)
		mydelegate?.touchB()
	}
	override func touchesEnded(touches: Set<UITouch>, withEvent event: UIEvent?) {
		super.touchesEnded(touches, withEvent: event)
		mydelegate?.touchE()
	}
	override func touchesCancelled(touches: Set<UITouch>?, withEvent event: UIEvent?) {
		super.touchesCancelled(touches, withEvent: event)
		mydelegate?.touchE()
	}
}

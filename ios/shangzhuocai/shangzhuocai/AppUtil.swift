//
//  AppUtil.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/11.
//  Copyright © 2016年 Giw. All rights reserved.
//

import Foundation
import UIKit
struct AppUtil {
	static func getCurrentPage() -> UIViewController {
		var currentPage: UIViewController!
		var mainWindow = UIApplication.sharedApplication().keyWindow
		if mainWindow?.windowLevel != UIWindowLevelNormal {
			let windows = UIApplication.sharedApplication().windows
			for w in windows {
				if w.windowLevel == UIWindowLevelNormal {
					mainWindow = w
					break
				}
			}
		}
		let mainView = mainWindow?.subviews.first
		let nextResponder = mainView?.nextResponder()
		if let page = nextResponder as? UIViewController {
			currentPage = page
		} else {
			currentPage = mainWindow?.rootViewController
		}
		return currentPage
	}
	static func getTopPage() -> UIViewController? {
		var topVC = UIApplication.sharedApplication().keyWindow?.rootViewController
		while topVC?.presentedViewController != nil {
			topVC = topVC?.presentedViewController
		}
		return topVC
	}
	static func showToast(str: String) {
			..getTopPage()?.description
		getTopPage()?.view.makeToast(str)
	}
}

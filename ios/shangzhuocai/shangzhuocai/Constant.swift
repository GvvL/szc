//
//  Constant.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/10.
//  Copyright © 2016年 Giw. All rights reserved.
//

import Foundation
import UIKit
struct Constant {
	struct URL {
		static let HOST = "http://mt.ayidiancan.com/"
		static let ENDPOINT = "index.php/home/mobile/"
	}
	// 网络请求
	enum Method: String {
		case GetData = "getCfoodByCId"

		case IndexLoad = "indexload"
		case GetAllDishes = "getalldishes"
		case Login = "login"
		case GetChefById = "getchefbyid"
		case GetAllAddress = "getalladdress"
	}
	enum RESPONSE: Int {
		case RESP_OK = 200
	}
	struct CONFIG {
	}
	struct APP_Theme {
		/// APP导航条barButtonItem文字大小
		static let Font_NavItem: UIFont = UIFont.systemFontOfSize(16)
		/// APP导航条titleFont文字大小
		static let Font_NavTitle: UIFont = UIFont.systemFontOfSize(18)
		/// ViewController的背景颜色
		static let Color_Bg: UIColor = UIColor.colorWith(255, green: 255, blue: 255, alpha: 1)
	}
	struct COLOR {
		static let Green = UIColor(colorLiteralRed: 0.24, green: 0.45, blue: 0.04, alpha: 1)
	}
	struct APP {
		static let Bound = UIScreen.mainScreen().bounds
		static let Width = Bound.width
		static let Height = Bound.height
	}
	enum Error: String {
		case NET_ERROR = "网络异常"
	}
}

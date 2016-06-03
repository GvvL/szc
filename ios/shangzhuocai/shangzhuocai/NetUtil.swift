//
//  NetUtil.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/11.
//  Copyright © 2016年 Giw. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON
import Toast
import MBProgressHUD
struct NetUtil {

	static func request(method: Alamofire.Method, url: Constant.Method, parameters: [String: NSObject]?, showToast: Bool, success: ((JSON) -> Void)?, failure: ((NSError) -> Void)?) {
		let mainView = AppUtil.getTopPage()?.view
		let urlString = Constant.URL.HOST + Constant.URL.ENDPOINT + url.rawValue
			..urlString
		if showToast {
			MBProgressHUD.showHUDAddedTo(mainView, animated: true)
		}
		let req = Alamofire.request(method, urlString, parameters: parameters)
		req.responseJSON { (response) -> Void in
			if showToast {
				MBProgressHUD.hideAllHUDsForView(mainView, animated: true)
			}
			switch response.result {
			case .Success(let data):
				let jsonob = JSON(data)
				success?(jsonob)
			case .Failure(let err):
				failure?(err)
				AppUtil.showToast(Constant.Error.NET_ERROR.rawValue)
					..err
			}
		}
	}
	static func GET(url: Constant.Method, parameters: [String: NSObject]? = nil, showToast: Bool = true, success: ((JSON) -> Void)?, failure: ((NSError) -> Void)? = nil) {
		request(.GET, url: url, parameters: parameters, showToast: showToast, success: success, failure: failure)
	}
	static func POST(url: Constant.Method, parameters: [String: NSObject]? = nil, showToast: Bool = true, success: ((JSON) -> Void)?, failure: ((NSError) -> Void)? = nil) {
		request(.POST, url: url, parameters: parameters, showToast: showToast, success: success, failure: failure)
	}
}

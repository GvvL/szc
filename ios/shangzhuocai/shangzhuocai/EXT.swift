//
//  EXT.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/10.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit
prefix operator .. {
}
prefix func ..(msg: Any) {
	debugPrint("~~~--->>\(msg)")
}

extension UIColor {
	class func colorWith(red: Int, green: Int, blue: Int, alpha: CGFloat) -> UIColor {
		let color = UIColor(red: CGFloat(red) / 255.0, green: CGFloat(green) / 255.0, blue: CGFloat(blue) / 255.0, alpha: alpha)
		return color
	}
}

//md5
extension String {
	/// 返回字符串的 MD5 散列结果
	var md5: String! {
		let str = self.cStringUsingEncoding(NSUTF8StringEncoding)
		let strLen = CC_LONG(self.lengthOfBytesUsingEncoding(NSUTF8StringEncoding))
		let digestLen = Int(CC_MD5_DIGEST_LENGTH)
		let result = UnsafeMutablePointer<CUnsignedChar>.alloc(digestLen)

		CC_MD5(str!, strLen, result)

		let hash = NSMutableString()
		for i in 0 ..< digestLen {
			hash.appendFormat("%02x", result[i])
		}

		result.dealloc(digestLen)

		return hash.copy() as! String
	}
}
extension UITabBarItem {
	var orUnselImage: UIImage? {
		set {
			image = newValue?.imageWithRenderingMode(UIImageRenderingMode.AlwaysOriginal)
		}
		get {
			return nil
		}
	}
	var orSelImage: UIImage? {
		set {
			selectedImage = newValue?.imageWithRenderingMode(UIImageRenderingMode.AlwaysOriginal)
		}
		get {
			return nil
		}
	}
}

//
//  MineViewController.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/14.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit

class MineViewController: HasRefTitleVC {
	@IBOutlet weak var scrollview: UIScrollView!
	var photoVC: MinePhotoVC!
	var detailVC: MineDetailVC!
	override func viewDidLoad() {
		super.viewDidLoad()
		photoVC = childViewControllers.first as! MinePhotoVC
		detailVC = childViewControllers.last as! MineDetailVC
	}
	override func getNeedAddRefTitleView() -> UIScrollView? {
		return scrollview
	}
}

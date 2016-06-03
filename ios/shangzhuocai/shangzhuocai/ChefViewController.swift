//
//  Chef.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/14.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit

class ChefViewController: HasRefTitleVC {

	@IBOutlet weak var tableView: UITableView!
	@IBOutlet weak var tabmargintopspec: NSLayoutConstraint!
	lazy var fliterView = NSBundle.mainBundle().loadNibNamed("FliterView", owner: nil, options: nil).first as? FliterView
	override func viewDidLoad() {
		super.viewDidLoad()
		fliterView?.frame = view.frame
		view.addSubview(fliterView!)
		view.bringSubviewToFront(fliterView!)
		tabmargintopspec.constant = (fliterView?.cate1.bounds.height)!
	}
	override func getNeedAddRefTitleView() -> UIScrollView? {
		return tableView
	}
}

extension ChefViewController {
	func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
		return DishModel.instance.chefs.count
	}
	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
		let cell = tableView.dequeueReusableCellWithIdentifier("ChefCell") as! ChefCell
		cell.initCell(DishModel.instance.chefs[indexPath.row])
		return cell
	}

	func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
	}
}

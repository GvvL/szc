//
//  SecondViewController.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/9.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit

class DishViewController: HasRefTitleVC {
	@IBOutlet weak var table: UITableView!

	lazy var fliterView = NSBundle.mainBundle().loadNibNamed("FliterView", owner: nil, options: nil).first as? FliterView
	@IBOutlet weak var tableMarginTop: NSLayoutConstraint!

	override func viewDidLoad() {
		super.viewDidLoad()
		fliterView?.frame = view.frame
		view.addSubview(fliterView!)
		view.bringSubviewToFront(fliterView!)
		tableMarginTop.constant = (fliterView?.cate1.bounds.height)!
	}

	override func getNeedAddRefTitleView() -> UIScrollView? {
		return table
	}
}
extension DishViewController {
	func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
		return DishModel.instance.dishes.count
	}
	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
		let cell = tableView.dequeueReusableCellWithIdentifier("DishCell") as! DishCell
		cell.initCell(DishModel.instance.dishes[indexPath.row])
		return cell
	}

	func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
	}
}


//
//  FirstViewController.swift
//  shangzhuocai
//
//  Created by Giw on 16/5/9.
//  Copyright © 2016年 Giw. All rights reserved.
//

import UIKit
import MJRefresh

class IndexViewController: HasRefTitleVC {
	@IBOutlet weak var bgView: UIView!
	@IBOutlet var pic_gall: AdvScrollView!// 图片轮博
	@IBOutlet weak var scrollView: UIScrollView!

	@IBOutlet weak var pi_gall_contr: UIPageControl!// 指示器
	@IBOutlet weak var tableView: UITableView!

	@IBOutlet weak var viewHeight: NSLayoutConstraint!

	var pageFlag = false// 轮播自动回滚的标志位
	var pageTimer: NSTimer!// 轮播定时器
	let pageCount = 4
	override func viewDidLoad() {
		super.viewDidLoad()
		setupGall()
		setupTableView()
		bgView.hidden = true
		scrollView.mj_header.beginRefreshing()
	}
	override func loadDatas() {
		DishModel.instance.loadIndexDatas(true) { (chefs, dishes) -> Void in
			self.scrollView.mj_header.endRefreshing()
			self.bgView.hidden = false
			self.tableView.reloadData()
			self.setupTableView()
		}
	}

	override func getNeedAddRefTitleView() -> UIScrollView? {
		return scrollView
	}
	func setupTableView() {
		let cellheight = tableView.rowHeight
		let cellcount = tableView.numberOfRowsInSection(0)
		let ty = tableView.frame.origin.y
		viewHeight.constant = ty + cellheight * CGFloat(cellcount)
	}
	func setupGall() {

		pic_gall.contentSize = CGSizeMake(Constant.APP.Width * CGFloat(pageCount + 2), 0)
		pic_gall.delegate = self
		view.bringSubviewToFront(pi_gall_contr)
		pi_gall_contr.numberOfPages = pageCount
		let pic_h = pic_gall.bounds.height
		for i in 0 ..< pageCount + 2 {
			let imgView = UIImageView(frame: CGRectMake(Constant.APP.Width * CGFloat(i), 0, Constant.APP.Width, pic_h))
			imgView.image = UIImage(named: "test_img")
//			imgView.text = "第\(i)个"
//			imgView.backgroundColor = UIColor.brownColor()
			pic_gall.addSubview(imgView)
		}
		pic_gall.setContentOffset(CGPointMake(Constant.APP.Width, 0), animated: false)
		pi_gall_contr.currentPage = 0
		pageTimer = NSTimer.scheduledTimerWithTimeInterval(5, target: self, selector: "nextimg", userInfo: nil, repeats: true)
		pic_gall.mydelegate = self
	}

	func nextimg() {
		var curr = pi_gall_contr.currentPage
		curr++
		if curr != pageCount {
			pi_gall_contr.currentPage = curr
		} else {
			pageFlag = true
		}
		pic_gall.setContentOffset(CGPointMake(CGFloat(Double(curr) + 1) * Constant.APP.Width, 0), animated: true)
	}
}
extension IndexViewController: UITableViewDelegate, UITableViewDataSource {
	func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
		return DishModel.instance.recommend_dishes.count
	}
	func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
		let cell = tableView.dequeueReusableCellWithIdentifier("RecommendCell") as! RecommendCell
		cell.initCell(DishModel.instance.recommend_dishes[indexPath.row])
		return cell
	}

	func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
	}
}
protocol ScrollTouchDelegate {
	func touchB()
	func touchE()
}
//广告条扩展 回头封装一下
extension IndexViewController: UIScrollViewDelegate, ScrollTouchDelegate {

	func scrollViewDidScroll(scrollView: UIScrollView) {

		if pageFlag {
			let offsetX = scrollView.contentOffset.x
			let currpage = Int(offsetX / Constant.APP.Width)
			if currpage == pageCount + 1 {
				pageFlag = false
				setEnd2First()
			}
		}
	}

	func scrollViewDidEndDecelerating(scrollView: UIScrollView) {
		let offsetX = scrollView.contentOffset.x
		let currpage = Int(offsetX / Constant.APP.Width)
		if currpage == 0 {
			setFirst2End()
		} else if currpage == pageCount + 1 {
			setEnd2First()
		} else {
			pi_gall_contr.currentPage = currpage - 1
		}
	}
	func setFirst2End() {
		pi_gall_contr.currentPage = pageCount - 1
		pic_gall.setContentOffset(CGPointMake(CGFloat(pageCount) * Constant.APP.Width, 0), animated: false)
	}
	func setEnd2First() {
		pi_gall_contr.currentPage = 0
		pic_gall.setContentOffset(CGPointMake(Constant.APP.Width, 0), animated: false)
	}

	func touchB() {
			.."开"
		pageTimer.invalidate()
	}
	func touchE() {
			.."结束"
		pageTimer = NSTimer.scheduledTimerWithTimeInterval(3, target: self, selector: "nextimg", userInfo: nil, repeats: true)
	}
}

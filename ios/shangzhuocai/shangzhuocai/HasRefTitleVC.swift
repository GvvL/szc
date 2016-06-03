

import UIKit

class HasRefTitleVC: BaseVC {

	override func viewDidLoad() {
		super.viewDidLoad()
		if let tv = getNeedAddRefTitleView() {
			let diyHeader = SDRefreshHeader(refreshingTarget: self, refreshingAction: "loadDatas")
			diyHeader.lastUpdatedTimeLabel!.hidden = true
			diyHeader.stateLabel!.hidden = true
			diyHeader.gifView!.frame = CGRectMake((Constant.APP.Width - 35) * 0.5, 10, 35, 40)
			tv.mj_header = diyHeader
		}
	}
	func getNeedAddRefTitleView() -> UIScrollView? {
		return nil
	}
    //加载数据
	func loadDatas() {
	}
}

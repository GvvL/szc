

import UIKit

class DishCell: UITableViewCell {

	@IBOutlet weak var dishDetail: UILabel!
	@IBOutlet weak var dishName: UILabel!
	@IBOutlet weak var btn_add: UIButton!
	@IBOutlet weak var dishName_en: UILabel!
	@IBOutlet weak var dishChefHeader: UIImageView!
	@IBOutlet weak var dishImg: UIImageView!
	weak var dishbean: DishBean!
	@IBAction func dishAddClick(sender: UIButton) {
	}

	override func awakeFromNib() {
		super.awakeFromNib()
		dishChefHeader.layer.masksToBounds = true
		dishChefHeader.layer.cornerRadius = dishChefHeader.bounds.width / 2
		dishChefHeader.layer.borderWidth = 2
		dishChefHeader.layer.borderColor = UIColor.whiteColor().CGColor
	}

	override func setSelected(selected: Bool, animated: Bool) {
		super.setSelected(selected, animated: animated)

		// Configure the view for the selected state
	}
	func initCell(dish: DishBean) {
		dishbean = dish
		dishName.text = dishbean.title
		dishName_en.text = dishbean.en
		dishName.sizeToFit()
		btn_add.setTitle("¥" + dishbean.price.description + "  " + dishbean.type_title, forState: UIControlState.Normal)
		btn_add.sizeToFit()
		dishDetail.text = dishbean.Description
        dishImg.sd_setImageWithURL(NSURL(string: Constant.URL.HOST + dishbean.img)!)
		dishbean.getChef({ (chef) -> Void in
			if let ch = chef {
				self.dishChefHeader.sd_setImageWithURL(NSURL(string: Constant.URL.HOST + ch.img)!)
			}
		})
	}
}

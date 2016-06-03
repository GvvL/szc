

class UserModel {
	private var userinfo: UserBean?
	static let instance = UserModel()
	private init() {
	}
	// 本地读取+服务端异步回调
	func get(callback: ((UserBean) -> Void)? = nil) -> UserBean? {
        if let user=userinfo{
            return user
        }
		return userinfo
	}
	// 服务端－》客户端
	func update() {
	}
	// 客户端－》服务端
	func sync() {
	}
	// 实例化
	private func save() {
	}
}

package cn.hellozepp.ssm.mapper;

import cn.hellozepp.ssm.po.User;
import cn.hellozepp.ssm.po.UserInfo;

public interface UserMapper {

	//登录验证
	public User login(User user)throws Exception;
	//注册用户
	public void register(User user)throws Exception;
	//修改密码
	public void changePass(String username)throws Exception;
	//删除用户
	public void delUserByUsername(User user)throws Exception;

	//会员信息增删改查
	/**添加会员
	 * 1 查询user是否重复
	 * 2 插入
	 * */
	public UserInfo checkUserByUsername(String username)throws Exception;
	public void insertToUserInfo(UserInfo userInfo)throws Exception;


}

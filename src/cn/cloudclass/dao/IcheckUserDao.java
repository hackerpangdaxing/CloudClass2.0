package cn.cloudclass.dao;

public interface IcheckUserDao {
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户成功与否 0 失败 1成功
	 */
	public String findUser(String name,String password);
	/**
	 * 用户注册
	 * @param name 用户名
	 * @param password 密码
	 * @param object 用户实体类
	 * @return 用户注册成功与否 0失败 1成功
	 */
	public int addUser(Object object);
	/**
	 * 检查是否
	 * @param name 用户名
	 * @return
	 */
	public int selectUser(String name);
}

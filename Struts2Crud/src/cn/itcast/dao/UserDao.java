package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {
	/**
	 * 查询所有的客户
	 * @return
	 */
	List<User> findAllUsers();
	/**
	 * 根据查询条件查询客户
	 * @param condition 如果为null或者""，就是查询全部
	 * @return
	 */
	List<User> findUsersByCondition(String condition);
	/**
	 * 添加用户到数据库中
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 根据ID主键获取用户信息
	 * @param userId
	 * @return
	 */
	User findUserById(String userId);
	/**
	 * 修改客户信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 根据用户的id删除记录
	 * @param userId
	 */
	void deleteUser(String userId);
}

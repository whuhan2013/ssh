package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.User;

public interface UserService {

	List<User> findAllUsers();

	void addUser(User user);

	List<User> findUserByCondition(User user);

	void delUser(String userId);

	User findUserById(String userId);

	void updateUser(User user);

	User login(String username, String password);

}

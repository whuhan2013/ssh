package cn.itcast.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoMySqlImpl;
import cn.itcast.domain.User;
import cn.itcast.util.MD5Util;

public class UserDaoMySqlImplTest {
	private UserDao dao = new UserDaoMySqlImpl();
	@Test
	public void testAddUser() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("fsfdf");
		user.setNick("小桌子");
		user.setPassword(MD5Util.encode("123fd"));
		user.setSex("1");
		user.setBirthday(new Date());
		user.setEducation("研究生");
		user.setTelephone("110");
		user.setHobby("篮球,足球,乒乓球");
		user.setPath("/path");
		user.setFilename("gxzp.jpg");
		user.setRemark("这是简介");
		dao.addUser(user);
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllUsers() {
		List<User> users = dao.findAllUsers();
		for(User u:users)
			System.out.println(u);
	}

	@Test
	public void testFindUsersByCondition() {
		List<User> users = dao.findUsersByCondition("where nick like '小%'");
		for(User u:users)
			System.out.println(u);
	}

	@Test
	public void testFindUserById() {
		User user = dao.findUserById("9bc65fcb-5c49-486f-a3a5-f1dc3e5b1efe");
		System.out.println(user);
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

}

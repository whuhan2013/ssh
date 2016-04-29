package cn.itcast.service.impl;

import java.util.List;
import java.util.UUID;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoMySqlImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.util.MD5Util;

public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoMySqlImpl();
	public List<User> findAllUsers(){
		return dao.findAllUsers();
	}
	public void addUser(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setPassword(MD5Util.encode(user.getPassword()));
		dao.addUser(user);
	}
	public List<User> findUserByCondition(User user) {
		boolean ok1 = true;
		boolean ok2 = true;
		boolean ok3 = true;
		StringBuffer sb = new StringBuffer("where 1=1 ");
		
		
		if(user.getUsername()!=null&&!user.getUsername().equals("")){
			ok1 = false;
			sb.append(" and username like '%"+user.getUsername()+"%' ");
		}
		if(user.getSex()!=null&&!user.getSex().equals("")){
			ok2 = false;
			sb.append(" and sex='"+user.getSex()+"'");
		}
			
		if(user.getEducation()!=null&&!user.getEducation().equals("")){
			ok3 = false;
			sb.append(" and education='"+user.getEducation()+"'");
		}
		
		boolean conditionOk = ok1&&ok2&&ok3;//如果为false，说明至少有一个查询条件
		if(conditionOk){
//			System.out.println("没有查询条件");
//			return null;
			return dao.findUsersByCondition(null);
		}else{
//			System.out.println("有查询条件");
//			System.out.println(sb.toString());
//			return null;
			return dao.findUsersByCondition(sb.toString());
		}
	}
	public void delUser(String userId) {
		dao.deleteUser(userId);
	}
	public User findUserById(String userId) {
		return dao.findUserById(userId);
	}
	public void updateUser(User user) {
		user.setPassword(MD5Util.encode(user.getPassword()));
		dao.updateUser(user);
	}
	public User login(String username, String password) {
		if(username==null||password==null)
			throw new IllegalArgumentException();
		password = MD5Util.encode(password);
		List<User> users = dao.findUsersByCondition("where username='"+username+"' and password='"+password+"'");
		if(users!=null&&users.size()==1)
			return users.get(0);
		else
			return null;
	}

}

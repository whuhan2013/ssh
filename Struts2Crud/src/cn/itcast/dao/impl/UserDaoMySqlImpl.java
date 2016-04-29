package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.exception.DaoException;
import cn.itcast.util.DBCPUtil;

public class UserDaoMySqlImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public void addUser(User user) {
		if(user.getId()==null||user.getId().trim().equals(""))
			throw new RuntimeException("The id can not be empty");
		try {
			String sql = "insert into user (id,username,nick,password,sex,birthday,education,telephone,hobby,path,filename,remark) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			Object params[] = { user.getId(), user.getUsername(), user.getNick(),
					user.getPassword(), user.getSex(), user.getBirthday(),
					user.getEducation(), user.getTelephone(), user.getHobby(),
					user.getPath(), user.getFilename(), user.getRemark() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public void deleteUser(String userId) {
		if(userId==null||userId.trim().equals(""))
			throw new RuntimeException("The id can not be empty");
		try {
			String sql = "delete from user where id=?";
			qr.update(sql, userId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public List<User> findAllUsers() {
		try {
			String sql = "select * from user";
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public List<User> findUsersByCondition(String condition) {
		try {
			if(condition==null||condition.trim().equals("")){
				return findAllUsers();
			}
			if(!condition.trim().startsWith("where")&&!condition.trim().startsWith("WHERE")){
				throw new RuntimeException("The param condition must be start with where");
			}
			return qr.query("select * from user "+condition,new BeanListHandler<User>(User.class));
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	public User findUserById(String userId) {
		if(userId==null||userId.trim().equals(""))
			throw new RuntimeException("The id can not be empty");
		try {
			List<User> users = findUsersByCondition("where id='"+userId+"'");
			if(users!=null&&users.size()>0){
				return users.get(0);
			}else
				return null;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	

	public void updateUser(User user) {
		if(user.getId()==null||user.getId().trim().equals(""))
			throw new RuntimeException("The id can not be empty");
		try {
			String sql = "update  user set username=?,nick=?,password=?,sex=?,birthday=?,education=?,telephone=?,hobby=?,path=?,filename=?,remark=? where id=?";
			Object params[] = {  user.getUsername(), user.getNick(),
					user.getPassword(), user.getSex(), user.getBirthday(),
					user.getEducation(), user.getTelephone(), user.getHobby(),
					user.getPath(), user.getFilename(), user.getRemark(),user.getId() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}

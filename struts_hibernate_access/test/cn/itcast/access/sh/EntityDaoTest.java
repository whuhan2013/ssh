package cn.itcast.access.sh;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.sh.dao.EntityDao;
import cn.itcast.sh.dao.EntityDaoFactory;
import cn.itcast.sh.domain.Role;
import cn.itcast.sh.domain.User;
import cn.itcast.sh.utils.HiberanteUtils;

public class EntityDaoTest extends HiberanteUtils{
	@Test
	public void testAllQuery(){
		EntityDao entityDao = new EntityDao();
		List<User> userList = entityDao.find(User.class);
		System.out.println(userList.size());
	}
	
	@Test
	public void testfindByID() throws Exception{
		EntityDao entityDao = EntityDaoFactory.getInstance(EntityDao.class);
		User user = entityDao.findByID(User.class, 1L);
		System.out.println(user.getUsername());
	}
	
	@Test
	public void testSaveUser() throws Exception{
		EntityDao entityDao = EntityDaoFactory.getInstance(EntityDao.class);
		User t = new User();
		t.setUsername("asfd");
		entityDao.saveEntry(t);
	}
	
	@Test
	public void testQuery() throws Exception{
		Session session  = sessionFactory.openSession();
		List<User> userList = session.createQuery("from User u left outer join fetch u.roles r left outer join fetch r.privileges p").list();
		Set<User> users = new HashSet<User>(userList);
		System.out.println(users.size());
		session.close();
	}
	
	@Test
	public void testQuery2() throws Exception{
		Session session  = sessionFactory.openSession();
		List<Role> roleList = session.createQuery("from Role r where r.users.uid=1").list();
		System.out.println(roleList.size());
		session.close();
	}
}

package cn.itcast.sh.access;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;

import cn.itcast.sh.domain.Privilege;
import cn.itcast.sh.domain.Role;
import cn.itcast.sh.domain.User;
import cn.itcast.sh.utils.HiberanteUtils;

public class AccessListener extends HiberanteUtils implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		/**
		 * 在tomcat关闭的时候，把application域中的权限值移除
		 */
		arg0.getServletContext().removeAttribute("privilege");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		Session session  = sessionFactory.openSession();
		List<User> userList = session.createQuery("from User u left outer join fetch u.roles r left outer join fetch r.privileges p").list();
		Set<User> users = new HashSet<User>(userList);
		Map<String, Set<Privilege>> map = new HashMap<String, Set<Privilege>>();
		for(User user:users){
			Set<Role> roles = user.getRoles();
			Set<Privilege> privileges = new HashSet<Privilege>();
			map.put(user.getUsername(), privileges);
			for(Role role:roles){
				Set<Privilege> privileges1 = role.getPrivileges();
				Set<Privilege> ps = map.get(user.getUsername());
				ps.addAll(privileges1);
			}
		}
		session.close();
		arg0.getServletContext().setAttribute("privilege", map);
	}

}

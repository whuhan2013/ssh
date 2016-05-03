package cn.itcast.sh.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import cn.itcast.sh.dao.EntityDao;
import cn.itcast.sh.dao.EntityDaoFactory;
import cn.itcast.sh.domain.Privilege;
import cn.itcast.sh.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private User model = new User(); 
	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String login() throws Exception{
		EntityDao entityDao = EntityDaoFactory.getInstance(EntityDao.class);
		User user = entityDao.findUser(User.class, this.getModel().getUsername(), this.getModel().getPassword());
		Map<String, Set<Privilege>> map = (HashMap<String, Set<Privilege>>)ServletActionContext.getServletContext().getAttribute("privilege");
		Set<Privilege> privileges = map.get(user.getUsername());//该用户能够访问到的权限值
		ServletActionContext.getRequest().getSession().setAttribute("privilege_session", privileges);
		return "index";
	}
}

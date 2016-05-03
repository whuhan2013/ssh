package cn.itcast.sh.action;

import java.util.List;

import cn.itcast.sh.dao.EntityDao;
import cn.itcast.sh.dao.EntityDaoFactory;
import cn.itcast.sh.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User model = new User();

	public User getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}
	
	public String aa() throws Exception{
		EntityDao entityDao = EntityDaoFactory.getInstance(EntityDao.class);
		List<User> userList = entityDao.find(User.class);
		/**
		 * push方法可以把一个对象放入到栈顶
		 * add(obj)把obj放入到栈底
		 * add(0,obj)把obj放入到栈顶
		 * peek获取栈顶元素
		 * pop移除栈顶元素
		 */
		//ActionContext.getContext().getValueStack().push(userList);
		//ActionContext.getContext().getValueStack().getRoot().add(0,userList);
		ActionContext.getContext().put("userList", userList);
		System.out.println(userList.size());
		//ActionContext.getContext().getValueStack().pop();
		return "userList";
	}
}

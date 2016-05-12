package com.zxt.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport {

	/**
	  * 
	  */
	private static final long serialVersionUID = 7443363719737618408L;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身高
	 */
	private String inch;
	/**
	 * ajax返回结果，也可是其他类型的，这里以String类型为例
	 */
	private List<PersonBean> result;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<PersonBean> pList = new ArrayList<PersonBean>();
		if ("张三".equals(name)) {
			PersonBean p1 = new PersonBean();
			PersonBean p2 = new PersonBean();
			p1.setId(1);
			p1.setName("a");
			p2.setId(2);
			p2.setName("b");
			pList.add(p1);
			pList.add(p2);
			result = pList;
		} else {
			PersonBean p3 = new PersonBean();
			PersonBean p4 = new PersonBean();
			p3.setId(3);
			p3.setName("c");
			p4.setId(4);
			p4.setName("d");
			pList.add(p3);
			pList.add(p4);
			result = pList;
		}
		return SUCCESS;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInch() {
		return inch;
	}

	public void setInch(String inch) {
		this.inch = inch;
	}

	/**
	 * 
	 * @Title: getResult
	 * @Description:json调取结果
	 * @param @return
	 * @return String
	 * @throws
	 */
	public List<PersonBean> getResult() {
		return result;
	}
}

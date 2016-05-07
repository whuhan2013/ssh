package cn.itcast.spring.mvc.exception.dao.impl;

import cn.itcast.spring.mvc.exception.dao.PersonDao;
import cn.itcast.spring.mvc.myexception.Exception1;

public class PersonDaoImpl implements PersonDao{

	@Override
	public void savePerson() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("save person");
		throw new Exception1("在操作dao时失败了");
	}

}

package cn.itcast.spring.jdbc.transaction.sh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import cn.itcast.spring.jdbc.transaction.bean.Person;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao{

	@Override
	public List<Person> getPerson() {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query("select * from person", new RowMapper() {
			
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Person person = new Person();
				person.setPid(rs.getLong("pid"));
				person.setPname(rs.getString("pname"));
				person.setPsex(rs.getString("psex"));
				return person;
			}
		});
	}

	@Override
	public void savePerson() {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().update("insert into person(pname,psex) values('a','a')");
	}
	
}

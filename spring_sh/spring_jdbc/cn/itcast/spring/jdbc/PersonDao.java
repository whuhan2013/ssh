package cn.itcast.spring.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDao extends JdbcDaoSupport{
	public void update(){
		this.getJdbcTemplate().execute("update person set pname='a' where pid=3");
	}
	
	public void query(){
		List<Person> persons = this.getJdbcTemplate().query("select * from person", new PersonRowMapper());
		for(Person person:persons){
			System.out.println(person.getPname());
		}
	}
}

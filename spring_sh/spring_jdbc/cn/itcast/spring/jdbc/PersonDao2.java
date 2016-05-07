package cn.itcast.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao2 extends JdbcTemplate{
	public PersonDao2(DataSource dataSource){
		super(dataSource);
	}
	public void update(){
		this.execute("update person set pname='aa' where pid=2");
	}
}

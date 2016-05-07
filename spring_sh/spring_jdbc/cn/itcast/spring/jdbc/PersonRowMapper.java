package cn.itcast.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setPid(rs.getLong("pid"));
		person.setPname(rs.getString("pname"));
		person.setPsex(rs.getString("psex"));
		return person;
	}
	/**
	 * crud做一下
	 */

}

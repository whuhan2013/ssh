package cn.itcast.sh.domain;

import java.io.Serializable;
import java.util.Set;

public class Privilege implements Serializable{
	private Long pid;
	private String name;
	private String description;
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	private Set<Role> roles;
}

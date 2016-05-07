package cn.itcast.spring.hiberante.transaction.domain;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private Long pid;
	private String pname;
	private String psex;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */
	public Person(String pname, String psex) {
		this.pname = pname;
		this.psex = psex;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsex() {
		return this.psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

}
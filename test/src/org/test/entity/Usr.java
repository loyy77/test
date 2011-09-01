package org.test.entity;

import java.io.Serializable;


public class Usr implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String usrname;
	private String password;

	public Usr() {
		super();
	
	}

	public Usr(String usrname, String password) {
		super();
		this.usrname = usrname;
		this.password = password;
	}
	

	public Usr(Integer id, String usrname, String password) {
		super();
		this.id = id;
		this.usrname = usrname;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

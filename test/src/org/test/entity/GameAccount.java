/**
 * 
 */
package org.test.entity;

import java.io.Serializable;

/**
 * @author Loyy
 * 
 */
public class GameAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4339136165007362785L;
	private Integer id;
	private Usr usr;
	private String name;
	private String loginname;
	private String loginpwd;
	private String mark;

	public GameAccount(Usr usr, String name, String loginname, String loginpwd,
			String mark) {
		super();
		this.usr = usr;
		this.name = name;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.mark = mark;
	}

	public GameAccount(Integer id, Usr usr, String name, String loginname,
			String loginpwd, String mark) {
		super();
		this.id = id;
		this.usr = usr;
		this.name = name;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.mark = mark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usr getUsr() {
		return usr;
	}

	public void setUsr(Usr usr) {
		this.usr = usr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * 
	 */
	public GameAccount() {
		// TODO Auto-generated constructor stub
	}

}

package org.test.entity;

import java.io.Serializable;

public class Diray implements Serializable {
	/**
	 * »’º«¿‡
	 */
	private static final long serialVersionUID = 1883608073317801489L;
	private Integer id;
	private String title;
	private String centent;

	public Diray(Integer id, String title, String centent) {
		super();
		this.id = id;
		this.title = title;
		this.centent = centent;
	}

	public Diray(String title, String centent) {
		super();
		this.title = title;
		this.centent = centent;
	}

	public Diray() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCentent() {
		return centent;
	}

	public void setCentent(String centent) {
		this.centent = centent;
	}

}

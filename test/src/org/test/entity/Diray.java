package org.test.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diray implements Serializable {
	/**
	 * »’º«¿‡
	 */
	private static final long serialVersionUID = 1883608073317801489L;
	private Integer id;
	private String title;
	private String centent;
	private Usr usr;
	private String publishtime;

	public String getPublishtime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=sdf.format(new Date());
		publishtime=time;
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		
		this.publishtime = publishtime;
	}

	public Diray(Integer id, String title, String centent, Usr usr,
			String publishtime) {
		super();
		this.id = id;
		this.title = title;
		this.centent = centent;
		this.usr = usr;
		this.publishtime = publishtime;
	}

	public Diray(String title, String centent, Usr usr, String publishtime) {
		super();
		this.title = title;
		this.centent = centent;
		this.usr = usr;
		this.publishtime = publishtime;
	}

	public Usr getUsr() {
		return usr;
	}

	public void setUsr(Usr usr) {
		this.usr = usr;
	}

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

	public Diray(String title, String centent, Usr usr) {
		super();
		this.title = title;
		this.centent = centent;
		this.usr = usr;
	}

	public Diray(Integer id, String title, String centent, Usr usr) {
		super();
		this.id = id;
		this.title = title;
		this.centent = centent;
		this.usr = usr;
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

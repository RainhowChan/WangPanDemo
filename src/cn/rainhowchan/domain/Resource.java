package cn.rainhowchan.domain;

import java.util.Date;

public class Resource {
	private int id;
	private String uuidname;
	private String realname;
	private String savepath;
	private Date uploadtime;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", uuidname=" + uuidname + ", realname="
				+ realname + ", savepath=" + savepath + ", uploadtime="
				+ uploadtime + ", description=" + description + "]";
	}
	
	
}
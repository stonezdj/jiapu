package com.zdj.jiapu.domain.model;

import java.sql.Date;

public class Article {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFamilyid() {
		return familyid;
	}
	public void setFamilyid(int familyid) {
		this.familyid = familyid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private int id;
	private int familyid;
	private String title;
	private String content;
	private Date createDate;
	private String username;
	private int orderid;
	private String category;
	@Override
	public String toString() {
		return "Article [id=" + id + ", familyid=" + familyid + ", title="
				+ title + ", content=" + content + ", createDate=" + createDate
				+ ", username=" + username + ", orderid=" + orderid
				+ ", category=" + category + "]";
	}	
	
	
}

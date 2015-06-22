package com.zdj.jiapu.domain.model;

import java.sql.Date;

public class UserOperation {
	public int getOperationid() {
		return operationid;
	}
	public void setOperationid(int operationid) {
		this.operationid = operationid;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private int operationid;
	private String username;
	private int type;
	private Date createDate;
	private String code;
	@Override
	public String toString() {
		return "UserOperation [operationid=" + operationid + ", userid="
				+ username + ", type=" + type + ", createDate=" + createDate
				+ ", code=" + code + "]";
	}
	
	
}

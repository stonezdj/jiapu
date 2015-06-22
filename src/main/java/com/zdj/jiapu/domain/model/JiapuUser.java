package com.zdj.jiapu.domain.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class JiapuUser {
	  public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public int getFamilyid() {
		return familyid;
	}
	public void setFamilyid(int familyid) {
		this.familyid = familyid;
	}
	public int getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	private String realname;
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}

	private String username;
	@Size(min=6, max=10, message="密码必须为长度为6-10位字符！")
	private String password;
	@Email(message="不是标准的Email地址格式")
	private String email_address;
	@Size(min=8, max=11, message="电话号码格式不对！")
	private String mobile_phone;
	
	private int personid;
	private int familyid;
	private int isEnabled;
	private String userrole;
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getRepeatpwd() {
		return repeatpwd;
	}
	public void setRepeatpwd(String repeatpwd) {
		this.repeatpwd = repeatpwd;
	}


	private String repeatpwd;

	@Override
	public String toString() {
		return "JiapuUser [realname=" + realname + ", username=" + username
				+ ", password=" + password + ", email_address=" + email_address
				+ ", mobile_phone=" + mobile_phone + ", personid=" + personid
				+ ", familyid=" + familyid + ", isEnabled=" + isEnabled
				+ ", userrole=" + userrole + "]";
	}
	


	  
}

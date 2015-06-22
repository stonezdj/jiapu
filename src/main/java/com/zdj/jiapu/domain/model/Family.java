package com.zdj.jiapu.domain.model;

import javax.validation.constraints.Size;

public class Family {
 	public int getFamilyid() {
		return familyid;
	}
	public void setFamilyid(int familyid) {
		this.familyid = familyid;
	}
	
	
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getVillege() {
		return villege;
	}
	public void setVillege(String villege) {
		this.villege = villege;
	}
	public String getSmallvillege() {
		return smallvillege;
	}
	public void setSmallvillege(String smallvillege) {
		this.smallvillege = smallvillege;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private int familyid;
	@Size(min=1, max=20, message="长度必须大于1小于10!")
 	private String familyname;
	@Size(min=1, max=20, message="长度必须大于1小于10!")
 	private String province;
	@Size(min=1, max=20, message="长度必须大于1小于10!")
 	private String county;
	@Size(min=1, max=20, message="长度必须大于1小于10!")
 	private String town;
 	private String villege;
 	private String smallvillege;
 	private String username;
	@Override
	public String toString() {
		return "Family [familyid=" + familyid + ", familyname=" + familyname
				+ ", province=" + province + ", county=" + county + ", town="
				+ town + ", villege=" + villege + ", smallvillege="
				+ smallvillege + ", username=" + username + "]";
	}
 	
}

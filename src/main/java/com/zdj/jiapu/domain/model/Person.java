package com.zdj.jiapu.domain.model;

import java.sql.Date;

public class Person {
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOthername() {
		return othername;
	}
	public void setOthername(String othername) {
		this.othername = othername;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getDeath() {
		return death;
	}
	public void setDeath(Date death) {
		this.death = death;
	}
	public String getDeeds() {
		return deeds;
	}
	public void setDeeds(String deeds) {
		this.deeds = deeds;
	}
	public String getMisc() {
		return misc;
	}
	public void setMisc(String misc) {
		this.misc = misc;
	}
	private int personid;
	private int parentid;
	private String name;
	private String othername;
	private int sex;
	private Date birth;
	private Date death;
	private String deeds;
	private String misc;
	private int familyid;
	private String marriage;
	private String tomblocation;
	
	public String getTomblocation() {
		return tomblocation;
	}
	public void setTomblocation(String tomblocation) {
		this.tomblocation = tomblocation;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public int getFamilyid() {
		return familyid;
	}
	public void setFamilyid(int familyid) {
		this.familyid = familyid;
	}
	@Override
	public String toString() {
		return "Person [personid=" + personid + ", parentid=" + parentid
				+ ", name=" + name + ", othername=" + othername + ", sex="
				+ sex + ", birth=" + birth + ", death=" + death + ", deeds="
				+ deeds + ", misc=" + misc + ", familyid=" + familyid
				+ ", marriage=" + marriage + ", tomblocation=" + tomblocation
				+ "]";
	}
	
	
	
	
}

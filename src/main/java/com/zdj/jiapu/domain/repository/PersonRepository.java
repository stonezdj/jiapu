package com.zdj.jiapu.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zdj.jiapu.domain.model.Person;

public interface PersonRepository {
	@Insert("insert into person (parentid,name,othername,sex,birth,death,deeds,misc, familyid, marriage, tomblocation) "
			+ "values (#{parentid}, #{name}, #{othername}, #{sex}, #{birth}, #{death}, #{deeds}, #{misc}, #{familyid}, #{marriage}, #{tomblocation})")
	public void addPerson(Person person);
	
	@Select("select * from person where familyid = #{familyid} order by birth desc")
	public List<Person> getAllPerson(int fmailyid);
	
	@Update("update person set parentid=#{parentid},name=#{name},othername=#{othername},"
			+ "sex=#{sex},birth=#{birth},death=#{death},deeds=#{deeds},misc=#{misc}, "
			+ "familyid=#{familyid}, marriage=#{marriage}, tomblocation=#{tomblocation}, parentid=#{parentid} where personid= #{personid}")
	public void updatePerson(Person person);
	
	@Update("update person set parentid = #{parentid} where personid = #{childid} ")
	public void updateParent(int childid, int parentid);
	
	@Select("select * from person where personid = #{personid}")
	public Person getPersonByID(int personid);
	
	@Delete("delete from person where personid = #{personid} ")
	public void deletePerson(int personid);
	
	
	@Select("select * from person where parentid = #{personid} ")
	public List<Person> getAllChildren(int personid);
	
}

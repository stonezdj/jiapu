package com.zdj.jiapu.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zdj.jiapu.domain.model.Family;

public interface FamilyRepository {
	@Insert("insert into family (province, county, town, villege, smallvillege, familyname) values"
			                   + "(#{province}, #{county}, #{town}, #{villege}, #{smallvillege}, #{familyname})")
	public void insertFamily(Family family);
	
	@Select("select * from family where familyid=#{id}")
	public Family selectFamily(int familyid);
	
	@Update("update family set familyname = #{familyname}, province=#{province}, town=#{town}, villege = #{villege}, smallvillege=#{smallvillege}  where familyid= #{familyid}")
	public void updateFamily(Family family);
	
	@Select("select * from family where familyname like #{word}")
	public List<Family> searchFamily(String word);
	
	@Select("select * from family order by familyid desc limit 5")
	public List<Family> lastFamilyList();
	
	@Update("update jiapuuser set familyid = #{0} where username = #{1}")
	public void joinFamily(int familyid, String username);

}

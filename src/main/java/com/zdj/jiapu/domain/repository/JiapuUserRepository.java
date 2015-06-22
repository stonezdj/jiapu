package com.zdj.jiapu.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zdj.jiapu.domain.model.Family;
import com.zdj.jiapu.domain.model.JiapuUser;

public interface JiapuUserRepository {
	@Select("select * from jiapuuser where username = #{username}")
	public JiapuUser findUserByUsername(String username);
	
	@Insert("insert into jiapuuser (username, realname, password, email_address, mobile_phone, isenabled) values"
			                  + " (#{username}, #{realname}, #{password}, #{email_address}, #{mobile_phone}, #{isEnabled})")
	public void insertUser(JiapuUser user);
	
	@Update("update jiapuuser set isEnabled= 1 where username = #{username}")
	public void enableUser(String username);
	
	@Update("update jiapuuser set isEnabled= 0 where username = #{username}") 
	public void disableUser(String username);	
	
	@Select("select * from jiapuuser")
	public List<JiapuUser> listAllUser();
	
	@Update("update jiapuuser set isenabled= 0 where username = #{username}")
	public void changePassword(String username, String newpassword);
	
	@Update("update jiapuuser set userrole = 'ADMIN_USER' where username=#{username}")
	public void setUserAdmin(String username);
	
	
	@Select("select familyid from userfamily where username = #{username}")
	public List<Integer> getFamilyList(String username);
	
	@Select("select * from family where familyid in (select familyid from userfamily where username = #{username})")
	public List<Family> getMyFamilies(JiapuUser user);
	
	  
}

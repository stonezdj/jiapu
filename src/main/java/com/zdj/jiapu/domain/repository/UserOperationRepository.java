package com.zdj.jiapu.domain.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zdj.jiapu.domain.model.UserOperation;

public interface UserOperationRepository {
	
	@Select("select * from useroperation where username = #{username} and code = #{code}")
	public UserOperation getOperation(String username, String code);
	
	@Insert("insert into useroperation (username, code, createDate, type) values (#{username}, #{code}, #{createDate}, #{type})")
	public void insertOperation(UserOperation userOperation);
	
	@Delete("delete from useroperation where operationid = #{operationid}")
	public void deleteUserOperation(UserOperation userOperation);
	
}

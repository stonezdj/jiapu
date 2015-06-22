package com.zdj.jiapu.domain.service;

import java.util.List;

import com.zdj.jiapu.domain.model.Family;
import com.zdj.jiapu.domain.model.JiapuUser;

public interface JiapuUserService {
	public void insertUser(JiapuUser user);

	public JiapuUser findUserByUsername(String username);
	
	public void enableUser(String  username);
	
	public void disableUser(String username);
	
	public List<JiapuUser> listJiapuUser();
	
	public void changePassword(String username, String newpassword);
	
	public void sendValidationMail(JiapuUser user);
	
	public JiapuUser getCurrentUser();
	
	public boolean enableUserByCode(String username, String code);
	
	public void setUserAdminRole(String username);
	
	public List<Integer> getFamilyList(String username);
	
	public List<Family> getMyFamilies(JiapuUser user);
	
	public boolean canSeeFamily(int familyid, JiapuUser user);
}

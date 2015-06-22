package com.zdj.jiapu.domain.service;

import java.util.List;

import com.zdj.jiapu.domain.model.Family;

public interface FamilyService {
	public void addFamily(Family family);
	public Family findFamily(int familyid);
	public void updateFamily(Family family);
	public List<Family> searchFamily(String word);
	public List<Family> lastFamilyList();
	public void joinFamily(int familyid, String username);
}

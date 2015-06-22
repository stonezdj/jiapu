package com.zdj.jiapu.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zdj.jiapu.domain.model.Family;
import com.zdj.jiapu.domain.repository.FamilyRepository;


@Service
public class FamilyServiceImpl implements FamilyService {
	
	@Inject
	private FamilyRepository familyRepository;

	public void addFamily(Family family) {
		
		familyRepository.insertFamily(family);
	}

	public Family findFamily(int familyid) {
		return familyRepository.selectFamily(familyid);
	}

	@Override
	public void updateFamily(Family family) {
		familyRepository.updateFamily(family);		
	}

	@Override
	public List<Family> searchFamily(String word) {
		return familyRepository.searchFamily("%"+word+"%");
	}

	@Override
	public List<Family> lastFamilyList()
	{
		return familyRepository.lastFamilyList();
	}
	
	public void joinFamily(int familyid, String username)
	{
		familyRepository.joinFamily(familyid, username);
	}
}

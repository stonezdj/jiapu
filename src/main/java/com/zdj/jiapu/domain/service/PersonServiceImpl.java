package com.zdj.jiapu.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.model.Person;
import com.zdj.jiapu.domain.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Inject
	private PersonRepository personRepository;
	
	@Inject
	private JiapuUserService jiapuUserService;

	@Override
	public void addPerson(Person person) {
		
		if(person.getFamilyid()==0)
		{
			JiapuUser user = jiapuUserService.getCurrentUser();
			if(user!=null)
			{
				person.setFamilyid(user.getFamilyid());
			}
		}
		
		personRepository.addPerson(person);
		
	}

	@Override
	public List<Person> getAllPerson(int fmailyid) {
		return personRepository.getAllPerson(fmailyid);

	}

	@Override
	public void updatePerson(Person person) {
		personRepository.updatePerson(person);
	}

	@Override
	public void updateParent(int childid, int parentid) {
		personRepository.updateParent(childid, parentid);
	}
	
	@Override
	public Person getPersonByID(int personid){
		return personRepository.getPersonByID(personid);
	}
	
	@Override
	public void deletePerson(int personid){
		personRepository.deletePerson(personid);
	}
	
	@Override
	public List<Person> getAllPerson(){
		JiapuUser user = jiapuUserService.getCurrentUser();
		if(user==null)
		{
			return null;
		}
		return personRepository.getAllPerson(user.getFamilyid());
	}

	public List<Person> getAllChildren(int personid)
	{
		return personRepository.getAllChildren(personid);
	}
}

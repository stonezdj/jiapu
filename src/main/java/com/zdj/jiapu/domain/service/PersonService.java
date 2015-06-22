package com.zdj.jiapu.domain.service;

import java.util.List;

import com.zdj.jiapu.domain.model.Person;

public interface PersonService {
	public void addPerson(Person person);
	public List<Person> getAllPerson(int fmailyid);
	public List<Person> getAllPerson();
	public void updatePerson(Person person);
	public void updateParent(int childid, int parentid);
	public Person getPersonByID(int personid);
	public void deletePerson(int personid);
	public List<Person> getAllChildren(int personid);
	
}

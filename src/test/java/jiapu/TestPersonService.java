package jiapu;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zdj.jiapu.domain.model.Person;
import com.zdj.jiapu.domain.service.PersonService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@Transactional
public class TestPersonService {
	
	@Inject
	private PersonService personService;
	
	@Test
	public void testAddPerson() {
		
		Person person = new Person();
		person.setBirth(new Date(System.currentTimeMillis()));
		person.setName("道时");
		person.setDeeds("sdfasfdasdfafa");
		person.setFamilyid(2);
		person.setMisc("no comments");
		Date dateofDeath = new Date(System.currentTimeMillis());
		dateofDeath.setYear(dateofDeath.getYear()+100);
		person.setDeath(dateofDeath);
		person.setOthername("othername");
		person.setSex(1);
		
		personService.addPerson(person);
		
		System.out.println("Done1!");
		
		Person person2 = new Person();
		person2.setBirth(new Date(System.currentTimeMillis()));
		person2.setName("道候");
		person2.setDeeds("sdfasfdasdfafa");
		person2.setFamilyid(2);
		person2.setMisc("no comments");
		Date dateofDeath2 = new Date(System.currentTimeMillis());
		dateofDeath2.setYear(dateofDeath2.getYear()+100);
		person2.setDeath(dateofDeath);
		person2.setOthername("othername");
		person2.setSex(1);
		
		personService.addPerson(person2);
		
		System.out.println("Done2!");

	}
	@Test
	public void testListAllPerson()
	{
		List<Person> listPerson = personService.getAllPerson(2);
		
		for(Person person: listPerson)
		{
			System.out.println(person.toString());
		}
	}
	
	@Test
	public void testGetPersonByID()
	{
		Person person = personService.getPersonByID(5);
		System.out.println(person);
	}
	
	
	@Test
	public void testGetAllChildren()
	{
		List<Person> childList = personService.getAllChildren(6);
		for(Person p: childList)
		{
			System.out.println(p);
		}
	}
	

}

package com.zdj.jiapu.app;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.model.Person;
import com.zdj.jiapu.domain.service.JiapuUserService;
import com.zdj.jiapu.domain.service.PersonService;

@Controller
@RequestMapping(value="person")

public class PeronController {
	
	@Autowired
	private JiapuUserService jiapuUserService;
	
	@Autowired
	private PersonService personService;
	
	@ModelAttribute
	public Person addPerson()
	{
		return new Person();
	}
	
	
	@RequestMapping(value="show/{personid}")
	public String register(@PathVariable int personid,  Model model)
	{

		Person person = personService.getPersonByID(personid);
		if(person.getParentid()!=0)
		{
			Person parent =  personService.getPersonByID(person.getParentid());
			model.addAttribute("parent", parent);
		}
		List<Person> childList = personService.getAllChildren(personid);
		
		model.addAttribute("person", person);
		model.addAttribute("childList", childList);
		return "person/personshow";
	}
	
	@RequestMapping("edit/{personid}")
	public String editPerson(@PathVariable int personid,  Model model)
	{
		

		Person person = personService.getPersonByID(personid);
		model.addAttribute("person", person);
		
		List<Person> parentList = personService.getAllPerson();
		parentList.remove(person);
		
		model.addAttribute("parentList", parentList);

		return "person/personedit";
	}
	@RequestMapping("update")
	public String updatePerson(@Valid Person person, Model model)
	{
		personService.updatePerson(person);
		model.addAttribute("person", person);
		return "person/personshow";
	}
	
	@RequestMapping("listall")
	public String listAllPerson(Model model)
	{
		JiapuUser jiapuUser = jiapuUserService.getCurrentUser();
		if(jiapuUser==null)
		{
			//Please login
			return "redirect:/login";
		}
		List<Person> personList = personService.getAllPerson(jiapuUser.getFamilyid());
		model.addAttribute("personList", personList);
		return "person/personlistall";
	}

	@RequestMapping("personnew")
	public String personNew(Model model)
	{
		List<Person> parentList = personService.getAllPerson();
		model.addAttribute("parentList", parentList);
		return "person/personadd";
	}
	
	@RequestMapping("personadd")
	public String personAdd(@Valid Person person, Model model)
	{
		System.out.println(person.toString());
		personService.addPerson(person);
		return "redirect:/person/listall";
	}
	
	@RequestMapping("delete/{personid}")
	public String deletePerson(@PathVariable int personid, Model model)
	{
		personService.deletePerson(personid);
		return "redirect:/person/listall";		
	}
}

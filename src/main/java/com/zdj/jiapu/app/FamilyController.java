package com.zdj.jiapu.app;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zdj.jiapu.domain.model.Family;
import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.service.FamilyService;
import com.zdj.jiapu.domain.service.JiapuUserService;


@Controller
@RequestMapping(value="family")
public class FamilyController {
	
	
	@Inject
	private FamilyService familyService;
	
	@Inject
	private JiapuUserService jiapuUserService;
	
	@ModelAttribute
	public Family addFamily()
	{
		return new Family();
	}
	
	@RequestMapping(value="create")
	public String createFamily(@Valid Family family,  BindingResult result,
							Model model)
	{
		model.addAttribute("family", family);
		
		if(result.hasErrors())
		{
			return "/family/familyadd";
		}
		
		familyService.addFamily(family);
		return "/family/familyshow";
		
	}
	@RequestMapping(value="add")
	public String createFamily(Model model)
	{
		
		return "/family/familyadd";
		
	}
	@RequestMapping(value="show/{familyid}")
	public String showFamily(@PathVariable int familyid, Model model)
	{
		Family family = familyService.findFamily(familyid);
		model.addAttribute("family", family);
		return "/family/familyshow";
		
	}
	@RequestMapping(value="myfamily")
	public String showMyFamily( Model model)
	{
		JiapuUser user = jiapuUserService.getCurrentUser();
		if(user==null)
		{
			return "user/login";
		}
		Family family = familyService.findFamily(user.getFamilyid());
		model.addAttribute("family", family);
		return "/family/familyshow";
		
	}
	@RequestMapping(value="edit/{familyid}")
	public String editFamily(@PathVariable int familyid, Model model)
	{
		Family family = familyService.findFamily(familyid);
		model.addAttribute("family", family);
		return "/family/familyedit";
		
	}
	@RequestMapping(value="join/{familyid}")
	public String joinFamily(@PathVariable int familyid, Model model)
	{
		JiapuUser user = jiapuUserService.getCurrentUser();
		if(user==null)
		{
			return "redirect:/user/login";
		}
		familyService.joinFamily(familyid, user.getUsername());
		return "/family/familyjoin";
	}
	
	@RequestMapping(value="update")
	public String updateFamily(@Valid Family family,  BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			System.out.println(family.toString());
			return "family/familyedit";
		}
		familyService.updateFamily(family);	
		return "redirect:/family/show/"+family.getFamilyid();
	}
	
	@RequestMapping(value="search")
	public String searchFamily(@RequestParam String word, Model model)
	{
		
		//Display the latest created 5 families
		List<Family> latestFamily = familyService.lastFamilyList();
		model.addAttribute("latestFamily", latestFamily);		
		List<Family> familyList= familyService.searchFamily(word);
		model.addAttribute("familyList", familyList);
		return "/user/searchfamilytojoin";
	}
	
	@RequestMapping(value="searchfamily")
	public String searchFamilyToJoin(Model model)
	{
		
		//Display the latest created 5 families
		List<Family> latestFamily = familyService.lastFamilyList();
		model.addAttribute("latestFamily", latestFamily);		
		return "/family/searchfamilytojoin";
	}
	
	
	@RequestMapping(value="test")
	public ModelAndView writeCookie(HttpServletResponse response)
	{
		response.addCookie(new Cookie("familyid", "5"));
		
		return new ModelAndView("family/test");
	}
	
	
	@RequestMapping(value="read")
	public String readCookie( @CookieValue(value="familyid") Integer familyid, 
			Model model)
	{
		model.addAttribute("familyid", familyid);
		return "family/read";
	}
	

}

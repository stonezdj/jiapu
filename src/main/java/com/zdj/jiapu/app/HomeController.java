package com.zdj.jiapu.app;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.service.JiapuUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Inject
	private JiapuUserService jiapuUserService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping
    public String main( Model model) {
    	return "index";
    }
    
    @RequestMapping("introduction")
    public String introduction(@CookieValue(value="familyid", defaultValue="0") Integer familyid, Model model)
    {
    	JiapuUser user = jiapuUserService.getCurrentUser();
    	if(user==null)
    	{
    		return "redirect:/user/login";
    	}
    	else
    	{
    		List<Integer> familyList = jiapuUserService.getFamilyList(user.getUsername());
    		if(familyList.isEmpty())
    		{
    			return "redirect:/family/search";
    		}
    		else if(!familyList.contains(familyid) || familyid==0 ||!jiapuUserService.canSeeFamily(familyid, jiapuUserService.getCurrentUser()))
    		{
    			model.addAttribute("familyList", familyList);
    			return "selectfamily";
    		}
    		
    	}
       	//more than one families you have
    	if(familyid==0)
    	{
    		//prompt to select current family
    		return "selectfamily";
    	}
    	
    	return "introduction";
    }
    @RequestMapping("beifen")
    public String beifen()
    {
    	return "beifen";
    }
    
    @RequestMapping("login")
    public String login()
    {
    	return "user/login";
    }
    
    @RequestMapping("selectfamily")
    public String selectFamily()
    {
    	//Query user family table to fetch all
    	
    	
    	return "selectfamily";
    }

}

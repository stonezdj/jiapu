package com.zdj.jiapu.app;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.model.PasswordEqualsValidator;
import com.zdj.jiapu.domain.model.UserOperation;
import com.zdj.jiapu.domain.repository.UserOperationRepository;
import com.zdj.jiapu.domain.service.JiapuUserService;
import com.zdj.jiapu.domain.service.JiapuUserServiceImpl;
import com.zdj.jiapu.mail.SendMailTask;


@Controller
@RequestMapping(value="user")
public class UserController {

	@Autowired
	private UserOperationRepository userOperationRepository;
	
	private boolean sendMail = false;
	
	
	
	@ModelAttribute
	public JiapuUser addUser()
	{
		return new JiapuUser();
	}
	
	
	
	@Inject
	private JiapuUserService jiapuUserService;
	
	
	
	@Inject
	private PasswordEqualsValidator passwordEqualsValidator;
	
    @InitBinder("jiapuUser")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(passwordEqualsValidator);
    }

	
	@RequestMapping(value="userregister")
	public String register(Model model)
	{
		return "user/userregister";
	}
	
	@RequestMapping(value="login")
	public String showlogin(Model model)
	{
		return "user/login";
	}
	@RequestMapping(value="spring_security_login")
	public String showloginAgain(Model model)
	{
		model.addAttribute("error", "登录失败，请重试！");
		return "user/login";
	}
	
	
	@RequestMapping(value="loginForm")
	public String loginUser(@RequestParam String username, @RequestParam String password, Model model)
	{
		return "user/login";
	}
	
	
	@RequestMapping(value="useradd")
	public String adduser(@Valid JiapuUser jiapuUser, BindingResult result,  Model model)
	{
		model.addAttribute("user", jiapuUser);
		if(result.hasErrors())
		{
			return "user/userregister";
		}
		
		JiapuUser user2 = jiapuUserService.findUserByUsername(jiapuUser.getUsername());
		
		if(user2!=null)
		{
			result.addError(new FieldError("jiapuUser","username", "系统中已经存在相同的用户名！"));
			return "user/userregister";
		}
		
		jiapuUserService.insertUser(jiapuUser);
		
		if(sendMail)
		{
			jiapuUserService.sendValidationMail(jiapuUser);
		}
 
				
		return "user/usershowafterreg";
	}
	
	@RequestMapping(value="activate")
	public String activateUser(@RequestParam String username, @RequestParam String code)
	{
		UserOperation operation = userOperationRepository.getOperation(username, code);
		if(operation!=null)
		{
			//enable user
			userOperationRepository.deleteUserOperation(operation);
			jiapuUserService.enableUser(username);
			
		}
		return "user/login";
	}
	
	
	@RequestMapping(value="current")
	public String currentUser(Model model)
	{
		JiapuUser user = jiapuUserService.getCurrentUser();
		model.addAttribute("user", user);
		return "user/usershow";
		
	}
	
	@RequestMapping(value="show/{username}")
	public String showUser(@PathVariable String username, Model model)
	{
		JiapuUser user = jiapuUserService.findUserByUsername(username);
		model.addAttribute("user", user);
		return "user/usershow";
		
	}
	
	
	@RequestMapping(value="listall")
	public String listAllUser(Model model)
	{
		List<JiapuUser> userList = jiapuUserService.listJiapuUser();
		model.addAttribute("userList", userList);
		return "user/listall";
		
	}
	
	
}

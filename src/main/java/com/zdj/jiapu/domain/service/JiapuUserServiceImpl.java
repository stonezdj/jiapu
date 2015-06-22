package com.zdj.jiapu.domain.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.zdj.jiapu.domain.model.Family;
import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.model.UserOperation;
import com.zdj.jiapu.domain.repository.JiapuUserRepository;
import com.zdj.jiapu.domain.repository.UserOperationRepository;
import com.zdj.jiapu.mail.SendMailTask;

@Service
public class JiapuUserServiceImpl implements JiapuUserService {
	
	@Inject
	private JiapuUserRepository jiapuUserRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	private Random random = new Random();
	
	
	@Autowired
	private UserOperationRepository userOperationRepository;
	
	@Override
	public void insertUser(JiapuUser user) {
		
		String md5Hash = getMD5Hash(user.getPassword());
		user.setPassword(md5Hash);		
		jiapuUserRepository.insertUser(user);	
		
	}

	public static String getMD5Hash(String str)
	{
		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(md==null)
		{
			return null;
		}
		md.update(str.getBytes());

		byte byteData[] = md.digest();
		//convert the byte to hex format method 1
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	@Override
	public JiapuUser findUserByUsername(String username) {
		return jiapuUserRepository.findUserByUsername(username);
	}

	@Override
	public void enableUser(String username) {
		jiapuUserRepository.enableUser(username);		
	}

	@Override
	public void disableUser(String username) {
		jiapuUserRepository.disableUser(username);		
	}

	@Override
	public List<JiapuUser> listJiapuUser() {
		return jiapuUserRepository.listAllUser();
	}

	@Override
	public void changePassword(String username, String newpassword) {
		jiapuUserRepository.changePassword(username, getMD5Hash(newpassword));		
	}

	@Override
	public void sendValidationMail(JiapuUser jiapuUser) {
	//add an operation in database UserOperation
		
		UserOperation operation = new UserOperation();
		
		double codeDouble = random.nextDouble();
		
		String code = JiapuUserServiceImpl.getMD5Hash(Double.toString(codeDouble));
		
		operation.setCode(code);
		operation.setUsername(jiapuUser.getUsername());
		long currentTime = System.currentTimeMillis();
		operation.setCreateDate(new Date(currentTime));
		operation.setType(1);
		userOperationRepository.insertOperation(operation);
		
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("stonezdj@163.com");
			helper.setTo(jiapuUser.getEmail_address());
			helper.setSubject("注册成功！请点击下面的链接激活用户");
			helper.setText("<html><title>账号激活邮件</title><h1>账号激活，请点击下面的链接激活</h1><body><a href=\"http://localhost:8080/jiapu/user/activate?username="+jiapuUser.getUsername()+"&code="+code+"\">激活</a></body></html>", true);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SendMailTask task = new SendMailTask();
		task.setMessage(message);
		task.setSender(mailSender);
		
//		taskExecutor.execute(task);

		mailSender.send(message);		
		
	}

	@Override
	public JiapuUser getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=null;
		if (principal instanceof UserDetails) {
		username = ((UserDetails)principal).getUsername();
		} else {
		 username = principal.toString();
		}
		
		JiapuUser user = jiapuUserRepository.findUserByUsername(username);
		return user;
	}

	@Override
	public boolean enableUserByCode(String username, String code) {
		
		UserOperation operation = userOperationRepository.getOperation(username, code);
		if(operation==null)
		{
			return false;
		}
		else
		{
			enableUser(username);
		}
		return true;
	}

	@Override
	public void setUserAdminRole(String username) {
		jiapuUserRepository.setUserAdmin(username);
	}
	
	@Override
	public List<Integer> getFamilyList(String username){
		return jiapuUserRepository.getFamilyList(username);
	}
	
	@Override
	public List<Family> getMyFamilies(JiapuUser user){
		return jiapuUserRepository.getMyFamilies(user);
	}
	
	public boolean canSeeFamily(int familyid, JiapuUser user){
		if(user==null)
			return false;
		List<Integer> familyList = jiapuUserRepository.getFamilyList(user.getUsername());
		return familyList.contains(familyid);		
	}
}

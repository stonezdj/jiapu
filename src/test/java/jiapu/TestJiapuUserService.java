package jiapu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zdj.jiapu.domain.model.Family;
import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.service.JiapuUserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional

public class TestJiapuUserService {

	@Autowired
	private JiapuUserService jiapuUserService;
	
	@Test
	
	public void testEnableUser() {
		jiapuUserService.enableUser("fall1234");
		
		JiapuUser user = jiapuUserService.findUserByUsername("fall1234");
		System.out.println(user.toString());
		assertTrue(user.getIsEnabled()==1);
	}
	
	@Test
	public void testDisableUser(){
		jiapuUserService.disableUser("fall");
		JiapuUser user = jiapuUserService.findUserByUsername("fall");
		System.out.println(user.toString());
		
		assertTrue(user.getIsEnabled()==0);
	}
	
	@Test
	
	public void testSetUserAdminRole(){
		jiapuUserService.setUserAdminRole("fall");
		JiapuUser user = jiapuUserService.findUserByUsername("fall");
		System.out.println(user.getUserrole());
		assertEquals("ADMIN_USER", user.getUserrole());
	}
	
	@Test
	public void testListUser()
	{
		List<JiapuUser> userList = jiapuUserService.listJiapuUser();
		for(JiapuUser user: userList)
		{
			System.out.println(user);
		}
	}
	
	@Test
	public void testQueryFamily()
	{
		List<Integer> familyList = jiapuUserService.getFamilyList("stonezdj");
		System.out.println(familyList.toString());
	}
	
	@Test
	public void testQueryFamilyObject()
	{
		JiapuUser user = jiapuUserService.findUserByUsername("stonezdj");
		List<Family> familyList = jiapuUserService.getMyFamilies(user);
		for(Family item: familyList)
		{
			System.out.println(item.toString());
		}
	}
	
	
	@Test
	
	public void testcanViewFamily()
	{
		JiapuUser user = jiapuUserService.findUserByUsername("stonezdj");
		System.out.println(jiapuUserService.canSeeFamily(2, user));
	}
	
}

package jiapu;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zdj.jiapu.domain.model.UserOperation;
import com.zdj.jiapu.domain.repository.UserOperationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestContext {
	
	@Inject 
	private UserOperationRepository userOperationRepository;
	
	
	@Test
	public void testInsertOperation() {
		UserOperation op = new UserOperation();
		op.setUsername("stonezdj");
		op.setCode("AAAAAAAA");
		op.setType(1);
		op.setCreateDate(new Date(System.currentTimeMillis()));
		
		userOperationRepository.insertOperation(op);
		
		System.out.println("Done!");
	}

}

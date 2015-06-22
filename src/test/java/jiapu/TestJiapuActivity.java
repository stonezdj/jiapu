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

import com.zdj.jiapu.domain.model.JiapuActivity;
import com.zdj.jiapu.domain.model.JiapuActivityExample;
import com.zdj.jiapu.domain.repository.JiapuActivityMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional
public class TestJiapuActivity {
	
	@Inject
	private JiapuActivityMapper jiapuActivityRepo;

	@Test
	public void testAddActivity() {
		JiapuActivity activity = new JiapuActivity();
		activity.setMessage("This is a hello world");
		activity.setOwnerid("2");
		activity.setStartdate(new Date(System.currentTimeMillis()));
		activity.setRecorddate(new Date(System.currentTimeMillis()));
		jiapuActivityRepo.insert(activity);
		
		
		JiapuActivityExample example = new JiapuActivityExample();
		example.createCriteria().andOwneridEqualTo("2");
		
		List<JiapuActivity> result = jiapuActivityRepo.selectByExample(example);
		for(JiapuActivity item: result)
		{
			System.out.println(item.toString());
		}
		
		
	}
	
	

	

}

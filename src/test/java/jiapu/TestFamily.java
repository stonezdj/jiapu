package jiapu;

import java.io.FileInputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zdj.jiapu.domain.model.Family;
import com.zdj.jiapu.domain.repository.FamilyRepository;

public class TestFamily {

	@Test
	public void testInsertFamily() throws Exception {
		
		String resource = "src/main/webapp/resources/mybatis/mybatis-config.xml";
		FileInputStream inputStream = new FileInputStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();

		try {
		  FamilyRepository mapper = session.getMapper(FamilyRepository.class);
		  Family family = new Family();
		  family.setProvince("江西省");
		  family.setCounty("万安县");
		  family.setTown("沙坪镇");
		  family.setVillege("沙坪村");
		  family.setSmallvillege("洛富");
		  family.setUsername("stonezdj");
		  family.setFamilyname("茂德堂");
		  mapper.insertFamily(family);
		  System.out.println("Insert done!");
		  session.commit();
		} finally {
		  session.close();
		}
	}
	@Test
	public void testQueryFamily() throws Exception {
		String resource = "src/main/webapp/resources/mybatis/mybatis-config.xml";
		FileInputStream inputStream = new FileInputStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			FamilyRepository mapper = session.getMapper(FamilyRepository.class);
			Family family = mapper.selectFamily(2);
			System.out.println(family.toString());
		} finally {
			session.close();
		}
	}

}

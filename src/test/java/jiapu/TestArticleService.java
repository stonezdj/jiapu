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

import com.zdj.jiapu.domain.model.Article;
import com.zdj.jiapu.domain.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Transactional
public class TestArticleService {
	
	@Inject
	private ArticleService articleService;
	
	@Test
	public void testAddArticle() {
		Article article = new Article();
		article.setFamilyid(2);
		article.setCategory("introduction");
		article.setTitle("张氏记传至洛富始祖源流考");
		article.setContent("<p>	得姓受氏之祖名挥，乃黄帝第五子，造弓赐姓为张，传至周"+
				"仲公五十八世，以孝友见称于世人，传至汉留候良公八十世矣，由良公起一世传至唐九龄公，名子寿号曲江，为唐名宰相，凡二"+
				"十七世，九龄公弟九皋生子九，九章生子九，九宾生子五。九龄公单传至元孙廷杰，公生五子，"+
				"分五大派，长涉宏涧派，次渥宏深派，三沦宏泽派，四沼宏渊派，五洪宏海派，五大派者皆祖" +
				"曲江，洛富为长派宏涧派，第五子载公之后生仁仲，仲生郁，郁生我，城南始祖宋秘书丞遵彧"+
				"公也，公由韶州徙居南康苦竹里，复徙虔之城西，公辞朝回虔，寇警乃占籍邑之城。南宋末元"+
				"初，孙淑荣公诰赠中宪大夫，始立基洛富而成族焉。</p><p>晋堂祖识</p>");
		article.setUsername("stonezdj");
		article.setCreateDate(new Date(System.currentTimeMillis()));
		article.setOrderid(0);
		articleService.addArticle(article);

	}
	@Test
	public void testAddArticle2() {
		Article article = new Article();
		article.setFamilyid(2);
		article.setCategory("beifen");
		article.setTitle("洛富张氏世系派行");
		article.setContent("<p>遵诗礼淑训，贻谷善以子</p><p>伯迪齐华才，汝大天文翰</p><p>宗继尚长远，仁义道德传</p>	<p>南康衍虔西，万安宋立基</p><p>绍述庆光裕，荣显绵洛溪</p><p>世代家声振，贤能冠群英</p>");
		article.setUsername("stonezdj");
		article.setCreateDate(new Date(System.currentTimeMillis()));
		article.setOrderid(0);
		articleService.addArticle(article);
		
	}

	@Test
	public void testQueryArticle(){
		List<Article> list = articleService.queryArticle(2, "introduction");
		System.out.println(list.get(0));
		
	}
	
	@Test
	public void testUpdateCategory(){
		articleService.setArticleCategory(2, "introduction");
	}
	
	@Test 
	public void testUpdateArticle(){
		Article article = articleService.findArticleByID(2);
		System.out.println(article.toString());
	}
}

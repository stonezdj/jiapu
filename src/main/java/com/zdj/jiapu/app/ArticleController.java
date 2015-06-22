package com.zdj.jiapu.app;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdj.jiapu.domain.model.Article;
import com.zdj.jiapu.domain.model.JiapuUser;
import com.zdj.jiapu.domain.service.ArticleService;
import com.zdj.jiapu.domain.service.JiapuUserService;

@Controller
@RequestMapping(value="article")
public class ArticleController {
	
	@Inject
	private ArticleService articleService;
	
	@Inject
	private JiapuUserService jiapuUserService;
	
	@ModelAttribute
	public Article getNewArticle()
	{
		return new Article();
	}
	
	@RequestMapping("introduction")
	public String introduction(Model model)
	{
		JiapuUser user = jiapuUserService.getCurrentUser();
		
		if(user==null)
		{
			Article article = new Article();
			article.setTitle("没有相关文章！");
			article.setContent("");
			model.addAttribute("article", article);
		}
		else
		{
			List<Article> result = articleService.queryArticle(user.getFamilyid(), "introduction");
			
			if(result==null || result.isEmpty())
			{
				Article article = new Article();
				article.setTitle("没有相关文章！");
				article.setContent("");
				model.addAttribute("article", article);
			}
			else
			{
				Article article = result.get(0);
				model.addAttribute("article", article);
			}
		}
		
		return "article/articleshow";
	}
	
	@RequestMapping("beifen")
	public String beifen(Model model)
	{
		JiapuUser user = jiapuUserService.getCurrentUser();
		
		if(user==null)
		{
			Article article = new Article();
			article.setTitle("没有相关文章！");
			article.setContent("");
			model.addAttribute("article", article);
		}
		else
		{
		
			List<Article> result = articleService.queryArticle(user.getFamilyid(), "beifen");
			
			if(result==null || result.isEmpty())
			{
				Article article = new Article();
				article.setTitle("没有相关文章！");
				article.setContent("");
				model.addAttribute("article", article);
			}
			else
			{
				Article article = result.get(0);
				model.addAttribute("article", article);
			}
		}
		return "article/articleshow";
	}
	
	@RequestMapping("edit/{id}")
	public String editArticle(@PathVariable Integer id, Model model)
	{
		
		if(id==0)
		{
			return "redirect:/article/newarticle";
		}
		
		Article article = articleService.findArticleByID(id);
		
		model.addAttribute("article", article);
		
		return "article/articleedit";
		
	}
	
	@RequestMapping("show/{id}")
	public String showArticle(@PathVariable Integer id, Model model)
	{
		

		Article article = articleService.findArticleByID(id);
		
		model.addAttribute("article", article);
		
		return "article/articleshow";
		
	}
	
	@RequestMapping("update")
	public String updateArticle(@Valid Article article, Model model)
	{
		//if have some errors, go back to edit
		
		articleService.updateArticleTitleContent(article);		
		
		Article newarticle = articleService.findArticleByID(article.getId());
		model.addAttribute("article", newarticle);
		
		return "article/articleshow";
	}
	
	@RequestMapping("newintroduction")
	public String newIntroduction(Model model)
	{
		model.addAttribute("type", "introduction");
		return "article/articleadd";
	}
	@RequestMapping("newbefen")
	public String newBeifen(Model model)
	{
		model.addAttribute("type", "beifen");
		return "article/articleadd";
	}
	
	@RequestMapping("newarticle")
	public String newArticle(Model model)
	{
		return "article/articleadd";
	}
	
	@RequestMapping("add")
	public String addArticle(Article article, Model model)
	{
		
		JiapuUser user = jiapuUserService.getCurrentUser();
		
		article.setFamilyid(user.getFamilyid());
		article.setUsername(user.getUsername());
		
		articleService.addArticle(article);
		
		
		if("introduction".equals(article.getCategory()))
		{
			return "redirect:/article/introduction";	
		}else if("beifen".equals(article.getCategory()))
		{
			return "redirect:/article/beifen";
		}
		
		
		return "redirect:article/listall";
	}
	@RequestMapping("listall")
	public String listAllArticle(Model model)
	{
		List<Article> articleList = articleService.findAllArticle();
		
		model.addAttribute("articleList", articleList);
		
		return "article/articlelistall";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id, Model model)
	{
		articleService.deleteArticle(id);
		return "redirect:article/listall";
	}
}

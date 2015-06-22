package com.zdj.jiapu.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zdj.jiapu.domain.model.Article;
import com.zdj.jiapu.domain.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Inject 
	private ArticleRepository articleRepository;
	
	@Override
	public void addArticle(Article article) {
		articleRepository.addArticle(article);
	}

	@Override
	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	@Override
	public void setArticleCategory(int id, String category) {
		articleRepository.setArticleCategory(id, category);
	}

	@Override
	public void updateArticle(Article article) {
		articleRepository.updateArticle(article);
	}
	
	@Override
	public List<Article> queryArticle(int familyid, String category)
	{
		return articleRepository.queryArticle(familyid, category);
	}

	@Override
	public Article findArticleByID(int id)
	{
		return articleRepository.findArticleByID(id);
	}
	@Override
	public void addNews(Article article){
		article.setCategory("news");
		articleRepository.addArticle(article);
	}

	@Override
	public List<Article> latestNews(int familyid) {
		return articleRepository.queryArticle(familyid, "news");
	}
	
	@Override
	public void updateArticleTitleContent(Article article)
	{
		articleRepository.updateArticleTitleContent(article);
	}
	
	@Override
	public List<Article> findAllArticle()
	{
		return articleRepository.findAllArticle();
	}
	
}

package com.zdj.jiapu.domain.service;

import java.util.List;

import com.zdj.jiapu.domain.model.Article;

public interface ArticleService {
	public void addArticle(Article article);
	public void deleteArticle(int id);
	public void setArticleCategory(int id, String category);
	public void updateArticle(Article article);
	public void updateArticleTitleContent(Article article);
	public List<Article> queryArticle(int familyid, String category);
	public Article findArticleByID(int id);
	public void addNews(Article article);
	public List<Article>  latestNews(int familyid);
	public List<Article> findAllArticle();
}

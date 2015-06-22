package com.zdj.jiapu.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zdj.jiapu.domain.model.Article;

public interface ArticleRepository {
	@Insert("insert into article (familyid,title,content,createDate,username,orderid,category) "
			+ "values (#{familyid},#{title}, #{content},#{createDate},#{username},#{orderid},#{category})")
	public void addArticle(Article article);
	
	@Delete("delete from article where id = #{id}")
	public void deleteArticle(int id);
	
	@Update("update article set category = #{1} where id = #{0}" )
	public void setArticleCategory(int id, String category);
	
	@Update("update article set category = #{category}, title=#{title}, content = #{content}, orderid = #{orderid} where id = #{id}" )
	public void updateArticle(Article article);
	
	@Update("update article set title=#{title}, category = #{category}, content = #{content} where id = #{id}" )
	public void updateArticleTitleContent(Article article);
	
	@Select("select * from article where familyid= #{0} and category = #{1} order by id desc")
	public List<Article> queryArticle(int familyid, String category);
	
	@Select("select * from article where id = #{id}")
	public Article findArticleByID(int id);
	
	@Select("select * from article")
	public List<Article> findAllArticle();
	
	
	
	
	
	
}

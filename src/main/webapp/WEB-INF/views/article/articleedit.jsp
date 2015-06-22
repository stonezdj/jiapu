<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
			
<div>
<form:form action="${pageContext.request.contextPath}/article/update" modelAttribute="article">
	<form:hidden path="id"/>
	<p>文章分类：
	<form:select path="category">
			<form:option value="introduction" label="家族简介"></form:option>
			<form:option value="beifen" label="辈分排行"></form:option>
			<form:option value="activity" label="家族活动"></form:option>
	</form:select>
	</p>
	<p>文章标题：<form:input path="title"/> </p>
	<div>
	<form:textarea path="content"  cols="50" rows="60"/>
	</div>
	<input type="submit" value="保存修改">
</form:form>
</div>
			
<%@ include file="../common/foot.jsp"%>
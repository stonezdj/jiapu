<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
			
<div>
	<h1> ${article.title} </h1>
	<div>${article.content} </div>

	<sec:authorize access="isAuthenticated()">
	<p><a href="${pageContext.request.contextPath}/article/edit/${article.id}">编辑</a></p>
	</sec:authorize>

</div>
			
<%@ include file="../common/foot.jsp"%>
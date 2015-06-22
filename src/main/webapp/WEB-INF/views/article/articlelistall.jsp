<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
			
<div>


	<table width="400">
		<tr><th>标题</th><th>查看</th><th>编辑</th> <th>删除</th></tr>
		<c:forEach var="article" items="${articleList}">
       			<tr>
	       			<td>${article.title}</td>
	       			<td><a href="${pageContext.request.contextPath}/article/show/${article.id}">查看</a></td>
	       			<td><a href="${pageContext.request.contextPath}/article/edit/${article.id}">编辑</a></td>
	       			<td><a href="${pageContext.request.contextPath}/article/delete/${article.id}" onclick="return confirm('确认要删除文章${article.title}的信息吗？');">删除</a></td>
       			</tr>
        </c:forEach>
	</table>
	
</div>
			
<%@ include file="../common/foot.jsp"%>
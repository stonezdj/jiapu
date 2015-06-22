<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
			
<div>
	<form:form action="${pageContext.request.contextPath}/article/add" modelAttribute="article">
	<p>
		<form:select path="category">
			<form:option value="introduction" label="家族简介"></form:option>
			<form:option value="beifen" label="辈分排行"></form:option>
			<form:option value="activity" label="家族活动"></form:option>
		</form:select>
		<form:input path="title" size="50"/>
		<form:textarea path="content" rows="50" cols="60"/>
		<input type="submit" value="添加">
	</p>
	
	</form:form>
</div>
			
<%@ include file="../common/foot.jsp"%>
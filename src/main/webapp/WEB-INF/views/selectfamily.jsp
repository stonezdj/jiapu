<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%>

<h1>选择当前的家谱</h1>

<p>
	<form:form action="${pageContext.request.contextPath}/setfamily">
	<form:select path="familyid">
		<form:options items="${familyList}" itemValue="familyid"  itemLabel="familyname" />
	</form:select>
	<input type="submit" value="选择">
	</form:form>
</p>

<%@ include file="common/foot.jsp"%>
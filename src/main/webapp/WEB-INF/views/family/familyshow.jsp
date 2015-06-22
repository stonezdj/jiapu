<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>

	
	<!-- 添加内容 -->
		<h3>家族信息</h3>
		<table>
			<tr><td>家族：</td><td>${family.familyname}</td></tr>
			<tr><td>地址：</td><td>${family.province}${family.county}${family.town}${family.villege}${family.smallvillege}</td></tr>
		</table>	
		<p><a href="${pageContext.request.contextPath}/family/edit/${family.familyid}">编辑</a></p>
		<p><a href="${pageContext.request.contextPath}/person/listall">查看家族成员</a></p>
	

<!-- 添加内容结束 -->
<%@ include file="../common/foot.jsp"%>
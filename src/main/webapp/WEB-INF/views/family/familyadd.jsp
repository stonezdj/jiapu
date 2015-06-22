	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="../common/header.jsp"%>
	<!-- 添加内容 -->
	
		<form:form action="${pageContext.request.contextPath}/family/create" modelAttribute="family">
		<div>
			<h3>创建家谱</h3>
		</div>
		
		<div>
			<h3>家族的地址</h3>
			<table>
			<tr><td>省/直辖市：</td><td><form:input  path="province" /><form:errors path="province"></form:errors></td></tr>
			<tr><td>县/市:</td><td><form:input path="county" /><form:errors path="county"></form:errors></td></tr>
			<tr><td>乡/镇:</td><td><form:input path="town" /><form:errors path="town"></form:errors></td></tr>
			<tr><td>村:</td><td><form:input path="villege" /><form:errors path="villege"></form:errors></td></tr>
			<tr><td>自然村：</td><td><form:input path="smallvillege" /><form:errors path="smallvillege"></form:errors></td></tr>
			</table>
		</div>
		
		<div>
			<h3>堂名：</h3>
			<p><form:input path="familyname" /><form:errors path="familyname" /></p>
		</div>
		
		<input type="submit" value="提交"></input>
		</form:form>
	
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
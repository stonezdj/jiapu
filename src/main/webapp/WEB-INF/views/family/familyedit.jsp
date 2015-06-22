	<%@ include file="../common/header.jsp"%>
	<!-- 添加内容 -->
	
		<form:form action="${pageContext.request.contextPath}/family/update"   modelAttribute="family">
		<div>
			<h3>创建家谱</h3>
		</div>
		
		<div>
			<h3>家族的地址</h3>
			
			<input type="hidden" name="familyid" value="${family.familyid}"/>
			<table>
			<tr><td>省/直辖市：</td><td><form:input path="province"  /><form:errors path="province"/></td></tr>
			<tr><td>县/市:</td><td><form:input path="county"/><form:errors path="county"/></td></tr>
			<tr><td>乡/镇:</td><td><form:input path="town" /><form:errors path="town"/></td></tr>
			<tr><td>村:</td><td><form:input path="villege" /><form:errors path="villege"/></td></tr>
			<tr><td>自然村：</td><td><form:input path="smallvillege"/></td></tr>
			</table>
		</div>
		
		<div>
			<h3>堂名：</h3>
			<p><form:input path="familyname" /><form:errors path="familyname"></form:errors></p>
		</div>
		
		<input type="submit" value="提交"></input>
		</form:form>
	
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
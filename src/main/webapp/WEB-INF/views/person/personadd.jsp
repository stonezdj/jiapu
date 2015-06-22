	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="../common/header.jsp"%>
<!---- 添加内容 -->
		<form:form action="${pageContext.request.contextPath}/person/personadd" modelAttribute="person">
		<div>
			<h3>姓名</h3>
			<p><form:input path="name" size="25" /></p>
			<h3>别名</h3>
			<p><form:input path="othername" size="25"/></p>
		</div>
		
		<div>
			<h3>父亲</h3>
			<form:select path="parentid" >
				<form:option value="0" label="父亲信息未输入"></form:option>
				<form:options items="${parentList}" itemValue="personid" itemLabel="name"/>
			</form:select>
		</div>
		
		<div>
			<h3>诞生</h3>
			<p><input type="date" name="birth"  size="25" value="2000-01-01"/></p>
			<h3>配偶</h3>
			<p><form:textarea path="marriage" rows="5" cols="30"></form:textarea></p>
		</div>


		<div>
			<h3>寿德及功业</h3>
			<p><form:textarea path="deeds" rows="5" cols="30"></form:textarea></p>
		</div>
		
		<div>
			<h3>故亡</h3>
			<p><input type="date" name="death" value="9999-12-31" /></p>
			<h3>墓址</h3>
			<p><form:textarea path="tomblocation" rows="5" cols="30"></form:textarea></p>
		</div>
		<div>
			<h3>注释</h3>
			<p><form:textarea path="misc" rows="5" cols="30"></form:textarea></p>
		</div>	
		
		<input type="submit" value="确认添加"></input>
	</form:form>
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
	<%@ include file="../common/header.jsp"%>
		
<!----添加内容--->
	  
	<table width="300">
		<tr><th>姓名</th><th>别号</th><th>出生年月</th><th>查看详细信息</th><th>编辑</th> <th>删除</th></tr>
		<c:forEach var="person" items="${personList}">
       			<tr>
	       			<td>${person.name}</td>
	       			<td>${person.othername}</td>
	       			<td>${person.birth}</td>
	       			<td><a href="${pageContext.request.contextPath}/person/show/${person.personid}">查看</a></td>
	       			<td><a href="${pageContext.request.contextPath}/person/edit/${person.personid}">编辑</a></td>
	       			<td><a href="${pageContext.request.contextPath}/person/delete/${person.personid}" onclick="return confirm('确认要删除${person.name }的信息吗？');">删除</a></td>
       			</tr>
        </c:forEach>
	</table>
	
	<p><a href="${pageContext.request.contextPath}/person/personnew">添加新成员</a></p>
<!----添加内容结束--->
	<%@ include file="../common/foot.jsp"%>
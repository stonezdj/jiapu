	<%@ include file="../common/header.jsp"%>
		
<!----添加内容--->
	  
	<table width="400">
		<tr><th>名称</th><th>email</th><th>手机号</th><th>查看详细信息</th><th>编辑</th> <th>删除</th></tr>
		<c:forEach var="user" items="${userList}">
       			<tr>
	       			<td>${user.username}</td>
	       			<td>${user.email_address}</td>
	       			<td>${user.mobile_phone}</td>
	       			<td><a href="${pageContext.request.contextPath}/user/show/${user.username}">查看</a></td>
	       			<td><a href="${pageContext.request.contextPath}/user/delete/${user.username}" onclick="return confirm('确认要删除${user.username }的信息吗？');">删除</a></td>
       			</tr>
        </c:forEach>
	</table>
	
	<p><a href="${pageContext.request.contextPath}/person/personnew">添加新成员</a></p>
<!----添加内容结束--->
	<%@ include file="../common/foot.jsp"%>
	<%@ include file="../common/header.jsp"%>

	<!-- 添加内容 -->
	
		<h3>最近创建的家族</h3>
		
		<c:if test="${empty latestFamily}">
		<p>	最近没有创建家谱。</p>
		</c:if>
		
		
		<ul>
		<c:forEach var="latest" items="${latestFamily}">
			<li>${latest.familyname} ---
			 <sec:authorize access="isAuthenticated()">
			 	<a href="${pageContext.request.contextPath}/family/join/${latest.familyid}">申请加入</a>
			 </sec:authorize>
			 <sec:authorize access="isAnonymous()">
			 	<a href="${pageContext.request.contextPath}/user/login">注册登录后才能加入</a>
			 </sec:authorize>
			</li>
		</c:forEach>
		</ul>
		
		<p><a href="${pageContext.request.contextPath}/family/add">我要创建新的家谱</a></p>
		
		<div>
		<form action="${pageContext.request.contextPath}/family/search">
			<h3>根据关键字搜索家族：</h3>
			<p><input type="text" name="word" /></p>
			<input type="submit" value="查找"></input>
		</form>
		</div>
	
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
	
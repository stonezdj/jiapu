	<%@ include file="../common/header.jsp"%>

	<!-- 添加内容 -->
	
		<h3>注册用户成功，请你查找并选择你的家谱提交加入申请</h3>
		
		
		<div>
		<form action="family/search">
			<h3>根据关键字搜索家族：</h3>
			<p><input type="text" name="search" /></p>
			<input type="submit" value="查找"></input>
		</form>
		</div>

		<div>
		<h3>搜索结果</h3>
		<ul>
		<c:forEach var="family" items="${familyList}">
       			<li>${family.familyname} <a  href="${pageContext.request.contextPath}/family/join/${family.familyid}">申请加入</a></li>
        </c:forEach>
		</ul>

		</div>
	
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
	
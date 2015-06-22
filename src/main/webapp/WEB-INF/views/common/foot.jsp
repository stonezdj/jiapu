<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		</div>

		<div class="sidenav">

			<h1>分类信息</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath}/index.html">长寿排行</a></li>
				<li><a href="${pageContext.request.contextPath}/index.html">先人墓葬</a></li>
				<li><a href="${pageContext.request.contextPath}/index.html">联系成员</a></li>
				<li><a href="${pageContext.request.contextPath}/index.html">最新成员</a></li>
			</ul>
			
			<sec:authorize access="isAuthenticated()">
			<h1>管理功能</h1>
			<ul>
			    <li><a href="${pageContext.request.contextPath}/family/myfamily">家族信息</a></li>
				<li><a href="${pageContext.request.contextPath}/user/current">我的信息</a></li>
				<li><a href="${pageContext.request.contextPath}/user/listall">成员维护</a></li>
				<li><a href="${pageContext.request.contextPath}/messagetoadmin.html">给管理员留言</a></li>
				<li><a href="${pageContext.request.contextPath}/activity.html">管理事件</a></li>
				<li><a href="${pageContext.request.contextPath}/messageshow.html">查看留言</a></li>
				<li><a href="${pageContext.request.contextPath}/index.html">数据导出</a></li>
			</ul>
			</sec:authorize>
				
		</div>

		<div class="clearer"><span></span></div>

	</div>

	<div class="footer">&copy; 2015 <a href="index.html">jiapu.com</a> Design by <a href="mailto:stonezdj@163.com">Daojun</a>
	</div>

</div>

</body>

</html>
	<%@ include file="../common/header.jsp"%>

	<!-- 添加内容 -->
	
		<form:form action="${pageContext.request.contextPath}/user/useradd" modelAttribute="jiapuUser">
		<div>
			<h3>用户注册</h3>
		</div>
		
		<div>
			<h3>你的网络名字:</h3>
			<p><form:input path="username" /><form:errors path="username"></form:errors></p>
		</div>
		
		<div>
			<h3>密码：</h3>
			<p><form:password  path="password" /><form:errors path="password"></form:errors></p>
		</div>
		<div>
			<h3>再输入一次密码：</h3>
			<p><form:password path="repeatpwd" /><form:errors path="repeatpwd"></form:errors></p>
		</div>
		
		<div>
			<h3>你的真实名字：</h3>
			<p><form:input path="realname" /><form:errors path="realname"></form:errors></p>
		</div>
		
		<div>
			<h3>你的联系方式(手机号)</h3>
			<p><form:input path="mobile_phone" /><form:errors path="mobile_phone"></form:errors></p>
		</div>		
		<div>
			<h3>你的Email地址</h3>
			<p><form:input path="email_address" /><form:errors path="email_address"></form:errors></p>
		</div>		
		
		<input type="submit" value="发送"></input>
		</form:form>
	
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
	
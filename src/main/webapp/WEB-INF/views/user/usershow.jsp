	<%@ include file="../common/header.jsp"%>

	<!-- 添加内容 -->
	
		
		<div>
			<h3>用户注册</h3>
		</div>
		
		<div>
			<h3>网名:</h3>
			<p>${user.username} </p>
		</div>
		

		<div>
			<h3>真名：</h3>
			<p>${user.realname}</p>
		</div>
		
		<div>
			<h3>联系方式(手机号)</h3>
			<p>${user.mobile_phone}</p>
		</div>		
		<div>
			<h3>Email地址</h3>
			<p>${user.email_address}</p>
		</div>		
	
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
	
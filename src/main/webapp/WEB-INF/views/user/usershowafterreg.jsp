	<%@ include file="../common/header.jsp"%>

	<!-- 添加内容 -->
	
		
		<div>
			<h3>用户注册</h3>
		</div>
		
		<div>
			<h3>你的网络名字:</h3>
			<p>${user.username} </p>
		</div>
		

		<div>
			<h3>你的真实名字：</h3>
			<p>${user.realname}</p>
		</div>
		
		<div>
			<h3>你的联系方式(手机号)</h3>
			<p>${user.mobile_phone}</p>
		</div>		
		<div>
			<h3>你的Email地址</h3>
			<p>${user.email_address}</p>
		</div>		
		
		<h3>注册用户成功，请你查找并选择你的家谱提交加入申请</h3>
		
		
		<div>
		<form action="${pageContext.request.contextPath}/family/search">
			<h3>根据关键字搜索家族：</h3>
			<p><input type="text" name="word" /></p>
			<input type="submit" value="查找"></input>
		</form>
		</div>

		<div>
		<h3>搜索结果</h3>
		<p>一共找到3个结果</p>
		<ul>
			<li>洛富茂德堂  <a href="applymemberresult.html">申请加入</a></li>
			<li>北京同仁堂 <a href="applymemberresult.html">申请加入</a></li>
			<li>洛富管礼堂 <a href="applymemberresult.html">申请加入</a></li>
		</ul>
		</div>
	
	<!-- 添加内容结束 -->
	<%@ include file="../common/foot.jsp"%>
	
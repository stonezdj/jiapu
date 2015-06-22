<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%>

<h1>网络家谱简介</h1>
<p>网络家谱将传统的纸质家谱放在网络上,具有以下优点：</p>
<ul>
	<li>方便成员信息的维护和查看，只有注册用户在管理员授权后才能查看本家族的信息，保护用户隐私。</li>
	<li>用户能将家谱保存在网上，又能将家谱导出为pdf文件打印成册.</li>
	<li>更加生动的媒体信息使得家谱更加生动</li>
</ul>
</p>
<sec:authorize access="isAnonymous()">
	<a href="${pageContext.request.contextPath}/login">登录</a>
	<a href="${pageContext.request.contextPath}/user/userregister">注册新用户</a>
</sec:authorize>


<%@ include file="common/foot.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<meta name="description" content="description"/>
<meta name="keywords" content="keywords"/> 
<meta name="author" content="author"/> 
<link rel="StyleSheet"
    href="${pageContext.request.contextPath}/resources/css/default.css"
    type="text/css" media="screen" />
<title>网络家谱</title>
</head>

<body>

<div class="container">

	<div class="header">
				
		<div class="title">
			<h1>网络家谱</h1>
		</div>

	</div>

	<div class="navigation">
			<a href="${pageContext.request.contextPath}/family/searchfamily">查找家谱</a>
			<sec:authorize access="isAuthenticated()">
			<a href="${pageContext.request.contextPath}/article/introduction">家族概况</a>
			<a href="${pageContext.request.contextPath}/article/beifen">辈分排行</a>
			<a href="${pageContext.request.contextPath}/person/listall">家族成员</a>
			<a href="${pageContext.request.contextPath}/article/listall">最新消息</a>
			</sec:authorize>		
			<sec:authorize access="isAnonymous()">
			<a href="${pageContext.request.contextPath}/login">登录</a>
			</sec:authorize>			
			<sec:authorize access="isAuthenticated()">
			<a href="${pageContext.request.contextPath}/logoff">退出登录</a>
			</sec:authorize>			
			<div class="clearer"><span></span></div>
		</div>

	<div class="main">		
		
		<div class="content">

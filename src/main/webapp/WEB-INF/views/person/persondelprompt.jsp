	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="../common/header.jsp"%>
		
<!----添加内容--->
	  
		<div>
		    <h1>你确认要删除以下人员信息！</h1>
		    <form action="${pageContext.request.contextPath}/person/delete/${person.personid}">
		    	<input type="submit" value="删除">
		    	<button onclick="forward('${pageContext.request.contextPath}/person/listall')" value="取消"></button>
		    </form>
			<h3>${person.name}</h3>
			<p>别名${person.othername}</p>
		</div>
		<div>
			<h3>诞生</h3>
			<p>生于${person.birth}</p>
		</div>
		<div>
			<h3>配偶</h3>
			<p>${person.marriage}</p>
		</div>		
		<div>
			<h3>子女</h3>
			<ul>
				<li><a href="person?personid=123">张长弓</a></li>
				<li><a href="person?personid=124">张未来</a></li>
				<li><a href="person?personid=125">张杨</a></li>
			</ul>
		</div>

		<div>
			<h3>寿德及功业</h3>
			<p>${person.deeds}</p>
		</div>
		
		<div>
			<h3>故亡</h3>
			<p>亡故于${person.death}</p>
			<h3>墓址</h3>
			<p>亡故于${person.tomblocation}</p>
		</div>
		<div>
			<h3>注释</h3>
			<p>${person.misc} </p>
		</div>	
		<a href="${pageContext.request.contextPath}/person/edit/${person.personid}">修改信息</a>
		<a href="${pageContext.request.contextPath}/person/listall">显示所有成员信息</a>
		
<!----添加内容结束--->
	<%@ include file="../common/foot.jsp"%>
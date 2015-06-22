	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="../common/header.jsp"%>
		
<!----添加内容--->
	  
		<div>
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
			<h3>父亲</h3>
			<p>${parent.name}</p>
		</div>		
		<div>
			<h3>子女</h3>
			<ul>
			<c:forEach var="child" items="${childList}">
				<li><a href="${pageContext.request.contextPath}/person/show/${child.personid}">${child.name}</a></li>
				</c:forEach>
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
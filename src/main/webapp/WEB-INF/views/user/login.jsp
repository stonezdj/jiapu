<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>

<div>

    <form action='${pageContext.request.contextPath}/j_spring_security_check'
        method="POST">

        <p>请输入用户名与密码</p>
        
        <table>
           <tr>	<td>用户名:</td> <td><input type='text' name='j_username' value='stonezdj'></tr>
           <tr>	<td> 密码: </td> <td> <input type='password' name='j_password'
                value="zhu88jie" /></td>
                </tr>
           <tr><td><input type='checkbox' name='_spring_security_remember_me'/></td><td>在这台机器上保存我的登录信息.</td></tr>
        </table>
        <input name="submit" type="submit" value="登录" />
        <p>目前没有注册账号，<a href="${pageContext.request.contextPath}/user/userregister">注册账号</a></p>
    </form>

</div>
<%@ include file="../common/foot.jsp"%>
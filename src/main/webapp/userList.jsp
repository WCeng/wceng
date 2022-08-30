<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <table align="center" border="1" cellspacing="0">
    	<tr>
    		<td>id</td>
    		<td>用户名</td>
    		<td>密码</td>
    	</tr>
    	<c:forEach items="${users}" var="user" varStatus="st">
    		<tr>
    			<td>${user.getId()}</td>
    			<td>${user.getName()}</td>
    			<td>${user.getPassword()}</td>
    		</tr>
    	</c:forEach>
    </table>
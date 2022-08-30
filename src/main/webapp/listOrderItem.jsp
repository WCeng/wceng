<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<table align="center" border="1" cellspacing="0">
	<tr>
		<td>商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>删除</td>
	</tr>
	
	<c:forEach items="${ois}" var="oi" varStatus="st">
		<tr>
			<td>${oi.getProduct().getName()}</td>
			<td>${oi.getProduct().getPrice()}</td>
			<td>${oi.getNum()}</td>
			<td style="color: #c40000; font-weight: bold;">￥ ${oi.getNum()*oi.getProduct().getPrice()}</td>
			<td><a href='deleteOrderItem?pid=${pid=oi.getProduct().getId()}'>删除</a></td>
		</tr>
	</c:forEach>
	
	<c:if test="${!empty ois}">
		<tr>
			<td colspan="5" align="center">
				<a href="createOrder">生成订单</a>
			</td>
		</tr>
	</c:if>
	
</table>
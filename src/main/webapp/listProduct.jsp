<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!empty user.getName()}">
	<div align="center" >当前用户： ${user.getName()}</div>
</c:if>

<script src="/js/jquery.min.js"></script>

<script>
	$(function () {
		$("span.addCart").hide();
		$("input.addCartButton").click(function () {
			$(this).attr("disabled", "disabled");
			var button = $(this);
			var pid = $(this).attr("pid");
			var num = $("input.productNum[pid="+pid+"]").val();
			var url = "listOrderItem";
			$.get(
				url,
				{"pid":pid, "num":num},
				function (result) {
					$("span.addCart").fadeIn(1000);
					$("span.addCart").fadeOut(1000, function () {
						button.removeAttr("disabled");
					})
				}
			)
		})
	})
</script>

<div align="center" style="color:lightgreen; height: 50px; line-height: 50px;" >
	<span class="addCart">加入购物车成功</span>
</div>

<table align="center" border="1" cellspacing="0">
	<tr>
		<td>id</td>
		<td>产品名称</td>
		<td>价格</td>
		<td>购买</td>
	</tr>
	
	<c:forEach items="${products}" var="product" varStatus="st">
		<tr>
			<td>${product.getId()}</td>
			<td>${product.getName()}</td>
			<td>${product.getPrice()}</td>
			<td>
				数量<input class="productNum" type="text" value="1" pid="${product.getId()}">
				<input class="addCartButton" type="submit" value="加入购物车" pid="${product.getId()}">
			</td>
		</tr>
	</c:forEach>	
	
	<tr>
		<td align="center" colspan="4"><a href="listOrderItem.jsp">查看订单</a></td>
	</tr>
</table>
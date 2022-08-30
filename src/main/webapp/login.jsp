<%@ page language="java" contentType="text/html; utf-8"
pageEncoding="utf-8"%>

<script src="/js/jquery.min.js"></script>

<script type="text/javascript">
	$(function () {
		$(".logonButton").click(function () {
			var name = $(".name").val();
			var password = $(".password").val();
			var url = "logon";
			
			$.get(
				url,
				{"name":name, "password":password},
				function (result) {
					alert(result);
				}
			)
			
		});
		
		$(".quicklySubmit").click(function () {
			$(".name").val("wc");
			$(".password").val("123");
		})
	})
</script>

<form action="/login" method="post">
	账号： <input class="name" type="text" name="name">
	<button type="submit" class="quicklySubmit">一键登录</button>
	<br>
	密码： <input class="password" type="text" name="password"><br><br>
	<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="logonButton" type="button" value="注册">
	<a href="showAllUser">查看所有用户</a>
</form>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#demo").click(function() {
			$.ajax({
				url : "findUser.do",
				data : {
					username : $("#username").val(),
					password : $("#password").val()
				},
				/* defeat密码错误， teacher student登录成功 exist用户已登录 */
				success : function(data) {
					if (data == "defeat") {
						alert("密码错误");
						window.location.href = "error.html"
					} else if(data == "teacher") {
						alert("teacher登录成功")
						window.location.href = "main.html";
					} else if(data == "student") {
						alert("student登录成功")
						window.location.href = "main.html";
					}else if(data == "exist"){
						alert("用户已登录")
					}
				},
				error : function() {
					alert("error");
				}
			})

		})
	})
</script>
</head>
<body>
	<input type="text" name="username" id="username">
	<input type="text" name="password" id="password">
	<input type="submit" id="demo" value="登录">

</body>
</html>
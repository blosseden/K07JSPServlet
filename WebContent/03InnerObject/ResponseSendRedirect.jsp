<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
</head>
<body>
<%
//폼값 받기
String id = request.getParameter("user_id");
String pwd = request.getParameter("user_pwd");

if(id.equalsIgnoreCase("kosmo") && pwd.equalsIgnoreCase("1234")){
	
	response.sendRedirect("../common/Welcome.jsp");
	
}
else{
%>
	<script>
		alert("일치하지 않아");
		history.go(-1);
	</script>
<%
//response.sendRedirect("./ResponseMain.jsp");
}
%>
</body>
</html>
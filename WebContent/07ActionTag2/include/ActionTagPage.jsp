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
	String actionString ="액션테그 페이지에서 생성한 멋쟁이 변수";

%>
<h2 style="color:blue;">"액션테그 페이지랑께"</h2>
	<ul>
		<li>페이지영역 :
			<%=pageContext.getAttribute("pageVar") %></li>
		<li>리퀘스트 영역 :
			<%=request.getAttribute("requestVar") %></li>
	</ul>
</body>
</html>
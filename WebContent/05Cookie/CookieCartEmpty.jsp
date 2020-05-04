<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
</head>
<body>
	<h2>쿠키삭제띠</h2>
	<%
	/*
	쿠키 삭제시 쿠키으 값을 빈값으로 , 유효기간을 0으로 설정한다
	※쿠키 삭제시 주의사항
	JSP는 session설정시 JSESSIONID라는 쿠키명으로 세션을 저장하게 된다.
	따라서 생성된 쿠키를 모두 삭제하면 세션영역에 저장된 속성값도 사라지게 되어
	로그아웃이 되는 일이 발생된다. 따라서 쿠키를 삭제할 때는 쿠키명을 통해
	선별적으로 삭제하거나, JSESSIONID를 제외한 나머지만 삭제해야한다
	
	*/
	Cookie[] cookies = request.getCookies();
	if(cookies!=null)
	{
			for(Cookie ck : cookies)
			{
				out.println(ck.getName() +" : "+ck.getValue() +"<br/>");
				
				if(! (ck.getName().equals("JSESSIONID")) ){
					//쿠키값을 빈값으로 설정한다
					Cookie cookie = new Cookie(ck.getName(), "");
					cookie.setPath(request.getContextPath());
					//쿠키의 유효시간을 0으로 설정한다.
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
	}
	%>
	<script>
		alert("장바구니를 비웠쪙");
		location.href="CookieCartMain.jsp";
	</script>
</body>
</html>
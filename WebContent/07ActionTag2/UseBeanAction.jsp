<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UseBeanAction</title>
</head>
<body>
<h2>useBean 액션태그</h2>

<h3>useBean 액션태그로 ㅈㅂ은 의미의 자바빈 객체 생성하기</h3>

<jsp:useBean id="member" class="model.MemberDTO" scope="request"/>

<%-- 
//위 액션 태그를 JSP코드로 표현하면 아래와 같다.
//11.request영역에 저장된 객체를 가져온다.
MemberDTO memberDTO = (MemberDTO)request.getAttribute("member");
if(memberDTO==null) {
	//2. 만약 객체가 null값이면 객체를 생성한다
	memberDTO = new MemberDTO();
	//3. 생성한 객체를 request영역에 저장한다.
	request.setAttribute("member", memberDTO);
}
//액션태그를 사용하면 JSP코드 보다 간결하게 표현 할 수 있다.
 --%>
 
<%--
빈의 getter()메소드를 통해 값을 가져온다.
 --%>
 <h3>getProrperty 액션태그로 자바빈 객체 속성 읽기</h3>
 <ul>
 	<li>아이디 :
 	<jsp:getProperty property="id" name="member"/> </li>
 	<li>패스워드:
 	<jsp:getProperty property="pass" name="member"/> </li>
 	<li>이름 :
 	<jsp:getProperty property="name" name="member"/> </li>
 </ul>
 
 <jsp:forward page="UseBeanActionForward.jsp"></jsp:forward>
</body>
</html>
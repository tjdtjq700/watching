<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
<head>
	<title>로그인</title>
</head>
<body>

	<c:if test="${member == null}">
	<form role="form" method="post" autocomplete="off" action="/member/login">
	<p>
		<label for="mid">아이디</label>
		<input type="text" id="mid" name="mid" />
	</p>
	<p>
		<label for="mpw">비번</label>
		<input type="password" id="mpw" name="mpw" />
	</p>
	<p><button type="submit">로그인</button>
	<p><a href="/member/insertMember">회원가입</a>	
	</form>

	<p>${member.mname}님 환영합니다.</p>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>

<%@include file="../template/top.jsp"%>

	<h1 align="center">회원정보</h1>
	
	<table align="center" border="1">
	
		<tr>
			<td>이름</td>
			<td>${mdto.mName}</td>
		</tr>
	
		<tr>
			<td>아이디</td>
			<td>${mdto.mId}</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td>${mdto.mPw}</td>
		</tr>
		
		<tr>
			<td>멤버십</td>
			<td>${mdto.msCode}</td>
		</tr>
		
		<tr>
			<td>멤버십 시작일</td>
			<td>${mdto.mMemsDate}</td>
		</tr>
		
		
	</table>

<%@include file="../template/bottom.jsp"%>

</body>
</html>
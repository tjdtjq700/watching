<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.finalPj.testpj.dto.ProductDTO" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>

<style>
	ul li{
		list-style:none;
		float:left;
		text-align:center;
	}
</style>
</head>
<body>
 <div class="list">
 	<ul class="topbar">
 		<li>pCode</li>
 		<li>제목</li>
 		<li>게시자</li>
 	</ul>
 	<c:forEach items="${dtos}" var="dtos">
	 	<ul class="list">
	 		<li>${dtos.pCode}</li>
	 		<li>${dtos.pName}</li>
	 		<li>${dtos.aId}</li>
	 	</ul>
	 </c:forEach>
 </div>
</body>
</html>
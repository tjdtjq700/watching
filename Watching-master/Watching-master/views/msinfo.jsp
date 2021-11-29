<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버십 안내</title>
<style>
body {
  background-color:black;
  color: white;
  font-family: Arial, Helvetica, sans-serif;
  margin:0px;
}

.navbar {
  overflow: hidden;
  padding:20px;
  background-color: black;
}

a, a:link, a:visited {
  color: white;
  text-decoration: none;
  algin: center;
}

.menu {
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
  float: left;
  font-size: 20px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.logo {
  margin:10px 10px;
  float: left;
  font-size: 20px;
  color: white;
  text-align: center;
  padding: 0px;
  text-decoration: none;
}

.menu:hover {
  background-color: red;
}

.rightmenu {
  float:right;
}
#bottom {
  width:100%;
  height:100px;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: lighter;
  bottom:0;
  background:black;
  text-align: center;
  color: white;
}


table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 1000px;
  margin: auto;
  background-color: white;
}

td, th {
  height: 50px;
  border: 2px solid black;
  text-align: center;
  padding: 8px;
  color: black;
}

#head {
  background-color: red;
  color: white;
}

</style>
</head>
<body>

	<div class="navbar">
	 	<a  class="logo" href="/" ><img src="<spring:url value ='/resources/Logo/logo_red.JPG'/>" width="150px" height="50"></a>
	  			  
		<div class="rightmenu">		 
		   <a class="menu" href="/member/joinPage">멤버십 시작하기</a>
		</div>
	
	</div>
	
	<h1 align="center">Watching 멤버십 가격표</h1>	<br/>
	
	<table style="background-color: white;">
	<tr>
		<th>&nbsp;</th>
		<th id="head">Bronze</th>
		<th id="head">Silver</th>
		<th id="head">Gold</th>
	<tr>
		<td width="100px">요금</td>
		<td>8,000원</td>
		<td>10,000원</td>
		<td>12,000원</td>
	<tr>
		<td width="100px">HD</td>
		<td>X</td>
		<td>O</td>
		<td>O</td>
	<tr>
		<td width="100px">UHD</td>
		<td>X</td>
		<td>X</td>
		<td>O</td>
	<tr>
		<td width="100px">동시접속</td>
		<td>1명</td>
		<td>2명</td>
		<td>4명</td>
	<tr>
		<td width="100px">무제한시청</td>
		<td>O</td>
		<td>O</td>
		<td>O</td>
	</table>
	
	
	<p/>
	
<%@include file="./template/bottom.jsp"%>

</body>
</html>
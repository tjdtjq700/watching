<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
</head>
<body>

	<div class="navbar">
	 	<a  class="logo" href="/" ><img src="<spring:url value ='C:\Users\pc362\spring-workspace\Test2_Watching\src\main\webapp\resources\Logo\logo_red.JPG'/>" width="150px" height="50"></a>
	</div>

	<h1 align="center">Watching 멤버십 가격표</h1>
	
	<table border="2px" width="50%" height="200px" cellspacing="5" color="red">
	<thead>
		<tr align="center">
			<th>BRONZE</th>
			<th>SILVER</th>
			<th>GOLD</th>
		</tr>
	</thead>
	
	<tbody>
	<tr align="center">
			<th>8000원</th>
			<th>10000원</th>
			<th>12000원</th>
		</tr>
	</tbody>
	</table>


</body>
</html>
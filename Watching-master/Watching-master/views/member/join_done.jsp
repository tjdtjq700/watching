<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입을 환영합니다</title>
<style>
.btn_area {
  margin: 130px;
}

#btnPayment {
  position: absolute;    
  width: 200px;
  padding: 21px 0 17px;
  border: 0;
  cursor: pointer;
  color: #fff;
  background-color: #F60101;
  font-size: 20px;
  font-weight: 400;
  font-family: Arial, Helvetica, sans-serif;
}
#content {
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    width: 500px;
    height: auto;
}
</style>
</head>
<body>

<%@include file="../template/top_before.jsp"%> 
	
	<div id="content">
	<h1 align="center">Watching 회원가입을 환영합니다!</h1>
	
		<div class="btn_area">
			<button type="submit" id="btnPayment" onclick="location.href='/'">로그인하러 가기</button>
		</div>
	</div>
	
</body>
</html>
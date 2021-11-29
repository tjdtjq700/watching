<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.watching.dto.MemberDTO" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Watching 멤버십 결제</title>
<style>
.btn_area {
  margin: 10px;
}

#btnDone {
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
    width: 460px;
    height: auto;
}
</style>
</head>
<body>

<%@include file="../template/top_before.jsp"%> 

	<h1 align="center">멤버십 결제</h1>

	
	<div id="content">
	<h3>결제수단</h3>
		<input type="radio" id="credit" name="pWay" value="credit">신용카드
		<input type="radio" id="phonepay" name="pWay" value="phonepay">휴대폰 결제
		
		<p/>
		
		<div class="btn_area">
			<button id="btnDone" onclick="location.href='/member/join_done'">결제 완료</button>
		</div>
	</div>
	
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
<style>
.searchform {
  display:flex;
  justify-content:center;
  align:center;
}
a, a:link, a:visited {
  color: white;
  text-decoration: none;
  algin: center;
}
</style>
</head>
<body>

<%@include file="top.jsp"%>

	<h1 align="center">보고싶은 작품을 검색해주세요</h1>

	<form action=/listsearch>
	 <div class="searchform">
	 	<input type="text" name="listkeyword" id="listkeyword" style="text-align:center; width:500px; height:50px;"/>&nbsp;&nbsp;&nbsp;
	 	<c:url var="targetURL" value="/listsearch"></c:url>
	 	<button name="search_btn" id="search_btn">검색</button>
	 </div>
	</form>
	<br/>
	
	<ul>
		<c:forEach items="${search}" var="search">
		<li>
			<div class="pImg"><a href=""><img src="/resources/ProductImg/${search.pImg}" style="width:250px; height:250px;"></a></div>
			<div class="pName"><a href="">${search.pName}</a></div>

		</li>
		</c:forEach>
	</ul>				
	
	<script>
		document.getElementById("search_btn").onclick = function () {
		  let listkeyword =  document.getElementsByName("listkeyword")[0].value;
		  console.log(listkeyword)
		 };
	</script>


	
<%@include file="bottom.jsp"%>

</body>
</html>
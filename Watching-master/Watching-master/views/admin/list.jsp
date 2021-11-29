<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.watching.dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 모드</title>
<style>
body {
  background-color:black;
  line-height:2em;
  color:#fff;
  margin:30px;
}
.list {		
  display:table;
  width:900px;
  margin:auto;
  position: relative;
}
.boardDiv {
  width:100%;
}
.board {
  display:table-row;
  position:relative;
  padding: 0 auto;
}
.b_menu {
  display:table-cell;
  border-bottom:2px solid silver;
  font-size:14pt;
  font-weight:bold;
  vertical-align:baseline;
  color: #fff;	
  text-align:center;
}
.line {
  display:table-cell;
  font-size:12pt;
  border-bottom:1px solid silver;
  vertical-align:baseline;
  color: #fff;
  text-align:center;
}
.paging{
  clear:both;
  position:relative;
}
	<!--버튼 -->
.line_footer{
  display: table-caption;
  caption-side: bottom;
  text-align:center;
}
.d_btn{
  border:0;
  height:25px;
  background-color:#DC143C;
  border-radius:1px;
  font-weight:bold;
}
<!--검색 -->
.search{
  margin:auto;
  clear:both;
  vertical-align:middle;
}
.search_input{
  width:300px;
  height:25px;
  border:0;		
}
.search_btn{
  width:40px;
  height:29px;
  border:0;
  background-color:#DC143C;
  vertical-align:bottom;
  font-weight:bold;
  border-radius:1px;
}
.search_select{
  width:55px;
  height:25px;
  border:0;
  border-radius:1px;
}
<!--a태그 설정 -->
a {
  text-decoration:none;
 }
a:link {
  text-decoration:none;
  color: #fff;		
}
a:visited {
  text-decoration:none;
  color: #fff;
}
a:hover{
  color: #DC143C;
}
.d_btn{
  border:0;
  height:25px;
  background-color:#DC143C;
  border-radius:1px;
  font-weight:bold;
}
	.m5{margin:5px;}
	.mt10{margin:10px 0 0 0;}
	.m20{margin:20px;}
	.fl{float:left;}
	.tc{text-align:center;}
</style>
<script>
	$(document).on('click','#btnSearch',function(e){
		e.preventDefault();
		var url="${targetURL}";
		url = url+"?searchType="+$('#searchType').val();
		url = url+"&keyword="+$('#keyword').val();
		url = url+"&nowPage="+$('#nowPage').val();
		location.href = url;
		console.log(url);
	});
</script>
<body>
	<%@include file="../template/adminTop.jsp"%>
	
	
	<c:if test="${aId == null}">
		<script>			
			alert("관리자만 접근할 수 있습니다.");
			document.location.href="/";
		</script>
	</c:if>

	<h1 style="margin:0 0 0 30px;">관리자 모드</h1>
	
	<hr>
	
	<form action="/admin/delete">
	<div class="list">
		<div class="board">
			<span class="b_menu"></span>
			<span class="b_menu">pCode</span>
			<span class="b_menu">제목</span>
			<span class="b_menu">게시자</span>
			<span class="b_menu">업로드 일자</span>
		</div>
		<c:forEach items="${dtos}" var="dtos">
			<div class="board">
			 	<span class="line"><input name="pCodes" type="checkbox" value ="${dtos.pCode}"></span>
				<span class="line">${dtos.pCode}</span>
				<span class="line"><a href="/admin/view?pCode=${dtos.pCode}">${dtos.pName}</a></span>
				<span class="line">${dtos.aId}</span>
				<span class="line">${dtos.pUploadDate}</span>
			</div>
		</c:forEach>
		<div style="display:table-caption; caption-side:bottom;">

				<button type="submit" class="d_btn">삭제</button>
				<button type="reset" class="d_btn">초기화</button>
			
				<input type="button" onclick="location.href='uploadView'" value="업로드 작성" class="d_btn"/>
			
		</div>
	</div>
	</form>

	<div class="paging tc">
		<c:if test="${paging.startPage != 1}">
	 		<a href="/admin/list?nowPage=${paging.startPage -1}">&lt;</a>
	 	</c:if>
	 	<c:if test="${search.keyword == null}">
		 	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
		 		<c:choose>
		 			<c:when test="${p == paging.nowPage}">
		 				<b>${p}</b>	
		 			</c:when>
		 			<c:when test="${p != paging.nowPage}">
		 				<a href="/admin/list?nowPage=${p}">${p}</a>
		 			</c:when>
		 		</c:choose>
		 	</c:forEach>
	 	</c:if>
	 	<c:if test="${search.keyword != null}">
		 	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
		 		<c:choose>
		 			<c:when test="${p == paging.nowPage}">
		 				<b>${p}</b>	
		 			</c:when>
		 			<c:when test="${p != paging.nowPage}">
		 				<a href="/admin/list?searchType=${search.searchType}&keyword=${search.keyword}&nowPage=${p}">${p}</a>
		 			</c:when>
		 		</c:choose>
		 	</c:forEach>
	 	</c:if>
	 	<c:if test="${paging.startPage != paging.lastPage}">
	 		<a href="/admin/list?nowPage=${paging.startPage +1}">&gt;</a>
	 	</c:if>
	</div>

	<div class="search tc btn-m10">
		<select name="searchType" id="searchType" class="search_select">
			<option value="pName">제목</option>
			<option value="pContent">내용</option>
		</select>
		
		<input type="text" name="keyword" id="keyword" class="search_input">
		<input type="hidden" name="nowPage" id="nowPage" value="${paging.nowPage}">
		
		<c:url var="targetURL" value="/admin/list"></c:url>
		<button name="btnSearch" id="btnSearch" class="search_btn">검색</button>
	</div>

<%@include file="../template/bottom.jsp"%>

</body>
</html>
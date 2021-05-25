<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ page import="com.watching.dto.*"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<title>작품 업로드</title>
<style>
	body{
		background-color:black;
		line-height:2em;
		color:#fff;
		margin:30px;
		}
	.tc{
		text-align:left;
		padding:10px;
		}
	.board{
		width:900px;
		position: relative;
		display:table;
		margin:auto;
	}
	.row{
		display:table-row;
		position:relative;
    	padding: 0 auto;
		margin:5px;
	}
	.b_menu{
		margin:10px;
		display:table-cell;
		vertical-align:middle;
	}
	.content{
		margin:10px;
		display:table-cell;
		vertical-align:middle;
	}
	.form-control{
		width:300px;
	}
	.form-control-select{
		width:150px;
	}
	.btn{
		float:left;
		margin:5px;
		border:0;
		height:25px;
		background-color:#DC143C;
		border-radius:1px;
		font-weight:bold;
	}
	fieldset{
		width:900px;
	}
	.w70{width:70px;}
	.w500{width:500px;}
	.w200{width:200px;}
	.w120{width:120px;}
	.w100{width:100px;}	
</style>
</head>
<body>
	
	<h1 style="margin:0 0 0 30px;">작품 수정</h1>
	
	<hr>
	<form action="/admin/modify" method="post"> 
	<div class ="board">
	<fieldset>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="row">
			<span class="b_menu">pId</span>
 			<span class="content">
 				<input type="hidden" name="pId" id="pId" value="${dto.pId}"/>
 				${dto.pId}
 			</span>
		</div>
		<div class="row">
			<span class="b_menu">제목</span>
 			<span class="content">
 				<input type="text" name="pName" required="required" value="${dto.pName}" class="form-control">
 			</span>
		</div>
		<div class="row">
			<span class="b_menu">분류</span>
 			<span class="content">
 				<select name="cId" id="cId" class="form-control-select">
					<option value="국내드라마" ${dto.cId == '국내드라마' ? "selected='selected'" : ' '}>국내드라마</option>
					<option value="해외드라마" ${dto.cId == '해외드라마' ? "selected='selected'" : ' '}>해외드라마</option>
					<option value="국내영화" ${dto.cId == '국내영화' ? "selected='selected'" : ' '}>국내영화</option>
					<option value="해외영화" ${dto.cId == '해외영화' ? "selected='selected'" : ' '}>해외영화</option>
				</select>
 			</span>
		</div>
		<div class="row">
			<span class="b_menu">상세장르</span>
 			<span class="content">
 				<select name="tId" id="tId" class="form-control-select">
					<option value="로맨스/멜로" ${dto.tId == '로맨스/멜로' ? "selected='selected'" : ' '}>로맨스/멜로</option>
					<option value="코미디" ${dto.tId == '코미디' ? "selected='selected'" : ' '}>코미디</option>
					<option value="SF/판타지" ${dto.tId == 'SF/판타지' ? "selected='selected'" : ' '}>SF/판타지</option>
					<option value="어드벤쳐" ${dto.tId == '어드벤쳐' ? "selected='selected'" : ' '}>어드벤쳐</option>
					<option value="공포/스릴러" ${dto.tId == '공포/스릴러' ? "selected='selected'" : ' '}>공포/스릴러</option>
					<option value="미스터리" ${dto.tId == '미스터리' ? "selected='selected'" : ' '}>미스터리</option>
					<option value="드라마" ${dto.tId == '드라마' ? "selected='selected'" : ' '}>드라마</option>
					<option value="다큐멘터리" ${dto.tId == '다큐멘터리' ? "selected='selected'" : ' '}>다큐멘터리</option>
				</select>
 			</span>
		</div>
	</fieldset>
		<div>
			<input type="submit" value="수정" class="btn">
 			<input type="button" onclick="location.href='list'" value="목록보기" class="btn">
		</div>
	</div>
	</form>
</body>
</html>
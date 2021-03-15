<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.watching.dto.*"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작품 업로드</title>
</head>
<body>

		<h1>작품 업로드</h1>
	
	<hr>
	<form action="/admin/upload" method="post" enctype="multipart/form-data"> <fieldset>
	
	<table> 
		<tr>
			<th>관리자Id</th>
			<td><input type="text" class="form-control" name="bName" size="50"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="pName" required="required" placeholder="제목"></td>
		</tr>
		
		<tr>
			<th>분류</th>
			<td><select name="kCode" id="kCode" class="form-control">
				<option value="국내드라마">국내드라마</option>
				<option value="해외드라마">해외드라마</option>
				<option value="국내영화">국내영화</option>
				<option value="해외영화">해외영화</option>
				</select></td>
		</tr>
		
		<tr>				
			<th>상세장르</th>
			<td><select name="tCode" id="tCode" class="form-control">
				<option value="로맨스/멜로">로맨스/멜로</option>
				<option value="코미디">코미디</option>
				<option value="SF/판타지">SF/판타지</option>
				<option value="어드벤쳐">어드벤쳐</option>
				<option value="공포/스릴러">공포/스릴러</option>
				<option value="미스터리">미스터리</option>
				<option value="드라마">드라마</option>
				<option value="다큐멘터리">다큐멘터리</option>
				</select></td>
		</tr>

		<tr>
			<th>썸네일보기</th>
			<td><textarea rows="20" cols="40" name="content" required="required" placeholder="내용"></textarea></td>
		</tr>
		<tr>
			<th>썸네일</th>
			<td><input type="file" name="file" required="required"></td>
		</tr>
		<tr>
			<th>영상</th>
			<td><input type="file" name="file" required="required"></td>
		</tr>
		<tr>
			<td colspan="2"> <input type="submit" value="완료">
			<input type="button" onclick="location.href='list'" value="목록보기"></td>
		</tr>
		</table>
		</fieldset>
		</form>
		
		<form action="${path}/upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file">
			<input type="submit" value="업로드">
		</form>



</body>
</html>
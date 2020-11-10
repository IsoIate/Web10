<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/UpdateController" method="post">
		<table>
			<tr>
				<th>성적수정</th>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name"></td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input type="text" id="kor"></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type="text" id="mat"></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type="text" id="eng"></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>
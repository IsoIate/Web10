<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/CheckController" method="post">
		<table>
			<tr>
				<th>성적입력</th>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" name="number"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" disabled="disabled"></td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input type="text" disabled="disabled"></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type="text" disabled="disabled"></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type="text" disabled="disabled"></td>
			</tr>
			<tr>
				<td><input type="button" value="확인"></td>
			</tr>
		</table>
	</form>
</body>
</html>
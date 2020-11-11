<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		if(request.getAttribute("no") == null) {	// %>
	<form action="CheckController" method="post">
		<table>
			<tr>
				<th>성적조회</th>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" name="number"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" disabled="disabled"></td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input type="text" name="kor" disabled="disabled"></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input type="text" name="mat" disabled="disabled"></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input type="text" name="eng" disabled="disabled"></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
	<%} else { %>
	<table>
			<tr>
				<th>성적조회</th>
			</tr>
			<tr>
				<td>번호</td>
				<td><input value="<%= request.getAttribute("no") %>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input disabled="disabled" value="<%= request.getAttribute("name") %>"></td>
			</tr>
			<tr>
				<td>국어</td>
				<td><input disabled="disabled" value="<%= request.getAttribute("kor") %>"></td>
			</tr>
			<tr>
				<td>수학</td>
				<td><input disabled="disabled"value="<%= request.getAttribute("mat") %>"></td>
			</tr>
			<tr>
				<td>영어</td>
				<td><input disabled="disabled"value="<%= request.getAttribute("eng") %>"></td>
			</tr>
			<tr>
				<td><a href="index.jsp"><input type="button" value="돌아가기"></a></td>
			</tr>
		</table>
	<%} %>	
</body>
</html>
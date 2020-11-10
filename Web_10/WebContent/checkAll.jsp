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
	<form action="CheckAllController" method="post">
		<table>
			<tr>
				<th>성적조회</th>
			</tr>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>국어</td>
				<td>수학</td>
				<td>영어</td>
			</tr>
			<tr>
				<td><input type="text" name="number" disabled="disabled"></td>
				<td><input type="text" name="name" disabled="disabled"></td>
				<td><input type="text" name="kor" disabled="disabled"></td>
				<td><input type="text" name="mat" disabled="disabled"></td>
				<td><input type="text" name="eng" disabled="disabled"></td>
			</tr>
			<tr>
				<td><input type="text" name="number" disabled="disabled"></td>
				<td><input type="text" name="name" disabled="disabled"></td>
				<td><input type="text" name="kor" disabled="disabled"></td>
				<td><input type="text" name="mat" disabled="disabled"></td>
				<td><input type="text" name="eng" disabled="disabled"></td>
			</tr>
			<tr>
				<td><input type="text" name="number" disabled="disabled"></td>
				<td><input type="text" name="name" disabled="disabled"></td>
				<td><input type="text" name="kor" disabled="disabled"></td>
				<td><input type="text" name="mat" disabled="disabled"></td>
				<td><input type="text" name="eng" disabled="disabled"></td>				
			</tr>
			<tr>
				<td><input type="text" name="number" disabled="disabled"></td>
				<td><input type="text" name="name" disabled="disabled"></td>
				<td><input type="text" name="kor" disabled="disabled"></td>
				<td><input type="text" name="mat" disabled="disabled"></td>
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
				<td>이름</td>
				<td>국어</td>
				<td>수학</td>
				<td>영어</td>
			</tr>
			<tr>
				<td><input value="<%= request.getAttribute("no") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("name") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("kor") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("mat") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("eng") %>" disabled="disabled"></td>
			</tr>
			<tr>
				<td><input value="<%= request.getAttribute("no") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("name") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("kor") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("mat") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("eng") %>" disabled="disabled"></td>
			</tr>
			<tr>
				<td><input value="<%= request.getAttribute("no") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("name") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("kor") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("mat") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("eng") %>" disabled="disabled"></td>		
			</tr>
			<tr>
				<td><input value="<%= request.getAttribute("no") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("name") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("kor") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("mat") %>" disabled="disabled"></td>
				<td><input value="<%= request.getAttribute("eng") %>" disabled="disabled"></td>		
			</tr>
			<tr>
				<td><input type="button" value="확인"></td>
			</tr>
		</table>
	<%} %>
</body>
</html>
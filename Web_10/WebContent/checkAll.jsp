<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="demo.DTOStudent" %>
<%  
	ArrayList<DTOStudent> list = (ArrayList)request.getAttribute("list");	// CheckAllController클래스에서 받은 Attribute를 list에 담음
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getAttribute("list") == null) {	// 처음 실행했을 때  %>	
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
			<% for(int i = 0; i < 4; i++) { %>
			<tr>
				<td><input disabled="disabled"></td>
				<td><input disabled="disabled"></td>
				<td><input disabled="disabled"></td>
				<td><input disabled="disabled"></td>
				<td><input disabled="disabled"></td>
			</tr>
			<%} %>
			<tr>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
	<%} else { // list의 값을 조회했을 때  %>
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
			<%
				for(int i = 0; i < list.size(); i++) {
				// 리스트의 i번째의 특정 컬럼의 값 조회
			%>
				<td><input value="<%= list.get(i).getNumber() %>" disabled="disabled"></td>
				<td><input value="<%= list.get(i).getName() %>" disabled="disabled"></td>
				<td><input value="<%= list.get(i).getKor() %>" disabled="disabled"></td>
				<td><input value="<%= list.get(i).getMat() %>" disabled="disabled"></td>
				<td><input value="<%= list.get(i).getEng() %>" disabled="disabled"></td>
			</tr>
			<%} %>
			<tr>
				<td><a href="index.jsp"><input type="button" value="돌아가기"></a></td>
			</tr>
		</table>
	<%} %>
</body>
</html>
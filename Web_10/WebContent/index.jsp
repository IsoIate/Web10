<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.body {
		position: relative;
	}
	.table {
		border: 1px solid black;
		position: absolute;
		top:10%; left: 37%;
		margin: 0 auto;
		width: 500px;
		text-align: center;
	}
	#th { font-size: 24px; }
	#td {
		padding-left: 350px;
		font-size: 16px;
		border-bottom: 1px solid black;
	}
	
	a { text-decoration: none; font-weight: bold; }
	a:link { color: black; font-weight: bold; }
	a:visited { color: black; font-weight: bold; }
	a:hover { color: blue; font-weight: bold; }
</style>
</head>
<body>
	<table class="table">
		<tr>
			<th id="th" colspan="4">웹 프로그래밍 10주차 과제</th>
		</tr>
		<tr>
			<td id="td" colspan="4">20151184 전현준</td>
		</tr>
		<tr>
			<td rowspan="4"><a href="insert.jsp">성적입력</a></td>
			<td><a href="check.jsp">성적조회</a></td>
			<td><a href="update.jsp">성적수정</a></td>
			<td><a href="checkAll.jsp">전체조회</a></td>
		</tr>
	</table>
</body>
</html>
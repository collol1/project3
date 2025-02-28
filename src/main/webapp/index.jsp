<!-- <a href="empform">Add Employee</a>
<a href="view">View Employees</a>l> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="with=device-with, initial-scale=1.0">
<title>Trang jsp demo</title>
</head>
<body>
<div class="header">
<h1>chào mừng đến với jsp</h1>
</div>
<div class="content">
<%
String message ="hello, jsp!";
out.print("<p>"+message+"</p>");
%>
</div>
<a href="saveform">đến Menu chức năng</a>
<div class="footer">
<p>&copy; 2024 Trang web của bạn</p>
</div>
</body>
</html>
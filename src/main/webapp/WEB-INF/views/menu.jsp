<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu động</title>
</head>
<body>
<nav>
<ul>
<c:forEach items="${menuItems}" var="item">
<li>

<a href="${item.url}">${item.name}</a>
</li>
</c:forEach>
</ul>
</nav>
</body>
</html>
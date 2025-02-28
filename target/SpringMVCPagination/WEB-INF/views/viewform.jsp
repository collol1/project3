<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>user</th>
		<th>email</th>
		<th>phone</th>
		<th>role</th>
		<th>Edit</th>
		<th>Delete</th>
		
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.UserId}</td>
			<td>${user.FullName}</td>
			<td>${user.Email}</td>
			<td>${user.Phone}</td>
			<td>${user.Role}</td>
			<td><a href="edituser/${user.UserId}">Edit</a></td>
			<td><a href="deleteuser/${user.UserId}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="editform">Add New Employee</a>
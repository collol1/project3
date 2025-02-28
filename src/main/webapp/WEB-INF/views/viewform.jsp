<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>UserId</th>
		<th>FullName</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Role</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.userId}</td>
			<td>${user.fullName}</td>
			<td>${user.email}</td>
			<td>${user.phone}</td>
			<td>${user.role}</td>
			<td><a href="edituser/${user.userId}">Edit</a></td>
			<td><a href="deleteuser/${user.userId}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="editform">Add New Employee</a>

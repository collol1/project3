<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Employee</h1>
<form:form method="post" action="save">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="FullName" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="Email" /></td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td><form:input path="Phone" /></td>
		</tr>
		<tr>
			<td>Role :</td>
			<td><form:input path="Role" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="edit" /></td>
		</tr>
	</table>
</form:form>

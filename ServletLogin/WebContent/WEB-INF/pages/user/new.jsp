<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
	<c:set value="${pageContext.request.contextPath}" var="context"></c:set>
	<jsp:include page="/WEB-INF/pages/template/menu.jsp"></jsp:include>
	<form action="${context}/application/users/save" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${name}" /></td>
			</tr>
			<tr>
				<td>${nameError}</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value="${password}" /></td>
			</tr>
			<tr>
				<td>${passwordError}</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstname" value="${firstname}" /></td>
			</tr>
			<tr>
				<td>${firstnameError}</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastname" value="${lastname}" /></td>
			</tr>
			<tr>
				<td>${lastnameError}</td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
			<tr>
				<td>${userExistsError}</td>
			</tr>
		</table>

	</form>


</body>
</html>
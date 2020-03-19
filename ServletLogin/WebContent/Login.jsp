<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	<jsp:include page="/WEB-INF/pages/template/menu.jsp"></jsp:include>

	<form action="${contextPath}/application/loginvalidation" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>${errorUsername}</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>${errorPassword}</td>
			</tr>
			<tr>
				<td><input type="submit" value="login" /></td>
			</tr>

		</table>
	</form>
	<div>${loginError}</div>

</body>
</html>
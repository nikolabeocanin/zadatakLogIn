<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:url value="/application/users/all" var="userAll"></c:url>
<c:url value="/application/users/add" var="userNew"></c:url>
<c:url value="/application/users/login" var="userLogged"></c:url>
<c:url value="/application/login" var="login"></c:url>
<c:url value="/application/logout" var="logout"></c:url>

<a href="${login}">Login</a>
<br>
<a href="${userAll}">All User Accounts</a>
<br>
<a href="${userNew}">New User Account</a>
<br>
<a href="${userLogged}">Logged users</a>
<br>

<a href="${logout}">Logout</a>

<p>${loggedError}</p>






</body>
</html>
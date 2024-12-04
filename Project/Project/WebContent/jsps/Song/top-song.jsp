<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song Database</title>
</head>
<body>
<h1> Song Database</h1>
	<a href="<c:url value='add-song.jsp'/>" target="_parent">Add Song </a>  |
	<a href="<c:url value='edit-song.jsp'/>" target="_parent">Update Song </a> |
	<a href="<c:url value='delete-song.jsp'/>" target="_parent">Delete Song </a><br>
	<a href="<c:url value='all-song.jsp'/>" target="_parent">All Songs </a> |
	
</html>
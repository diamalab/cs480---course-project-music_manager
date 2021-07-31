<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Album Database</title>
</head>
<body>
<h1> Album Database</h1>
	<a href="<c:url value='add-album.jsp'/>" target="_parent">Add Album </a>  |
	<a href="<c:url value='edit-album.jsp'/>" target="_parent">Update Album </a> |
	<a href="<c:url value='delete-album.jsp'/>" target="_parent">Delete Album </a><br>
	<a href="<c:url value='all-album.jsp'/>" target="_parent">All Albums </a> |
	
</html>
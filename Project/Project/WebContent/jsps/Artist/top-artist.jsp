<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist Database</title>
</head>
<body>
<h1> Artist Database</h1>
	<a href="<c:url value='add-artist.jsp'/>" target="_parent">Add Artist </a>  |
	<a href="<c:url value='edit-artist.jsp'/>" target="_parent">Update Artist </a> |
	<a href="<c:url value='delete-artist.jsp'/>" target="_parent">Delete Artist </a><br>
	<a href="<c:url value='all-artist.jsp'/>" target="_parent">All Artist </a> |
	
</html>
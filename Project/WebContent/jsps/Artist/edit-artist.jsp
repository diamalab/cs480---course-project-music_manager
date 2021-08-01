<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Artist</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Edit Artist</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ArtistServletUpate'/>" method="post">
	<input type="hidden" name="action" value="update"/>

	Artist ID:   <input type="text" name="artist_id" value="${form.artist_id}"/>
	Artist Name:    :<input type="text" name="artist_name" value="${form.artist_name}" />
	Artist Email    :<input type="text" name="artist_email" value="${form.artist_email }"/>
		
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	<input type="submit" value="Update"/>
</form> 
  </body>
</html>
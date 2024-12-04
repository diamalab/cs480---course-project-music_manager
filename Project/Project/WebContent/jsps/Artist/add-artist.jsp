<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add Artist</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  <h1>Add Artist</h1>
<p style="color: blue; font-weight: 900">${msg }</p>
<form action="<c:url value='/ArtistServletAdd'/>" method="post">
	<input type="hidden" name="method" value="add"/>	
	Artist ID:    :<input type="text" name="artist_id" value="${form.artist_id }"/> 
	<br/>
	Artist Name    :<input type="text" name="artist_name" value="${form.artist_name }"/>
	<span style="color: red; font-weight: 900">${errors.artist_name }</span>
	<br/>
	Artist Email  :<input type="text" name="artist_email" value="${form.artist_email }"/>
	<span style="color: red; font-weight: 900">${errors.artist_email }</span>

	<input type="submit" value="Add"/>
</form> 
  </body>
</html>
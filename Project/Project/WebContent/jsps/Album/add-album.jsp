<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add Album</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  <h1>Add Album</h1>
<p style="color: blue; font-weight: 900">${msg }</p>
<form action="<c:url value='/AlbumServletAdd'/>" method="post">
	<input type="hidden" name="method" value="add"/>	
	Album ID:    :<input type="text" name="album_id" value="${form.album_id }"/> 
	<br/>
	Album Name    :<input type="text" name="album_name" value="${form.album_name }"/>
	<span style="color: red; font-weight: 900">${errors.artist_name }</span>
	<br/>
	Artist ID	:<input type="text" name="artist_id" value="${form.artist_id }"/>
	<span style="color: red; font-weight: 900">${errors.artist_name }</span>
	<br/>
	Genre  :<input type="text" name="genre" value="${form.genre }"/>
	<span style="color: red; font-weight: 900">${errors.artist_email }</span>

	<input type="submit" value="Add"/>
</form> 
  </body>
</html>
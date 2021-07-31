<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit Song</title>
    
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
  <h1>Edit Song</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/SongServletUpdate'/>" method="post">
	<input type="hidden" name="action" value="update"/>

	Song ID:   <input type="text" name="song_id" value="${form.song_id}"/>
	Song Name:    :<input type="text" name="song_name" value="${form.song_name}" />
	Artist ID    :<input type="text" name="artist_id" value="${form.artist_id }"/>
	Album ID    :<input type="text" name="album_id" value="${form.album_id}"/>
	
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	<input type="submit" value="Update"/>
</form> 
  </body>
</html>
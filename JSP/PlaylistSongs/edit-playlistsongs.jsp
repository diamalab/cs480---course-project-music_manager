<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Edit PlaylistSongs</title>
    
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
  <h1>Edit PlaylistSongs</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/PlaylistSongsServletUpdate'/>" method="post">
	<input type="hidden" name="action" value="update"/>
	<input type="hidden" name="playlist__songs_id" value=${sessionScope.session_user.playlist_songs_id }/>

	Playlist Songs ID:   <input type="text" name="playlist_songs_id" value="${form.playlist_songs_id }"/>
	Playlist ID:    :<input type="text" name="playlist_id" value="${form.playlist_id}" />" />  
	Song ID    :<input type="text" name="song_id" value="${form.song_id }"/>
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	<input type="submit" value="Update"/>
</form> 
  </body>
</html>